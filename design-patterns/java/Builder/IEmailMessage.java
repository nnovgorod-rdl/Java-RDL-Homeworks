package Builder;

import java.util.List;

public interface IEmailMessage {
    void send(); // отправить письмо
    IEmailMessage receive(); // получить письмо
    IEmailMessage create(IRecepient sender, IRecepient... recepient); // создать письмо
}
