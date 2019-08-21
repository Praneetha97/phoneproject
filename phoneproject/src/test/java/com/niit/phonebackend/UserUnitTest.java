package com.niit.phonebackend;
import static org.junit.Assert.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import com.niit.bean.User;
import com.niit.dao.UserDao;
public class UserUnitTest {
@Autowired
	static UserDao userDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    userDao=(UserDao) context.getBean("UserDao");
	}
	//@Ignore
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUsername("prani");
		user.setPassword("prani12");
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setCustomerName("niha");
		
		assertTrue("Problem in adding the user",userDao.addUser(user));
	}
	@Ignore
	@Test
	public void deleteUserTest()
	{
		User user=userDao.getUser(1);
		
		assertTrue("Problem in deleting user",userDao.deleteUser(user));
	}
	@Ignore
	@Test
	public void updateUserTest()
	{
		User user=userDao.getUser(2 );
		user.setCustomerName("sweety");
		
		assertTrue("Problem in updating user",userDao.updateUser(user));
	}
}
