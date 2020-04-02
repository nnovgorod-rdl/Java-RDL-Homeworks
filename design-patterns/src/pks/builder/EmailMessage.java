package pks.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmailMessage {
    private final List<Recipient> recipientsMessage; // получатели
    private final Recipient sender; // отправитель
    private final String body; // текст письма
    private final String subject; // тема письма

    public List<Recipient> getRecipientsMessage() {
        return recipientsMessage;
    }

    public Recipient getSender() {
        return sender;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "recipientsMessage=" + recipientsMessage +
                ", sender=" + sender +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    private EmailMessage(EmailMessageBuilder emailMessageBuilder) {
        this.recipientsMessage = emailMessageBuilder.recipientsMessage;
        this.sender = emailMessageBuilder.sender;
        this.body = emailMessageBuilder.body;
        this.subject = emailMessageBuilder.subject;
    }

    public static class EmailMessageBuilder {
        private List<Recipient> recipientsMessage; // получатели
        private Recipient sender; // отправитель
        private String body; // текст письма
        private String subject; // тема письма

        public EmailMessageBuilder setRecipientsMessage(Recipient... recipients) {
            ArrayList<Recipient> recipientArrayList = new ArrayList<>();
            Collections.addAll(recipientArrayList, recipients);
            this.recipientsMessage = recipientArrayList;
            return this;
        }

        public EmailMessageBuilder setSender(Recipient sender) {
            this.sender = sender;
            return this;
        }

        public EmailMessageBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailMessageBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public EmailMessage build() {
            return new EmailMessage(this);
        }
    }
}
