package com.olr.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.olr.dao.QuestionDao;
import com.olr.model.Question;


@Controller
public class MainController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private QuestionDao questionDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		return "main";

	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(ModelMap model) {
		return "main";

	}
	
	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	   public String addQuestion(@ModelAttribute("SpringWeb")Question question,ModelMap model) {
		logger.info("In save method..");
		   questionDao.save(question);
		   return "main";
	   }
}
