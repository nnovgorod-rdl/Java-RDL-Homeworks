package pks.builder;

import static java.lang.System.out;

public class MainBuilder {
    public static void main(String[] args) {
        Recipient recipient = new Recipient.RecipientBuilder("user@server.com").setName("user").build();
        out.println(recipient);

        EmailMessage emailMessage = new EmailMessage.EmailMessageBuilder()
                .setRecipientsMessage(
                        new Recipient.RecipientBuilder("user2@server.com").
                                setName("user2").build(),
                        new Recipient.RecipientBuilder("user3@server.com").
                                setName("user3").build())
                .setSender(recipient)
                .setSubject("Test Subject")
                .setBody("Test Body")
                .build();

        EmailServer emailServer = new EmailServer(emailMessage);
        emailServer.send();
        printLine();

        emailServer.receive(new EmailMessage.EmailMessageBuilder().build(), "user2@server.com");
        printLine();
        emailServer.receive(emailMessage, "user3@server.com");
        printLine();
        emailServer.receive(emailMessage, "user7@server.com");
    }

    static void printLine() {
        out.println("==========");
    }
}
