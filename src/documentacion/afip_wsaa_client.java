/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  javax.xml.rpc.Call
 *  javax.xml.rpc.ParameterMode
 *  org.apache.axis.client.Call
 *  org.apache.axis.client.Service
 *  org.apache.axis.encoding.Base64
 *  org.apache.axis.encoding.XMLType
 *  org.bouncycastle.cms.CMSProcessable
 *  org.bouncycastle.cms.CMSProcessableByteArray
 *  org.bouncycastle.cms.CMSSignedData
 *  org.bouncycastle.cms.CMSSignedDataGenerator
 *  org.bouncycastle.jce.provider.BouncyCastleProvider
 */
package documentacion;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.Base64;
import org.apache.axis.encoding.XMLType;
import org.apache.log4j.Priority;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import utiles.logger.LoggerBitacora;

public class afip_wsaa_client {
    static String invoke_wsaa(byte[] LoginTicketRequest_xml_cms, String endpoint) throws Exception {
        String LoginTicketResponse = null;
        try {
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(new URL(endpoint));
            call.setOperationName("loginCms");
            call.addParameter("request", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);
            LoginTicketResponse = (String)call.invoke(new Object[]{Base64.encode((byte[])LoginTicketRequest_xml_cms)});
        }
        catch (MalformedURLException | RemoteException | ServiceException e) {
            LoggerBitacora.getInstance(afip_wsaa_client.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al conectarse con afip_wsaa", e);
        }
        return LoginTicketResponse;
    }

    public static byte[] create_cms(String p12file, String p12pass, String signer, String dstDN, String service, Long TicketTime) {
        PrivateKey pKey = null;
        X509Certificate pCertificate = null;
        byte[] asn1_cms = null;
        CertStore cstore = null;
        String SignerDN = null;
        try {
            KeyStore ks = KeyStore.getInstance("pkcs12");
            FileInputStream p12stream = new FileInputStream(p12file);
            ks.load(p12stream, p12pass.toCharArray());
            p12stream.close();
            pKey = (PrivateKey)ks.getKey(signer, p12pass.toCharArray());
            pCertificate = (X509Certificate)ks.getCertificate(signer);
            SignerDN = pCertificate.getSubjectDN().toString();
            ArrayList<X509Certificate> certList = new ArrayList<X509Certificate>();
            certList.add(pCertificate);
            if (Security.getProvider("BC") == null) {
                Security.addProvider((Provider)new BouncyCastleProvider());
            }
            cstore = CertStore.getInstance("Collection", (CertStoreParameters)new CollectionCertStoreParameters(certList), "BC");
        }
        catch (IOException | InvalidAlgorithmParameterException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableKeyException | CertificateException e) {
            LoggerBitacora.getInstance(afip_wsaa_client.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al encriptar", e);
        }
        String LoginTicketRequest_xml = afip_wsaa_client.create_LoginTicketRequest(SignerDN, dstDN, service, TicketTime);
        try {
            CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
            gen.addSigner(pKey, pCertificate, CMSSignedDataGenerator.DIGEST_SHA1);
            gen.addCertificatesAndCRLs(cstore);
            CMSProcessableByteArray data = new CMSProcessableByteArray(LoginTicketRequest_xml.getBytes());
            CMSSignedData signed = gen.generate((CMSProcessable)data, true, "BC");
            asn1_cms = signed.getEncoded();
        }
        catch (Exception e) {
             LoggerBitacora.getInstance(afip_wsaa_client.class).logueadorMainero.log("un Mensaje", Priority.ERROR,
                        "Error al encriptar", e);
            
        }
        return asn1_cms;
    }

    public static String create_LoginTicketRequest(String SignerDN, String dstDN, String service, Long TicketTime) {
        Date GenTime = new Date();
        GregorianCalendar gentime = new GregorianCalendar();
        GregorianCalendar exptime = new GregorianCalendar();
        String UniqueId = new Long(GenTime.getTime() / 1000L).toString();
        exptime.setTime(new Date(GenTime.getTime() + TicketTime));
        XMLGregorianCalendarImpl XMLGenTime = new XMLGregorianCalendarImpl(gentime);
        XMLGregorianCalendarImpl XMLExpTime = new XMLGregorianCalendarImpl(exptime);
        String LoginTicketRequest_xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><loginTicketRequest version=\"1.0\"><header><source>" + SignerDN + "</source>" + "<destination>" + dstDN + "</destination>" + "<uniqueId>" + UniqueId + "</uniqueId>" + "<generationTime>" + XMLGenTime + "</generationTime>" + "<expirationTime>" + XMLExpTime + "</expirationTime>" + "</header>" + "<service>" + service + "</service>" + "</loginTicketRequest>";
        return LoginTicketRequest_xml;
    }
}

