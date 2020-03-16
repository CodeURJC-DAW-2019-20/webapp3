package com.swapitServer.transaction;

import com.swapitServer.MixService;
import com.swapitServer.product.Product;
import com.swapitServer.product.ProductService;
import com.swapitServer.user.User;
import com.swapitServer.user.UserRepository;
import com.swapitServer.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TransactionController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MixService mixService;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/checkout/transaction")
    public String transactionCheckout(Model model , HttpServletRequest request) {

        model.addAttribute("user", userService.getUserInSesion(request));
        model.addAttribute("statusTransaction", transactionService.payTransaction(userService.getUserInSesion(request).getId(), mixService.getProductsBasket(request)));
        userService.emptyProductsBasket(userService.getUserInSesion(request).getName());

        return "redirect:/checkout";
    }


}
