package com.olr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olr.dao.AnswerDao;
import com.olr.dao.QuestionDao;
import com.olr.model.Answer;

@Service
public class RequirementGatheringService {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private AnswerDao answerDao;
	
	public void saveAnswer(Answer answer){
		answerDao.save(answer);
	}
	
}
