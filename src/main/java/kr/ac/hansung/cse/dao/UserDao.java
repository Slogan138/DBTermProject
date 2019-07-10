package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.cse.model.User;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session.saveOrUpdate(user);
		
		session.flush();
	}
	
	public User getUserById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, userId);
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User where username=?");
		query.setParameter(0, username);
		
		return query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		/*
		 * Session session = sessionFactory.getCurrentSession(); TypedQuery<User> query
		 * = session.createQuery("from User"); List<User> userList =
		 * query.getResultList();
		 */
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		
		@SuppressWarnings("depreaction")
		List<User> userList = query.list();
		
		return userList; 
	}
}
