package ai.quantumsense.tgmonitor.backend;

import java.util.Set;

public interface PatternMatcher {
    /**
     * Check a Telegram message for each of the specified set of patterns.
     * @param message The Telegram message to check.
     * @param patterns The set of patterns to check the Telegram message for.
     * @return The subset of 'patterns' that match the Telegram message, or
     * null, if there is no pattern match.
     */
    Set<String> match(TelegramMessage message, Set<String> patterns);
}
