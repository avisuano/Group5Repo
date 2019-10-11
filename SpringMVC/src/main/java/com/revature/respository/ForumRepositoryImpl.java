package com.revature.respository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.model.Forum;
import com.revature.util.SessionFactory;

@Repository("forumRepository")
public class ForumRepositoryImpl implements ForumRepository {

	@Override
	public List<Forum> getAllForums() {
		List<Forum> forums = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			forums = s.createNativeQuery("SELECT * FROM FORUM", Forum.class).list();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return forums;
	}

	@Override
	public void insertForum(Forum f) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			System.out.println(f);
			s.save(f); //inserting new forum
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
	}

	@Override
	public Forum getForumById(int id) {
		Forum f = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			f = s.get(Forum.class, id);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return f;
	}

	@Override
	public Forum getForumByName(String title) {
		Forum f = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Forum> cq = cb.createQuery(Forum.class);
			Root<Forum> root = cq.from(Forum.class);
			cq.select(root).where(cb.equal(root.get("title"), title));
			Query q = s.createQuery(cq);
			f = (Forum) q.getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return f;
	}

	@Override
	public void updateForum(Forum f) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.merge(f);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}

	@Override
	public void deleteForum(String title) {
		Forum f = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Forum> cq = cb.createQuery(Forum.class);
			Root<Forum> root = cq.from(Forum.class);
			System.out.println(cq + "\n\n\n\n1" );
			cq.select(root).where(cb.equal(root.get("title"), title));
			Query q = s.createQuery(cq);
			f = (Forum) q.getSingleResult();
			s.remove(f);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
	}
			
}
