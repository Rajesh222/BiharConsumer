package com.db.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${isOffline}") 
	private boolean isOffLine;

	public void sendEmail(String headerValue, String to, String body) {
		log.info("call sendEmail()");
		if(!isOffLine)
			return;
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				helper.setSubject(headerValue);
				helper.setTo(to);
				helper.setText(body, true);
			}
		};
		mailSender.send(preparator);
	}
}
