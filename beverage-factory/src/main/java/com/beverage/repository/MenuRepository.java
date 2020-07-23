package com.beverage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beverage.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
	
	public Optional<Menu> findByName(String name);
	
}
