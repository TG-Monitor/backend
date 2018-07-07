package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.datastructures.PatternMatch;

public interface Notificator {
    void notify(PatternMatch match);
}
