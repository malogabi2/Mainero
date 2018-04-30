/*
 * Decompiled with CFR 0_124.
 */
package wsa.metodo;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.util.Date;
import java.util.GregorianCalendar;

public class WsaXML {
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

