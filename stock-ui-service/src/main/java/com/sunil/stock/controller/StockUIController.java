package com.sunil.stock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunil.stock.service.StockUIService;


@Controller
public class StockUIController {

	@Autowired
	private StockUIService service;
	
	@GetMapping("/")
    public String index() {
        return "index";
    }
	
	@GetMapping("/getStockPrice")
	public String getStockPrice(HttpServletRequest request, Model model){
		String stockName = request.getParameter("stockName");
		String quantity = request.getParameter("quantity");
		String response = service.getTotalStockPrice(stockName,Integer.parseInt(quantity));
		model.addAttribute("msg",response);		
		return "index";
	}
}
