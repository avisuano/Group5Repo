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

import com.revature.model.ForumPost;
import com.revature.util.SessionFactory;

@Repository(value="forumPostRepository")
public class ForumPostRepositoryImpl implements ForumPostRepository {

	@Override
	public List<ForumPost> getAllForumPosts() {
		List<ForumPost> forumposts = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			forumposts = s.createNativeQuery("SELECT * FROM FORUMPOST", ForumPost.class).list();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return forumposts;
	}

	@Override
	public void insertForumPost(ForumPost fp) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.save(fp); //inserting new user
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
	}

	@Override
	public ForumPost getForumPostById(int id) {
		ForumPost fp = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			fp = s.get(ForumPost.class, id);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return fp;
	}

	@Override
	public void updateForumPost(ForumPost fp) {
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			s.merge(fp);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ForumPost> getAllForumPostsFromUserId(int user_id) {
		List<ForumPost> forumposts = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ForumPost> cq = cb.createQuery(ForumPost.class);
			Root<ForumPost> root = cq.from(ForumPost.class);
			cq.select(root).where(cb.equal(root.get("user_id"), user_id));
			Query q = s.createQuery(cq);
			forumposts = (List<ForumPost>) q.getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return forumposts;
	}
	
	@Override
	public void deleteForumPost(int id) {
		ForumPost fp = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ForumPost> cq = cb.createQuery(ForumPost.class);
			Root<ForumPost> root = cq.from(ForumPost.class);
			cq.select(root).where(cb.equal(root.get("forumPost_id"), id));
			Query q = s.createQuery(cq);
			fp = (ForumPost) q.getSingleResult();
			s.remove(fp);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}	
	}
}
