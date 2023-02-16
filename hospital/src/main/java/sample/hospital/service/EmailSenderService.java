package sample.hospital.service;

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
public class EmailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String toEmail, String body, String subject) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("springboothospital@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		javaMailSender.send(message);

		System.out.println("Mail sent successfully...");
	}

	public void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment)
			throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setFrom("springboothospital@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		javaMailSender.send(mimeMessage);
		System.out.println("Mail sent successfully...");
	}

}
