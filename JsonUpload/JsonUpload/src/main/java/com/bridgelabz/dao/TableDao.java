package com.bridgelabz.dao;

import java.io.IOException;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface TableDao {
	
	public ModelAndView getFile(String data, BindingResult result) throws IOException, Exception;
	
}
