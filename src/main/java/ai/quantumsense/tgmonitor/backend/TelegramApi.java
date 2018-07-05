package ai.quantumsense.tgmonitor.backend;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TelegramApi {
    void login(String phoneNumber);
    void logout();
    boolean isLoggedIn();
    Map<String, List<TelegramMessage>> getNewMessages(Set<String> peers);

}
