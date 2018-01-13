package com.olr.demo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.olr.dao.QuestionDao;
import com.olr.model.Question;


public class MainApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		QuestionDao questionDao = (QuestionDao)context.getBean("questionDao");
		
		Question question = new Question();
		question.setQuestion("What is your product name?");
		
		questionDao.save(question);
		
		
		List<Question> list = questionDao.list();
		
		for(Question q : list){
			System.out.println("Person List::"+q);
		}
		//close resources
		context.close();	

	}

}
