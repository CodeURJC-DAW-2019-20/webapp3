package com.swapitServer.mail;

import java.util.Properties;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;



@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("swapitserver@gmail.com");
		mailSender.setPassword("swapiturjc");
		
		Properties props =new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth",true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.conectiontimeout",10000);
		
		mailSender.setJavaMailProperties(props);
		
		return mailSender;
	}
}
