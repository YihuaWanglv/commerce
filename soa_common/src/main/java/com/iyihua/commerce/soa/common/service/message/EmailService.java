package com.iyihua.commerce.soa.common.service.message;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.iyihua.commerce.model.component.message.EmailMessage;
import com.iyihua.commerce.remote.common.message.EmailRemote;


@Component
public class EmailService implements EmailRemote{

	@Autowired private JavaMailSender javaMailSender;
	
	public void send(EmailMessage message) {
		MimeMessage mm = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mm);
		try {
			helper.setTo(message.getTo());
//			helper.setFrom("619361578@qq.com");
			helper.setSubject(message.getSubject());
			helper.setText(message.getContent(), true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		javaMailSender.send(mm);
	}
}
