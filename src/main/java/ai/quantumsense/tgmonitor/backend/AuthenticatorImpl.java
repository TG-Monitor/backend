package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.monitor.Authenticator;

public class AuthenticatorImpl implements Authenticator {

    private Telegram telegram;

    public AuthenticatorImpl(Telegram telegram) {
        this.telegram = telegram;
    }

    @Override
    public void login(String phoneNumber) {
        telegram.login(phoneNumber);
    }

    @Override
    public void logout() {
        telegram.logout();
    }

    @Override
    public boolean isLoggedIn() {
        return telegram.isLoggedIn();
    }
}
