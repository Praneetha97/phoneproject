package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import com.niit.bean.Model;
import com.niit.dao.ModelDao;
@Repository("modelDao") 
@Transactional
public class ModelDaoImpl implements ModelDao {
	@Autowired
    SessionFactory sessionFactory;
    
	public boolean addModel(Model model) {		
		try{
		sessionFactory.getCurrentSession( ).save(model);		
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean deleteModel(Model model) {
		try{
			sessionFactory.getCurrentSession( ).delete(model);		
				return true;
			}
			catch(Exception e){
				return false;
			}
	}

	public boolean updateModel(Model model) {
		try{
			sessionFactory.getCurrentSession( ).update(model);		
				return true;
			}
			catch(Exception e){
				return false;
			}
	}

	public List<Model> listModel() {
		 Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from Model");
	        List<Model> listmodel=query.list();
	        session.close();
			return listmodel;
	}

	public Model getModel(int ModelId) {
		 Session session=sessionFactory.openSession();
		 Model model=session.get(Model.class,ModelId);        
			return model ;
	}

}
