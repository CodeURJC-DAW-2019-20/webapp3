package com.swapitServer.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.swapitServer.MixService;
import com.swapitServer.product.Product;


@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MixService mixService;
	

	
	@RequestMapping(value="/addLikeIt", method=RequestMethod.PUT)
	public ResponseEntity<User> addLikeIt(@RequestParam long id ,@RequestBody User user){
		
		if(userService.existByName(user.getName())) {
			mixService.addLikeIt(user.getName(), id);	
			return new ResponseEntity<>(userService.getUserByName(user.getName()),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/addBasket", method=RequestMethod.PUT)
	public ResponseEntity<User> addBasket(@RequestParam long id ,@RequestBody User user){
		if(userService.existByName(user.getName())) {
			mixService.addBasket(user.getName(), id);
			return new ResponseEntity<>(userService.getUserByName(user.getName()),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<User> registerProfile(@RequestBody User user) {	
		if(!userService.existByName(user.getName())) {
			userService.registerUser(user.getName(), user.getPasswordHash(), user.getLastname(), user.getEmail(), user.getAddress(), user.getCity(), user.getCountry(), user.getCp(), user.getPhone());	
			return new ResponseEntity<>(userService.getUserByName(user.getName()),HttpStatus.CREATED);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);	
	}
	

	//Añadir control de acceso
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<User> updateProfile( @RequestBody User user) {	
		if(userService.existByName(user.getName())) {
			userService.updateUserData(user);	
			return new ResponseEntity<>(userService.getUserByName(user.getName()),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	//Añadir control de acceso
	@RequestMapping(value="/update", method=RequestMethod.DELETE)
	public ResponseEntity<User> updateProfile(@RequestParam String name) {	
		if(userService.existByName(name)) {
			userService.deleteUser(name);	
			return new ResponseEntity<>(HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/validate", method=RequestMethod.PUT)
	public ResponseEntity<User> validate(@RequestParam String name) {
		
		if(userService.existByName(name)) {
			userService.validateUser(name);		
			return new ResponseEntity<>(userService.getUserByName(name),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<User> readUser(@RequestParam String name) {	
		if(userService.existByName(name)) {			
			return new ResponseEntity<>(userService.getUserByName(name),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<User>> readUser() {	
			return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);

	}
	@RequestMapping(value="/all/page", method=RequestMethod.GET)
	public ResponseEntity<UserPage> readAllUserPage(Pageable page) {	
		return new ResponseEntity<>(userService.getAllUser(page),HttpStatus.OK);
	}
	
}
