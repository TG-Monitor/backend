package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.monitor.Executor;
import ai.quantumsense.tgmonitor.monitor.Monitor;

import java.util.Timer;
import java.util.TimerTask;

public class ExecutorImpl implements Executor {

    private Monitor monitor;
    private Interactor interactor;
    private TelegramApi telegramApi;

    private boolean running = false;
    private Timer timer = new Timer();

    public ExecutorImpl(Monitor monitor, Interactor interactor, TelegramApi telegramApi) {
        this.monitor = monitor;
        this.interactor = interactor;
        this.telegramApi = telegramApi;
    }

    @Override
    public void start(int intervalInSeconds) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                interactor.processNewMessages(telegramApi.getNewMessages(monitor.getPeers()));
            }
        }, 0, intervalInSeconds * 1000);
        running = true;
    }

    @Override
    public void pause() {
        timer.cancel();
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }


}
