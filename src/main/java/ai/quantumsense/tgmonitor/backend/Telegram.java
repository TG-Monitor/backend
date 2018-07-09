package ai.quantumsense.tgmonitor.backend;

public interface Telegram {
    void login(String phoneNumber);
    void logout();
    boolean isLoggedIn();
    void start(String peer);
    void stop(String peer);
    int numberOfMonitors();
}
