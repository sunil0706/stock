package com.beverage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beverage.model.Menu;
import com.beverage.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public void createMenu(Menu menu) {
		menuRepository.save(menu);
	}

	@Override
	public Optional<Menu> findMenuByName(String name) {
		Optional<Menu> menuByName = menuRepository.findByName(name);
		return menuByName;
	}
}