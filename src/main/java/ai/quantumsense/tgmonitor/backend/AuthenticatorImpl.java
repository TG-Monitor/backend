package ai.quantumsense.tgmonitor.backend;

import ai.quantumsense.tgmonitor.monitor.Authenticator;

public class AuthenticatorImpl implements Authenticator {

    private TelegramApi telegramApi;

    public AuthenticatorImpl(TelegramApi telegramApi) {
        this.telegramApi = telegramApi;
    }

    @Override
    public void login(String phoneNumber) {
        telegramApi.login(phoneNumber);
    }

    @Override
    public void logout() {
        telegramApi.logout();
    }

    @Override
    public boolean isLoggedIn() {
        return telegramApi.isLoggedIn();
    }
}
