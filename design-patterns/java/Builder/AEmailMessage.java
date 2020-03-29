package Builder;

import java.util.List;

public abstract class AEmailMessage implements IEmailMessage {
    List<IRecepient> Recepients; // получатели
    IRecepient Sender; // отправитель
    String body; // текст письма
    String Subject; // тема письма
}
