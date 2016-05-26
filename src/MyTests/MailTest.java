package MyTests;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class MailTest {
    public static void main(String[] args) {
        try {
            go();
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void go() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.sendpartial", "true");
        Session session = Session.getDefaultInstance(props);

        String userLogin = "arnold@gmail.com";
        String userPassword = "strong";
        Message message = getMessage(session);
        //авторизуемся на сервере:
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", 465, userLogin, userPassword);

        //отправляем сообщение:
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
    }

    static Message getMessage(Session session) throws MessagingException {
        //создаем сообщение
        MimeMessage message = new MimeMessage(session);

        //устанавливаем тему письма
        message.setSubject("тестовое письмо!");

        //добавляем текст письма
        message.setText("Asta la vista, baby!");

        //указываем получателя
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("stallone@gmail.com"));

        //указываем дату отправления
        message.setSentDate(new Date());
        return message;
    }
}
