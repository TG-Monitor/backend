package ai.quantumsense.tgmonitor.backend.datastruct;

import javax.annotation.Nullable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TelegramMessage {

    private int id;
    private int date;
    private String text;
    private Sender sender;
    private Peer peer;
    private Integer replyMessageId;

    public TelegramMessage(int id, int date, String text, Sender sender,
                           Peer peer, @Nullable Integer replyMessageId) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.sender = sender;
        this.peer = peer;
        this.replyMessageId = replyMessageId;
    }

    public int getId() {
        return id;
    }

    // UNIX timestamp in seconds
    public int getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Sender getSender() {
        return sender;
    }

    public Peer getPeer() {
        return peer;
    }

    public boolean isReply() {
        return replyMessageId != null;
    }

    public @Nullable Integer getReplyMessageId() {
        return replyMessageId;
    }

    @Override
    public String toString() {
        return (new StringBuilder())
                .append("ID: ").append(id)
                .append("\nReply to ID: ").append(replyMessageId)
                .append("\nDate: ").append(formatDate())
                .append("\nFrom: ").append(sender)
                .append("\nText (starts on next line):\n" ).append(text)
                .append("\nChat: ").append(peer)
                .toString();
    }

    private String formatDate() {
        Instant instant = Instant.ofEpochSecond(date);
        ZonedDateTime date = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss '[UTC]'");
        return date.format(format);
    }

    public static class Sender {

        private int id;
        private Boolean isBot;
        private String firstName;
        private String lastName;
        private String username;

        public Sender(int id, @Nullable Boolean isBot, @Nullable String firstName,
                      @Nullable String lastName, @Nullable String username) {
            this.id = id;
            this.isBot = isBot;
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
        }

        public int getId() {
            return id;
        }

        public boolean isBot() {
            if (isBot == null) return false;
            else return isBot;
        }

        public @Nullable String getFirstName() {
            return firstName;
        }

        public @Nullable String getLastName() {
            return lastName;
        }

        public @Nullable String getUsername() {
            return username;
        }

        @Override
        public String toString() {
            return (new StringBuilder())
                    .append("ID: ").append(id)
                    .append(", first name: ").append(firstName)
                    .append(", last name: " ).append(lastName)
                    .append(", username: ").append(username)
                    .append(", is bot: ").append(isBot())
                    .toString();
        }
    }

    public static class Peer {
        private int id;
        private String title;
        private String username;

        public Peer(int id, String title, @Nullable String username) {
            this.id = id;
            this.title = title;
            this.username = username;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public @Nullable String getUsername() {
            return username;
        }

        @Override
        public String toString() {
            return (new StringBuilder())
                    .append("ID: ").append(id)
                    .append(", title: ").append(title)
                    .append(", username: ").append(username)
                    .toString();
        }
    }
}
