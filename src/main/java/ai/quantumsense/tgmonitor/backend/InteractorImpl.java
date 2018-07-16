package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;
import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;

public class InteractorImpl implements Interactor{

    private PatternMatcher matcher;
    private Notificator notificator;

    public InteractorImpl(PatternMatcher matcher, Notificator notificator, ServiceLocator<Interactor> interactorLocator) {
        this.matcher = matcher;
        this.notificator = notificator;
        interactorLocator.registerService(this);
    }

    @Override
    public void messageReceived(TelegramMessage msg) {
        matcher.newMessage(msg);
    }

    @Override
    public void matchFound(PatternMatch match) {
        notificator.notify(match);
    }
}
