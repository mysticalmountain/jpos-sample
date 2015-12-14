package com.sample;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOUtil;
import org.jpos.q2.Q2;
import org.jpos.q2.QBean;
import org.jpos.util.Log;

/**
 * User: andongxu
 * Time: 15-12-14 下午4:06
 */
public class QTest implements QBean, Configurable {

    private Log log;
    private volatile int state;

    public QTest() {
        state = -1;
        log = Log.getLog(Q2.LOGGER_NAME, "QTEST");
        log.info("constructor");
    }

    @Override
    public void init() throws Exception {
        log.info("initializing");
        state = QBean.STARTING;
    }

    @Override
    public void start() throws Exception {
        log.info("starting");
    }

    @Override
    public void stop() throws Exception {
        log.info("stopping");
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroying");
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public String getStateAsString() {
        return state >= 0 ? QBean.stateString[state] : "Unknown";
    }

    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
