package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.monitor.control.Executor;
import ai.quantumsense.tgmonitor.monitor.data.MonitorDataFactory;

import java.util.Set;
import java.util.Timer;

public class ExecutorImpl implements Executor {

    private Telegram telegram;
    private MonitorDataFactory monitorDataFactory;

    private boolean running = false;
    private Timer timer = new Timer();

    public ExecutorImpl(Telegram telegram, MonitorDataFactory monitorDataFactory) {
        this.telegram = telegram;
        this.monitorDataFactory = monitorDataFactory;
    }

    @Override
    public void startAll() {
        for (String p : peers())
            start(p);
    }

    @Override
    public void stopAll() {
        for (String p : peers())
            stop(p);
    }

    @Override
    public void start(String peer) {
        telegram.start(peer);
    }

    @Override
    public void stop(String peer) {
        telegram.stop(peer);
    }

    private Set<String> peers() {
        return monitorDataFactory.getMonitorData().getPeers();
    }
}
