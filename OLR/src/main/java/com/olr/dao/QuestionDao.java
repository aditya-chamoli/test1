package com.olr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.olr.model.Question;


public class QuestionDao {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


	public void save(Question question) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(question);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Question> list() {
		Session session = this.sessionFactory.openSession();
		List<Question> questionList = session.createQuery("from Question").list();
		session.close();
		return questionList;
	}
}
