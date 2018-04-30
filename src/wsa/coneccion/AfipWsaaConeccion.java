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
 */
package wsa.coneccion;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.Base64;
import org.apache.axis.encoding.XMLType;

public class AfipWsaaConeccion {
    static String llamadoWsaa(byte[] LoginTicketRequest_xml_cms, String endpoint) throws Exception {
        String LoginTicketResponse = null;
        Service service = new Service();
        Call call = (Call)service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
        call.setOperationName("loginCms");
        call.addParameter("request", XMLType.XSD_STRING, ParameterMode.IN);
        call.setReturnType(XMLType.XSD_STRING);
        LoginTicketResponse = (String)call.invoke(new Object[]{Base64.encode((byte[])LoginTicketRequest_xml_cms)});
        return LoginTicketResponse;
    }
}

