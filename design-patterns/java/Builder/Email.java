package Builder;

import java.util.Arrays;
import java.util.List;

public class Email implements IEmailMessage, IRecepient {

    String Username;
    String Address;
    List<IRecepient> Recepients;
    IRecepient Sender;
    String body;
    String Subject;

    @Override
    public void send() {
        System.out.println("The mail is sended");
    }

    @Override
    public IEmailMessage receive() {
        System.out.println("The mail is received");
        return new Email();
    }

    @Override
    public IEmailMessage create(IRecepient sender, IRecepient... recepient) {
        return new Email.Builder().withSender(sender).withRecepients(recepient).build();
    }

    @Override
    public void create(String username, String address) {
        new Email.Builder().withUsername(username).withAddress(address).build();
    }

    public static class Builder {
        private Email newEmail;

        public Builder() {
            newEmail = new Email();
        }

        public Builder withUsername(String username) {
            newEmail.Username = username;
            return this;
        }

        public Builder withAddress(String address) {
            newEmail.Address = address;
            return this;
        }

        public Builder withRecepients(IRecepient... recepient) {
            newEmail.Recepients = Arrays.asList(recepient);
            return this;
        }

        public Builder withSender(IRecepient sender) {
            newEmail.Sender = sender;
            return this;
        }

        public Builder withBody(String body) {
            newEmail.body = body;
            return this;
        }

        public Builder withSubject(String subject) {
            newEmail.Subject = subject;
            return this;
        }

        public Email build() {
            return newEmail;
        }
    }
}
