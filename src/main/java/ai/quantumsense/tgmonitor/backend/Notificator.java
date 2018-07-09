package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.datastruct.PatternMatch;

public interface Notificator {
    void notify(PatternMatch match);
}
