package com.db.service;

import java.util.Arrays;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.db.model.Complain;
import com.db.utils.Constants;

@Service("mailService")
public class MailService {

	private static final Logger log = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(Object object) {
		log.info("call sendEmail()");
		Complain customerInfo = (Complain) object;
		MimeMessagePreparator preparator = getContentWtihAttachementMessagePreparator(customerInfo);
		try {
			mailSender.send(preparator);
		} catch (MailException ex) {
			log.error(Arrays.toString(ex.getStackTrace()));
		}
	}

	private MimeMessagePreparator getContentWtihAttachementMessagePreparator(final Complain customerInfo) {
		return new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				helper.setSubject(Constants.HEADER);
				helper.setFrom("satyamk328@gmail.com");
				helper.setTo(customerInfo.getEmail());
				String content = "Dear " + customerInfo.getName() + ", thank you for placing order. Your order id is "
						+ customerInfo.getPhone() + ".";
				helper.setText(content);
			}
		};
	}
}
