package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.datastruct.TelegramMessage;

public interface PatternMatcher {
    void newMessage(TelegramMessage msg);
}
