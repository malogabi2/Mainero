/*
 * Decompiled with CFR 0_124.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.cms.CMSException
 *  org.bouncycastle.cms.CMSProcessable
 *  org.bouncycastle.cms.CMSProcessableByteArray
 *  org.bouncycastle.cms.CMSSignedData
 *  org.bouncycastle.cms.CMSSignedDataGenerator
 *  org.bouncycastle.jce.provider.BouncyCastleProvider
 */
package wsa.coneccion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import wsa.coneccion.ConeccionWSA;
import wsa.metodo.WsaXML;

public class Encriptador {
    private X509Certificate certificado;
    private PrivateKey clavePrivada;
    private String cuit;
    private String XMLMensaje;

    public byte[] create_cms(ConeccionWSA cone) throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, InvalidAlgorithmParameterException, NoSuchProviderException, CertStoreException, CMSException {
        byte[] asn1_cms = null;
        CertStore cstore = null;
        KeyStore ks = KeyStore.getInstance("pkcs12");
        FileInputStream p12stream = new FileInputStream(cone.getArchivoKeyStore());
        ks.load(p12stream, cone.getClaveDesencriptacionPrivada().toCharArray());
        p12stream.close();
        this.setClavePrivada((PrivateKey)ks.getKey(cone.getClaveDesencriptacionPublica(), cone.getClaveDesencriptacionPrivada().toCharArray()));
        this.setCertificado((X509Certificate)ks.getCertificate(cone.getClaveDesencriptacionPublica()));
        this.setCuit(this.getCertificado().getSubjectDN().toString());
        ArrayList<X509Certificate> certList = new ArrayList<X509Certificate>();
        certList.add(this.getCertificado());
        if (Security.getProvider("BC") == null) {
            Security.addProvider((Provider)new BouncyCastleProvider());
        }
        cstore = CertStore.getInstance("Collection", (CertStoreParameters)new CollectionCertStoreParameters(certList), "BC");
        this.setXMLMensaje(WsaXML.create_LoginTicketRequest(this.getCuit(), cone.getLineaConecion(), cone.getServicio(), cone.getTiketTiempo()));
        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
        gen.addSigner(this.getClavePrivada(), this.getCertificado(), CMSSignedDataGenerator.DIGEST_SHA256);
        gen.addCertificatesAndCRLs(cstore);
        CMSProcessableByteArray data = new CMSProcessableByteArray(this.getXMLMensaje().getBytes());
        CMSSignedData signed = gen.generate((CMSProcessable)data, true, "BC");
        asn1_cms = signed.getEncoded();
        return asn1_cms;
    }

    public String getCuit() {
        return this.cuit;
    }

    private void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getXMLMensaje() {
        return this.XMLMensaje;
    }

    private void setXMLMensaje(String XMLMensaje) {
        this.XMLMensaje = XMLMensaje;
    }

    public X509Certificate getCertificado() {
        return this.certificado;
    }

    private void setCertificado(X509Certificate certificado) {
        this.certificado = certificado;
    }

    public PrivateKey getClavePrivada() {
        return this.clavePrivada;
    }

    private void setClavePrivada(PrivateKey clavePrivada) {
        this.clavePrivada = clavePrivada;
    }
}

