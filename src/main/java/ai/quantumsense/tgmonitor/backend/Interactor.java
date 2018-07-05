package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.monitor.Monitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Interactor {

    private final static Logger LOG = LogManager.getLogger(Interactor.class);

    private Monitor monitor;
    private PatternMatcher matcher;
    private Notificator notificator;


    public Interactor(Monitor monitor, PatternMatcher matcher, Notificator notificator) {
        this.monitor = monitor;
        this.matcher = matcher;
        this.notificator = notificator;
    }

    void processNewMessages(Map<String, List<TelegramMessage>> newMessages) {
        Set<String> patterns = monitor.getPatterns();
        for (Map.Entry<String, List<TelegramMessage>> entry : newMessages.entrySet()) {
            LOG.debug("Processing " + entry.getKey() + " messages:");
            for (TelegramMessage message : entry.getValue()) {
                LOG.debug(message.toString());
                Set<String> matchingPatterns = matcher.match(message, patterns);
                if (matchingPatterns != null) {
                    LOG.debug("** Matches the following patterns: " + String.join(", ", matchingPatterns));
                    notificator.notifyPatternMatch(message, matchingPatterns);
                }
            }
        }
    }
}
