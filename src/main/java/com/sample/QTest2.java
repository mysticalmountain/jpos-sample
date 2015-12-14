package com.sample;

import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.q2.Q2;
import org.jpos.q2.QBean;
import org.jpos.q2.QBeanSupport;
import org.jpos.util.Log;

/**
 * User: andongxu
 * Time: 15-12-14 下午4:46
 */
public class QTest2 extends QBeanSupport {

    private Log log;
    private volatile int state;

    public QTest2() {
        state = -1;
        log = Log.getLog(Q2.LOGGER_NAME, "QTEST");
        log.info("constructor");
    }

    @Override
    public void init() {
        log.info("initializing");
        state = QBean.STARTING;
    }

    @Override
    public void start() {
        log.info("starting");
    }

    @Override
    public void stop() {
        log.info("stopping");
    }

    @Override
    public void destroy() {
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
}
