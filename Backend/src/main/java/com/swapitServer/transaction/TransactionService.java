package com.swapitServer.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.swapitServer.MixService;
import com.swapitServer.product.Product;
import com.swapitServer.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.swapitServer.user.*;

@Component
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductService productService;

	@Autowired
	MixService mixService;
	
	public String[] getAllTransactionsFromUser(String name){
		
		User auxser = userRepository.findByName(name);
		//user.setLogin(true);
		String auxTransactions[] = new String[4];
		List<Transaction> transactions = transactionRepository.findByUserId((long)auxser.getId());
		List<String> buyDates = new ArrayList<String>();
		List<Integer> buyValues= new ArrayList<Integer>();
		List<String> sellDates = new ArrayList<String>();
		List<Integer> sellValues= new ArrayList<Integer>();
		int x =0;
		for(Transaction aux: transactions)
		{
			if(aux.getType().equals("BUY"))
			{
				if(buyDates.isEmpty()) 			
				{
					buyDates.add("'"+aux.getDate()+"'");
					buyValues.add(1);		
				}else if(buyDates.get(x).equals("'"+aux.getDate()+"'") )
				{
					buyValues.set(x,buyValues.get(x)+1);				
				}else {
					buyDates.add("'"+aux.getDate()+"'");
					buyValues.add(1);
					x++;				
				}
			}else if(aux.getType().equals("SELL")) {
				if(sellDates.isEmpty()) 			
				{
					sellDates.add("'"+aux.getDate()+"'");
					sellValues.add(1);		
				}else if(sellDates.get(x).equals("'"+aux.getDate()+"'") )
				{
					sellValues.set(x,sellValues.get(x)+1);				
				}else {
					sellDates.add("'"+aux.getDate()+"'");
					sellValues.add(1);
					x++;				
				}
			}
		}
		auxTransactions[0]=buyDates.toString();
		auxTransactions[1]=buyValues.toString();
		auxTransactions[2]=sellDates.toString();
		auxTransactions[3]=sellValues.toString();
		
		return auxTransactions;
	}

	public void registerTransaction (String type, Long userId, Long productId){
		transactionRepository.save(new Transaction(type, userId, productId));
	}

	public boolean payTransaction (long id, List<Product> productsBasket){
		User user = userRepository.findById(id);
		List<Product> products = productsBasket;

		if (user.getBalance() > user.getPriceOfBasket()){
			for (Product product: products){
				user.setBalance(user.getBalance() - user.getPriceOfBasket());
				registerTransaction("BUY", id, product.getId());
				product.setInStock(false);
			}

			return true;
		} else {
			return false;
		}
	}
}
