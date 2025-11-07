package com.swarmhraut.rough;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailMailTryBoth {

    private static final String USERNAME = "dumbala.naveenreddy@gmail.com";
    // Paste the *new* app password here (no spaces)
    private static final String APP_PASSWORD ="cdphwvjvhjoqgyfs";

    public static void main(String[] args) {
        String to = "swarmhrprod@gmail.com";
        String subject = "GmailMailTryBoth: test";
        String body = "Test email using explicit Transport.connect() approach.";

        System.out.println("==== TRY STARTTLS (port 587) ====");
        trySendUsingStartTLS(USERNAME, APP_PASSWORD, to, subject, body);

        System.out.println("\n==== TRY SSL (port 465) ====");
        trySendUsingSSL(USERNAME, APP_PASSWORD, to, subject, body);
    }

    private static void trySendUsingStartTLS(String username, String password,
                                             String to, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props);
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");
            try {
                // explicit connect with credentials
                transport.connect("smtp.gmail.com", 587, username, password);
                transport.sendMessage(message, message.getAllRecipients());
                System.out.println("STARTTLS: Sent OK");
            } finally {
                transport.close();
            }
        } catch (AuthenticationFailedException afe) {
            System.err.println("STARTTLS: Authentication failed -> " + afe.getMessage());
            afe.printStackTrace();
        } catch (MessagingException me) {
            System.err.println("STARTTLS: MessagingException -> " + me.getMessage());
            me.printStackTrace();
        }
    }

    private static void trySendUsingSSL(String username, String password,
                                        String to, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true"); // SSL
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props);
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");
            try {
                transport.connect("smtp.gmail.com", 465, username, password);
                transport.sendMessage(message, message.getAllRecipients());
                System.out.println("SSL(465): Sent OK");
            } finally {
                transport.close();
            }
        } catch (AuthenticationFailedException afe) {
            System.err.println("SSL: Authentication failed -> " + afe.getMessage());
            afe.printStackTrace();
        } catch (MessagingException me) {
            System.err.println("SSL: MessagingException -> " + me.getMessage());
            me.printStackTrace();
        }
    }
}
