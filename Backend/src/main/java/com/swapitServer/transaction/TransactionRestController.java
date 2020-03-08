package com.swapitServer.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapitServer.user.User;
import com.swapitServer.user.UserService;


@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {

	@Autowired
	private UserService userService;
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<String[]> getTransactionsUser(@RequestParam String name) {	
		if(userService.getUserByName(name) != null) {			
			return new ResponseEntity<>(transactionService.getAllTransactionsFromUser(name),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}	
	
}
