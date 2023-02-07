package com.unitral.notification_service.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitral.notification_service.service_provider.Main_Interface;

@Service
public class Service_Imp implements Service_Interface{
	
	@Autowired
private Main_Interface mi;

	public Service_Imp() {
		
	}
	
	public boolean sendMail() {
		System.out.println("Hello");
		return mi.sendEmail("Hello Sir", "No SUB", "risab.7088@gmail.com", "aryasharma9634@gmail.com");
	}

	

	@Override
	public boolean sendMail(String rsMid) {
		String  [] ar=rsMid.split(";");
		
		return mi.sendEmail(ar[2], ar[1], "risab.7088@gmail.com", "aryasharma9634@gmail.com");
		
	}
	

}
