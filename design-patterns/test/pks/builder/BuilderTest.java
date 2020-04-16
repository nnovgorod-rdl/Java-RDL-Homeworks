package pks.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BuilderTest {
    @Test
    @DisplayName("Full Recipient Test")
    public void fullRecipientTest() {
        Recipient recipient = new Recipient.RecipientBuilder("user@server.com").setName("user").build();

        Assertions.assertAll("recipient",
                () -> Assertions.assertEquals(Recipient.class, recipient.getClass()),
                () -> Assertions.assertEquals("user@server.com", recipient.getAddress()),
                () -> Assertions.assertEquals("user", recipient.getName())

        );
    }

    @Test
    @DisplayName("Full EmailMessage Test")
    public void fullEmailMessageTest() {
        Recipient recipient = new Recipient.RecipientBuilder("user9@server.com").setName("user9").build();
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

        Assertions.assertAll("emailMessage",
                () -> Assertions.assertEquals("Test Subject", emailMessage.getSubject()),
                () -> Assertions.assertEquals("Test Body", emailMessage.getBody()),

                () -> Assertions.assertNotNull(emailMessage.getSender()),
                () -> {
                    Recipient senderFromEmail = emailMessage.getSender();
                    Assertions.assertAll("senderFromEmail",
                            () -> Assertions.assertEquals("user9@server.com", senderFromEmail.getAddress()),
                            () -> Assertions.assertEquals("user9", senderFromEmail.getName())
                    );
                },

                () -> Assertions.assertNotNull(emailMessage.getRecipientsMessage()),
                () -> {
                    List<Recipient> recipientList = emailMessage.getRecipientsMessage();
                    Assertions.assertAll("recipientList",
                            () -> Assertions.assertEquals(ArrayList.class, recipientList.getClass()),
                            () -> Assertions.assertEquals(2, recipientList.size()));
                }
        );
    }

    /*
    Как я понимаю, у меня в EmailServer методы void, а их по нормальному проверить нельзя (или я просто не понимаю как,
    если просто не понимаю, подскажите пожалуйста)
    и такие методы лучше передалать, например в boolean
     boolean send() - оправиль письмо, вернул true и т.д.? или все таки как то можно void проверить?
     */
}
