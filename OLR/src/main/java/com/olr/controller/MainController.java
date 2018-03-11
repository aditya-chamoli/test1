package com.olr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.olr.dao.QuestionDao;
import com.olr.model.Answer;
import com.olr.model.Entity;
import com.olr.model.EntityBasic;
import com.olr.model.Question;
import com.olr.service.DataDiscoveryService;
import com.olr.service.RequirementGatheringService;


@Controller
public class MainController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private RequirementGatheringService requirementGatheringService;
	
	@Autowired
	private DataDiscoveryService dataDiscoveryService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		return "main";

	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(ModelMap model) {
		return "main";
	}
	
	@RequestMapping(value = "/dd", method = RequestMethod.GET)
	public String dataDiscovery(ModelMap model) {
		return "dd";
	}
	
	@RequestMapping(value = "/addEntity", method = RequestMethod.POST)
	public String addEntity(@RequestParam Map<String,String> requestParams,ModelMap model) {
		
		List<Entity> depEntities = new ArrayList<>();
		int count=0;
		String cType = null;
		while((cType = requestParams.get("ctype"+Integer.toString(++count))) != null){
			depEntities.add(new Entity(cType,null,null));
		}
		
		List<String> properties = new ArrayList<>();
		count=0;
		String sType = null;
		while((sType = requestParams.get("stype"+Integer.toString(++count))) != null){
			properties.add(sType);
		}
		
		String name = requestParams.get("name");

		Entity entity = new Entity(name,properties,depEntities);
		
		int entityId = dataDiscoveryService.addEntity(entity);
		
		return "redirect:viewEntity/"+entityId;
	}
	
	@RequestMapping(value = "/viewEntity/{entityId}", method = RequestMethod.GET)
	public String viewEntity(@RequestParam Map<String,String> requestParams,ModelMap model,@PathVariable int entityId) {
		
		Entity entity = dataDiscoveryService.getEntity(entityId);
		model.addAttribute("entity", entity);
		
		return "ddve";
	}
	
	@RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
	   public String addQuestion(@ModelAttribute("SpringWeb")Answer answer,ModelMap model) {
		logger.info("In save method..");
		requirementGatheringService.saveAnswer(answer);
		   return "main";
	   }
}
