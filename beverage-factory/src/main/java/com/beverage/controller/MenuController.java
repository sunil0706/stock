package com.beverage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beverage.model.Menu;
import com.beverage.service.MenuServiceImpl;

@RestController
public class MenuController {
	
	@Autowired
	private MenuServiceImpl menuService;
	
	@PostMapping("/menu")
	public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
		 menuService.createMenu(menu);
		 return new ResponseEntity<Menu>(HttpStatus.CREATED);
	}
	
	@GetMapping("/menu/{menuName}")
	public Optional<Menu> findMenuByName(@PathVariable String menuName){
		Optional<Menu> menu = menuService.findMenuByName(menuName);
		return menu;
	}
}
