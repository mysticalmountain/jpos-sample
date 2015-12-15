package com.sample.server;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.q2.Q2;
import org.jpos.util.Log;
import org.jpos.util.NameRegistrar;

/**
 * ISOServer 接收ISO消息
 * User: andongxu
 * Time: 15-12-15 下午3:14
 */
public class ISOServer implements ISORequestListener {

    private Log log = Log.getLog(Q2.LOGGER_NAME, "server");

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        try {
            log.info("receive message:" + new String(isoMsg.pack()));
            ISOMsg isoMessageResponse = (ISOMsg) isoMsg.clone();
            isoMessageResponse.set(39, "00");
            isoSource.send(isoMessageResponse);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
