package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.backend.datastruct.PatternMatch;
import ai.quantumsense.tgmonitor.backend.datastruct.TelegramMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Interactor {

    private final static Logger LOG = LogManager.getLogger(Interactor.class);

    private PatternMatcher matcher;
    private Notificator notificator;


    public Interactor(PatternMatcher matcher, Notificator notificator) {
        this.matcher = matcher;
        this.notificator = notificator;
    }

    // Called by multiple threads from Telethon component
    public void messageReceived(TelegramMessage msg) {
        matcher.newMessage(msg);
    }

    public void matchFound(PatternMatch match) {
        notificator.notify(match);
    }

//    void processNewMessages(Map<String, List<TelegramMessage>> newMessages) {
//        Set<String> patterns = monitor.getPatterns();
//        for (Map.Entry<String, List<TelegramMessage>> entry : newMessages.entrySet()) {
//            LOG.debug("Processing " + entry.getKey() + " messages:");
//            for (TelegramMessage message : entry.getValue()) {
//                LOG.debug(message.toString());
//                Set<String> matchingPatterns = matcher.match(message, patterns);
//                if (matchingPatterns != null) {
//                    LOG.debug("** Matches the following patterns: " + String.join(", ", matchingPatterns));
//                    notificator.notifyPatternMatch(message, matchingPatterns);
//                }
//            }
//        }
//    }
}
