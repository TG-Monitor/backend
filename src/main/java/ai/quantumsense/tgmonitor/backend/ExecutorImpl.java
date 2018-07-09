package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.monitor.Executor;
import ai.quantumsense.tgmonitor.monitor.Monitor;

import java.util.Timer;

public class ExecutorImpl implements Executor {

    private Monitor monitor;
    private Telegram telegram;

    private boolean running = false;
    private Timer timer = new Timer();

    public ExecutorImpl(Monitor monitor, Telegram telegram) {
        this.monitor = monitor;
        this.telegram = telegram;
    }

//    @Override
//    public void start(int intervalInSeconds) {
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                interactor.processNewMessages(telegram.getNewMessages(monitor.getPeers()));
//            }
//        }, 0, intervalInSeconds * 1000);
//        running = true;
//    }
//
//    @Override
//    public void pause() {
//        timer.cancel();
//        running = false;
//    }
//
//    @Override
//    public boolean isRunning() {
//        return running;
//    }


    @Override
    public void startAll() {
        for (String p : monitor.getPeers())
            start(p);
    }

    @Override
    public void stopAll() {
        for (String p : monitor.getPeers())
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
}
