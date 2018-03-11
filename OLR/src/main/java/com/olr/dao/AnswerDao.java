package com.olr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.olr.model.Answer;

public class AnswerDao {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


	public void save(Answer answer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(answer);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Answer> list() {
		Session session = this.sessionFactory.openSession();
		List<Answer> answerList = session.createQuery("from Answer").list();
		session.close();
		return answerList;
	}
}
