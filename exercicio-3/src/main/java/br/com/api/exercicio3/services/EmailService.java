package br.com.api.exercicio3.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.api.exercicio3.domain.TohDomain;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender emailSender;
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties properties = new Properties();
		
		emailSender.setHost("smtp.gmail.com");
		emailSender.setPort(587);
		emailSender.setUsername("turma06deby@gmail.com");
		emailSender.setPassword("pwkscdavgflatrno");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		emailSender.setJavaMailProperties(properties);
		
		return emailSender;
		
	}
	
	public void envioEmailCadastro(String email, TohDomain jogo) throws MessagingException {
		this.emailSender = javaMailSender();
		MimeMessage messageJogo =  emailSender.createMimeMessage();
		MimeMessageHelper helperjogo = new MimeMessageHelper(messageJogo,true);
		
		try {
			helperjogo.setFrom("turma06deby@gmail.com");
			helperjogo.setTo("kaiquedmazzoco11@gmail.com");
			helperjogo.setSubject(email);
			
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("   <body>\r\n");
			sBuilder.append("      <div align=\"center\">\r\n");
			sBuilder.append("         <h1>Cadastro Concluido\r\n<h1>");
			sBuilder.append("	   <div>\r\n");
			sBuilder.append("	   <br/>\r\n");
			sBuilder.append("	   	<div>\r\n");
			sBuilder.append("			Status: "+jogo.isStatus()+"\n");
			sBuilder.append("	   	<div>\r\n");		
			sBuilder.append("	   	<div>\r\n");
			sBuilder.append("			jogo: "+jogo.getNome()+"\n");
			sBuilder.append("	   	<div>\r\n");
			sBuilder.append("	   	<div>\r\n");
			sBuilder.append("			valor: "+jogo.getValor()+"\n");
			sBuilder.append("	   	<div>\r\n");
			sBuilder.append("	   	<div>\r\n");
			sBuilder.append("	<body>\r\n");
			sBuilder.append("<html>\r\n");
			
			helperjogo.setText(sBuilder.toString(),true);
			emailSender.send(messageJogo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
