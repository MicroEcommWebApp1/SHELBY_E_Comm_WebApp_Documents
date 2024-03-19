package com.buyer.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("fullstackwizard1526@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);

	}
	
	public void sendEmailWithAttachment(String to, String subject, String text,String imagePath) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            
      

            
            String htmlContent = "<html><body><h1>Welcome to our platform!</h1>"
                    + "<p>We're excited to have you on board.{{text}}</p>"
                    + "<img src='cid:welcomeImage'>"
                    + "</body></html>";
            String result = htmlContent.replace("{{text}}", text);

            helper.setText(result, true);

 //FileSystemResource file = new FileSystemResource(new File("C:\\Users\\samirishetti\\Downloads\\image.png"));
            FileSystemResource file = new FileSystemResource(new File("images/image.png"));
 helper.addInline("welcomeImage", file);
            mailSender.send(message);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    	}

}
