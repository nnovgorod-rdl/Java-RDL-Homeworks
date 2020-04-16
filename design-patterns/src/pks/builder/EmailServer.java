package pks.builder;

import static java.lang.System.out;

public class EmailServer {
    final EmailMessage emailMessage;

    public EmailServer(EmailMessage emailMessage) {
        this.emailMessage = emailMessage;
    }

    void send() {
        if (emailMessage.getRecipientsMessage() == null || emailMessage.getRecipientsMessage().isEmpty()) {
            out.println("Не указаны получатели");
            return;
        }
        for (Recipient r : emailMessage.getRecipientsMessage()) {
            out.println("Отсылаю письмо: " + r.toString());
            out.println("Тема: " + emailMessage.getSubject());
            out.println("Текст письма: " + emailMessage.getBody());
        }
    }

    void receive(EmailMessage emailMessage, String address) {
        if (emailMessage.getRecipientsMessage() == null || emailMessage.getRecipientsMessage().isEmpty()) {
            out.println("Писем на указанный адрес нет");
            return;
        }

        for (Recipient r : emailMessage.getRecipientsMessage()) {
            if (r.getAddress().equalsIgnoreCase(address)) {
                out.println("Вам пришло письмо от " + emailMessage.getSender().toString());
                out.println("Тема: " + emailMessage.getSubject());
                out.println("Текст письма: " + emailMessage.getBody());

                return;
            }
        }
        out.println("Писем на указанный адрес нет");
    }

}
