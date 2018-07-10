package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.pojo.TelegramMessage;

public interface PatternMatcher {
    void newMessage(TelegramMessage msg);
}
