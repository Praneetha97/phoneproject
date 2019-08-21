package com.niit.daoimpl;

import java.util.*;
import javax.transaction.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.niit.bean.Supplier;
import com.niit.dao.SupplierDao;
@Repository("SupplierDao") 
@Transactional
public  class SupplierDaoImpl implements SupplierDao {
	@Autowired
    SessionFactory sessionFactory;
    
	public boolean addSupplier(Supplier supplier) {
		
		 try
	        {
	        sessionFactory.getCurrentSession().save(supplier);
	        return true;
	        }
	        catch(Exception e)
	        {
	        return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
	
		try
        {
        sessionFactory.getCurrentSession().delete(supplier);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
	}

	public boolean updateSupplier(Supplier supplier) {
		
		try
        {
        sessionFactory.getCurrentSession().update(supplier);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}
	}

	public List<Supplier> listSuppliers() {
		
		 Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from Supplier");
	        List<Supplier> listSuppliers=query.list();
	        session.close();
			return listSuppliers;
	}

	public Supplier getSupplier(int supplierID) {
		
		   Session session=sessionFactory.openSession();
	        Supplier supplier=session.get(Supplier.class,supplierID);        
			return supplier ;
	}

}
