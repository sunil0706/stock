package com.beverage.service;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.beverage.model.Menu;

@Repository
public interface MenuService {
	
	public void createMenu(Menu menu);
	
	public Optional<Menu> findMenuByName(String name);
	
}
