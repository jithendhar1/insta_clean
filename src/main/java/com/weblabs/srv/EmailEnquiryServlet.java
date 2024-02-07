package com.weblabs.srv;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/EmailEnquiryServlet")
public class EmailEnquiryServlet extends HttpServlet {

    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  void sendEmail(String email, String otp) {
        String from = "testing.weblabs@gmail.com";
        String password = "egon pdfr kxps hmki";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            mimeMessage.setSubject("Your OTP from insta_clean: ");
            mimeMessage.setText("Your OTP is: " + otp);

            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., log it, show a user-friendly error message)
        }
    }

   
}
