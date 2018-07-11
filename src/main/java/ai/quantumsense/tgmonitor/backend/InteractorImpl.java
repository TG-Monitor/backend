package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InteractorImpl implements Interactor{

    private final static Logger LOG = LogManager.getLogger(InteractorImpl.class);

    private static Interactor instance = null;

    private PatternMatcher matcher;
    private Notificator notificator;

    public static Interactor get() {
        return instance;
    }

    public InteractorImpl(PatternMatcher matcher, Notificator notificator) {
        this.matcher = matcher;
        this.notificator = notificator;
        instance = this;
    }

    // Called by multiple threads from Telethon component
    @Override
    public void messageReceived(TelegramMessage msg) {
        matcher.newMessage(msg);
    }

    @Override
    public void matchFound(PatternMatch match) {
        notificator.notify(match);
    }
}
