package com.niit.phonebackend;
import static org.junit.Assert.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import com.niit.bean.Product;
import com.niit.dao.ProductDao;
public class ProductUnitTest {
@Autowired
	static ProductDao productDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    productDao=(ProductDao) context.getBean("productDao");
	}
	//@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("samsung");
		product.setProductDesc("android");
		
		assertTrue("Problem in adding the product",productDao.addProduct(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDao.getProduct(1);
		
		assertTrue("Problem in deleting product",productDao.deleteProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDao.getProduct(2 );
		product.setProductDesc("android");
		
		assertTrue("Problem in updating product",productDao.updateProduct(product));
	}
}
