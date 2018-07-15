package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;
import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InteractorImpl implements Interactor{

    private final static Logger LOG = LogManager.getLogger(InteractorImpl.class);

    private PatternMatcher matcher;
    private Notificator notificator;

    public InteractorImpl(PatternMatcher matcher, Notificator notificator, ServiceLocator<Interactor> interactorLocator) {
        this.matcher = matcher;
        this.notificator = notificator;
        interactorLocator.registerService(this);
    }

    // Called by multiple threads from Telethon component
    @Override
    public void messageReceived(TelegramMessage msg) {
        LOG.debug("Message received: " + msg.getText());
        matcher.newMessage(msg);
    }

    @Override
    public void matchFound(PatternMatch match) {
        LOG.debug("Pattern match found in: " + match.getMessage());
        notificator.notify(match);
    }
}
