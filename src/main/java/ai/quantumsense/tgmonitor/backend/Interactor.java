package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.datastruct.PatternMatch;
import ai.quantumsense.tgmonitor.backend.datastruct.TelegramMessage;

public interface Interactor {
    void messageReceived(TelegramMessage msg);
    void matchFound(PatternMatch match);
}
