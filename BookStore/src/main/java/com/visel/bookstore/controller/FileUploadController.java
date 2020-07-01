/**
 * 
 */
package com.visel.bookstore.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.visel.bookstore.model.Bookstore;

/**
 * @author sunilnayak
 *
 */
@RestController
public class FileUploadController {
	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Bookstore convertXMLtoJson()throws IOException {
		logger.info("Inside FileUploadController...");
		


		XmlMapper mapper = new XmlMapper();
		Bookstore bookstore = mapper.readValue(new File("/Users/sunilnayak/git/repository/BookStore/src/main/resources/bookstore.xml"), Bookstore.class);
		logger.info("Outside FileUploadController...");
		return bookstore;
    }
}
