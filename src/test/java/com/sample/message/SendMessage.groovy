package com.sample.message

import org.jpos.iso.BaseChannel
import org.jpos.iso.ISOException
import org.jpos.iso.ISOMsg
import org.jpos.iso.ISOPackager
import org.jpos.iso.channel.ASCIIChannel
import org.jpos.iso.channel.XMLChannel
import org.jpos.iso.packager.ISO87APackager
import org.jpos.iso.packager.XMLPackager
import org.jpos.util.SimpleLogListener

/**
 * User: andongxu
 * Time: 15-12-15 下午3:26 
 */
class SendMessage {

    public static void main(String[] args) throws Exception {
        String ip = "localhost";
        Integer port = 10000;
        ISOMsg msg = ISOMsgHelper.createEchoRequest();
        ISOPackager packager = new XMLPackager();
        XMLChannel channel = new XMLChannel(ip, port, packager);
        org.jpos.util.Logger jposLogger = new org.jpos.util.Logger();
        SimpleLogListener log4JListener = new SimpleLogListener();
        jposLogger.addListener(log4JListener);
        channel.setLogger(jposLogger, "client-channel");
        kirimConnectionless(msg, channel);
    }

    private static void kirimConnectionless(ISOMsg msg, BaseChannel channel) throws IOException, ISOException {
        channel.connect();
        channel.setTimeout(30000);
        channel.send(msg);
        ISOMsg reply = channel.receive();
        System.out.println("Reply : [" + new String(reply.pack()) + "]");
        channel.disconnect();
    }
}
