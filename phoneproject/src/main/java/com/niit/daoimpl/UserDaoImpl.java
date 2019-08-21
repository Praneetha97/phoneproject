package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.bean.User;
import com.niit.dao.UserDao;

@Repository("UserDao") 
@Transactional

public class UserDaoImpl implements UserDao  {
	@Autowired
    SessionFactory sessionFactory;
    
	public boolean addUser(User user) {
		
		 try
	        {
	        sessionFactory.getCurrentSession().save(user);
	        return true;
	        }
	        catch(Exception e)
	        {
	        return false;
		}
	}

	public boolean deleteUser(User user) {
	
		try
        {
        sessionFactory.getCurrentSession().delete(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
	}

	public boolean updateUser(User user) {
		
		try
        {
        sessionFactory.getCurrentSession().update(user);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}
	}

	public List<User> listUsers() {
		
		 Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from User");
	        List<User> listUsers=query.list();
	        session.close();
			return listUsers;
	}

	public User getUser(int userID) {
		
		   Session session=sessionFactory.openSession();
	        User user=session.get(User.class,userID);        
			return user ;
	}


	
	
	
	
	
}
