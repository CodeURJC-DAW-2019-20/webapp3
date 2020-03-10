package com.swapitServer.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import com.swapitServer.mail.*;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailSenderService emailSenderService;
	
	public User getUserByName(String name) {
		return clearPassword(userRepository.findByName(name));
	}
	
	public User getUserInSesion(HttpServletRequest request) {
		User user = new User();
		if(request.isRequestedSessionIdValid()) {	
			user= userRepository.findByName(request.getUserPrincipal().getName());
			user.setLogin(true);
		}
		return user;
	}
	
	public List<User> getAllUser(){

		return clearAllPassword(userRepository.findAll());
		
	}
	/*public void registerUser(User user , String url) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("swapitserver@gmail.com");
        mailMessage.setText("To confirm your account, please click here :" +"https://localhost:8443"+ url +"?name="+user.getName());
	    emailSenderService.sendEmail(mailMessage);
	    userRepository.save(user);
	}*/
	
	public void registerUser(String name,String  password,String lastname,String email,String address,String city,String country,String cp,String phone) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("swapitserver@gmail.com");
        mailMessage.setText("To confirm your account, please click here :" +"https://localhost:8443/profile/validate?name="+name);
	    emailSenderService.sendEmail(mailMessage);
	    userRepository.save(new User(name, password,lastname,email,address,city,country,cp,phone, 100,false, "ROLE_USER"));
	}
	
	public void updateUserData(String name, String lastname, String email, String address, String city, String country, String cp, String phone) {
			User auxUser = userRepository.findByName(name);
			auxUser.updateUserData(lastname, email, address, city, country, cp, phone);
			userRepository.save(auxUser);
		
	}
	
	public void deleteUser(String name) {
		userRepository.delete(userRepository.findByName(name));
	}
	
	public void validateUser (String name) {
		User auxuser = userRepository.findByName(name);
		auxuser.setEmailVerified(true);
		userRepository.save(auxuser);
	}
	
	public User clearPassword(User user) {
		user.setPasswordHash("");
		return user;
	}
	
	public List<User> clearAllPassword(List<User> userList ){
		for (User user : userList)
			userList.set(userList.indexOf(user), clearPassword(user));
		return userList;		
	}
}
