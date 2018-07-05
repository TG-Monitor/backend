package ai.quantumsense.tgmonitor.backend;

import java.util.Set;

public interface Notificator {
    void notifyPatternMatch(TelegramMessage message, Set<String> patterns);
}
