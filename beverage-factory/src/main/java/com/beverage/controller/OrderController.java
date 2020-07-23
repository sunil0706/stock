package com.beverage.controller;

import java.util.Optional;


import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beverage.constant.MenuConstant;
import com.beverage.model.Menu;
import com.beverage.service.MenuServiceImpl;

@RestController
public class OrderController {

	Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private MenuServiceImpl menuService;

	@PostMapping("/order/{menuName}")
	public ResponseEntity<Object> placeOrder(@PathVariable String menuName,
			@RequestParam(defaultValue = "milk") String item) {
		Optional<Menu> menu = menuService.findMenuByName(menuName);
		String menuData = menu.get().getName();
		Double menuPrice = menu.get().getPrice();
		Double milk = 1d;
		Double Sugar = 0.5d;
		Double Soda = 0.5d;
		Double mint = 0.5d;
		Double water = 0.5;

		Double orderAmount = 0.0d;

		String ch = item;
		if (menuData.equals(menuName)) {
			switch (ch) {
			case MenuConstant.MENU_MILK: {
				orderAmount = orderAmount + menuPrice + milk;
				break;
			}
			case MenuConstant.MENU_MINT: {
				orderAmount = menuPrice + mint;
				break;
			}
			case MenuConstant.MENU_SODA: {
				orderAmount = menuPrice + Soda;
				break;
			}
			case MenuConstant.MENU_SUGAR: {
				orderAmount = menuPrice + Sugar;
				break;
			}
			case MenuConstant.MENU_WATER: {
				orderAmount = menuPrice + water;
				break;
			}
			default:
				orderAmount = orderAmount + menuPrice;
			}
		} else {
			logger.info("Please order valid Menu...");
		}
		logger.info("Order Amount is " +orderAmount);
		return (ResponseEntity<Object>) ResponseEntity.ok();

	}
}
