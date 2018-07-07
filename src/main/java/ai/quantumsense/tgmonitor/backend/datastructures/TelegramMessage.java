package ai.quantumsense.tgmonitor.backend.datastructures;

public class TelegramMessage {

    private String text;
    private String sender;
    private String date;
    private String peer;


    public TelegramMessage(String text, String sender, String date, String peer) {
        this.text = text;
        this.sender = sender;
        this.date = date;
        this.peer = peer;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public String getDate() {
        return date;
    }

    public String getPeer() {
        return peer;
    }

    @Override
    public String toString() {
        return "Peer: " + peer + "\nSender: " + sender + "\nDate: " + date + "\nText: " + text;
    }
}
