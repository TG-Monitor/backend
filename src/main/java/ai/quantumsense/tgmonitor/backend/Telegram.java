package ai.quantumsense.tgmonitor.backend;

public interface Telegram {
    void login(String phoneNumber);
    void logout();
    boolean isLoggedIn();
    void startPeer(String peer);
    void stopPeer(String peer);
    int numberOfPeers();
}
