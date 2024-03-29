package com.niit.phonebackend;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bean.Supplier;
import com.niit.dao.SupplierDao;

public class SupplierUnitTest {
	@Autowired
	static SupplierDao supplierDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    supplierDao=(SupplierDao) context.getBean("supplierDao");
	}
	//@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("prani");
		supplier.setSupplierAddress("1-40/A eluru");
		
		assertTrue("Problem in adding the supplier",supplierDao.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDao.getSupplier(1);
		
		assertTrue("Problem in deleting supplier",supplierDao.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDao.getSupplier(2 );
		supplier.setSupplierAddress("1-40/A eluru");
		
		assertTrue("Problem in updating supplier",supplierDao.updateSupplier(supplier));
	}

}
