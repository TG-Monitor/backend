package ai.quantumsense.tgmonitor.backend.pojo;

import java.util.Set;

public class PatternMatch {
    private TelegramMessage msg;
    private Set<String> patterns;

    public PatternMatch(TelegramMessage msg, Set<String> patterns) {
        this.msg = msg;
        this.patterns = patterns;
    }

    public TelegramMessage getMessage() {
        return msg;
    }

    public Set<String> getPatterns() {
        return patterns;
    }
}
