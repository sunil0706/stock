/**
 * 
 */
package com.visel.bookstore.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.visel.bookstore.pojo.Bookstore;
import com.visel.bookstore.service.BookStoreServiceImpl;

/**
 * @author sunilnayak
 *
 */
@RestController
public class FileUploadController {
	@Autowired
	private Environment env;
	
	@Autowired
	private BookStoreServiceImpl bookService;
	
	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Bookstore convertXMLtoJava()throws IOException {
		logger.info("Inside FileUploadController...");
		String path = env.getProperty("fileUploadpath");
		XmlMapper mapper = new XmlMapper();
		Bookstore bookstore = mapper.readValue(new File(path), Bookstore.class);
		logger.info("Outside FileUploadController...");
		bookService.saveXMLObject(bookstore);
		return bookstore;
    }
}
