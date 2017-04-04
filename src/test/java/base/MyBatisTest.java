package base;

import com.springmvc.model.UserInfo;
import com.springmvc.service.UserInfoService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyBatisTest {

	private ApplicationContext context = null;
	
	@Before
	public void beforeTest() {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}


@Test
	public void deleteUserTest() {

		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserInfoService userInfoService = (UserInfoService) ctx.getBean("userInfoService");
		// UserInfo user = new UserInfo()
		UserInfo userii = new UserInfo();
		userii.setUserName("liaody");
		userii.setUserPassword("123");
		UserInfo user1 = userInfoService.getUser(userii);
		System.out.println(user1.getUserEmail().toString());
	}

}
