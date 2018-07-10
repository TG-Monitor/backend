package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.pojo.PatternMatch;

public interface Notificator {
    void notify(PatternMatch match);
}
