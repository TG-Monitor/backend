package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;
import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;

public interface Interactor {
    void messageReceived(TelegramMessage msg);
    void matchFound(PatternMatch match);
}
