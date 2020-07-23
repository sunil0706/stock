package com.beverage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.beverage.controller.MenuController;
import com.beverage.model.Ingredients;
import com.beverage.model.Menu;
import com.beverage.service.MenuServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MenuController.class)
public class MenuTest {
	                                                 
	    @MockBean                      
	    private MenuServiceImpl menuService; 
	    
	    @Autowired
	    private MockMvc mvc;
	    
	    
	                                            
	    @BeforeEach                           
	    void setUp() {
	    	MockitoAnnotations.initMocks(this);
	    	
	    	Menu menu = new Menu();
	    	menu.setId(1L);
	    	menu.setName("Coffee");
	    	menu.setPrice(5.00);
	    	
	    	Ingredients ingredient = new Ingredients();
	    	
	    	ingredient.setId(2L);
	    	ingredient.setIngredient1("Coffee");
	    	ingredient.setIngredient1("milk");
	    	ingredient.setIngredient1("sugar");
	    	ingredient.setIngredient1("water");
	    	
	    	menu.setIndgredients(ingredient);	
	    }
	    
	    @Test
	    public void createMenuTest() throws Exception{
	    	
	    	Menu menu = new Menu();
	    	menu.setId(1L);
	    	menu.setName("Coffee");
	    	menu.setPrice(5.00);
	    	
	    	Ingredients ingredient = new Ingredients();
	    	
	    	ingredient.setId(2L);
	    	ingredient.setIngredient1("Coffee");
	    	ingredient.setIngredient1("milk");
	    	ingredient.setIngredient1("sugar");
	    	ingredient.setIngredient1("water");
	    	
	    	menu.setIndgredients(ingredient);	
	    	
	    	String inputJson = this.mapToJson(menu);
	    	
	    	//when(menuService.createMenu(Mockito.any(Menu.class))).thenReturn(menu);
	    	
	    	RequestBuilder builder = MockMvcRequestBuilders.post("/menu").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_ATOM_XML.APPLICATION_JSON);
	    	
	    	MvcResult result = mvc.perform(builder).andReturn();
	    	
	    	MockHttpServletResponse response = result.getResponse();
	    	
	    	String json = response.getContentAsString();
	    	
	    	assertThat(json).isEqualTo(inputJson);
	    	
	    	
	    }
	    
	    @Test
	    public void getMenuByName() throws Exception {
	    		    	  
	    }
	    
	    private String mapToJson(Object object) throws JsonProcessingException{
	    	ObjectMapper mapper = new ObjectMapper();
	    	return mapper.writeValueAsString(object);
	    }
	    
}
