package com.niit.phonebackend;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

import com.niit.bean.*;
import com.niit.dao.*;

public class ModelUnitTest {
	@Autowired
	static ModelDao modelDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    modelDao=(ModelDao) context.getBean("modelDao");
	}
	//@Ignore
	@Test
	public void addModelTest()
	{
		Model model=new Model();
		 model.setPhoneName("iphone");
		 model.setCost(120000);
		
		assertTrue("Problem in adding the model",modelDao.addModel(model));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Model model=modelDao.getModel(1);
		
		assertTrue("Problem in deleting model",modelDao.deleteModel(model));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Model model=modelDao.getModel(1);
		model.setCost(20000);
		
		assertTrue("Problem in updating model",modelDao.updateModel(model));
	}

}
