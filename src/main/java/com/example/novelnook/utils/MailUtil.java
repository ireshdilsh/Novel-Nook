package com.example.novelnook.utils;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    public static void sendMail(String receipt) {
        try {
            System.out.println("Mail Send Preparing.");

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            String myAccount = "ireshdilshan46@gmail.com";
            String password = "uuhr zmdy pqti lwyc";

            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myAccount, password);
                }
            });

            Message message = prepareMessage(session,myAccount,receipt);
            Transport.send(message);
            System.out.println("Message Sent Successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Message prepareMessage(Session session, String myAccount, String receipt) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipt));
            message.setSubject("Welcome to Novel Nook - Your Book Haven!");
            message.setText("Dear "+receipt+" ,\n\n"
                            +"A warm welcome to Novel Nook, your ultimate book haven! We're thrilled to have you on board." +
                            "\nThank you for registering with us." +
                            "\n\nWhat to Expect:\n" +
                            "\n" +
                            "Exclusive access to our vast collection of books, including bestsellers and rare finds\n" +
                            "Personalized book recommendations based on your reading preferences\n" +
                            "Regular updates on new releases, author events, and special promotions\n" +
                            "Easy checkout and secure payment options\n" +
                            "\nGet Started:\n" +
                            "\n" +
                            "Browse our shelves\n" +
                            "Update your reading preferences\n" +
                            "Follow us on social media");
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
