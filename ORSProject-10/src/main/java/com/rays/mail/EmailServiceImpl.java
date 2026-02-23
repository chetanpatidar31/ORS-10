package com.rays.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender mailSender;

	
	public void sendMail(EmailMessage msg) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setTo(msg.getTo());
			helper.setSubject(msg.getSubject());

			if (msg.getMessageType() == EmailMessage.HTML_MSG) {
				helper.setText(msg.getBody(), true);
			} else {
				helper.setText(msg.getBody(), false);
			}
			
			mailSender.send(mimeMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
