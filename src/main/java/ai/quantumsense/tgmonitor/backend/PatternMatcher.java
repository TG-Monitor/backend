package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.datastructures.TelegramMessage;

public interface PatternMatcher {
    void newMessage(TelegramMessage msg);
}
