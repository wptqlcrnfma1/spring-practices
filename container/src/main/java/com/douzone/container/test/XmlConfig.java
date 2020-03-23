package com.douzone.container.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douzone.container.user.Friend;
import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfig {

	public static void main(String[] args) {
		// XML Auto-Configuration(Annotation Scanning)
		// testBeanFactory01(); // 안쓸꺼

		// XML Bean Configuration(Implicit Configuration) 명시적 설정
		// testBeanFactory02(); // 안쓸꺼

		// XML Auto-Configuration(Annotation Scanning)
		testApplicationContext01();

		// XML Bean Configuration(Implicit Configuration) 명시적 설정
		testApplicationContext02();

	}

	public static void testApplicationContext02() {
		System.out.println("testApplicationContext02()");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext02.xml");

		// ** applicationContext02.xml 참고 **
		
		// id로 빈 가져오기
		User user = (User) appContext.getBean("user");
		System.out.println(user);

		// name으로 빈 가져오기
		user = (User) appContext.getBean("usr");
		System.out.println(user);

		// type으로 가져오기 > bean에 지정된 user type이 2개 있으므로 어떤걸 줘야할지 몰라서 에러가 발생한다.
		// 같은 타입의 객체가 2개 이상 있는 경우 type으로만 가져오면 에러! > type + id 또는 type + name
		// user = (User)appContext.getBean(user.getClass()); 오류!
		user = (User) appContext.getBean("user2", user.getClass());
		System.out.println(user);

		// 2개 파라미터 생성자로 생성된 빈 가져오기 : 생성자 파라미터와 같게 xml 설정
		user = (User) appContext.getBean("user3", user.getClass());
		System.out.println(user);

		// 2개 파라미터 생성자로 생성된 빈 가져오기 : 생성자 파라미터와 순서를 달리하고 index를 설정
		user = (User) appContext.getBean("user4", user.getClass());
		System.out.println(user);
		
		
		//setter 사용 빈 가져오기
		user = (User) appContext.getBean("user5", user.getClass());
		System.out.println(user);

		//바깥으로 friend를 빼서 사용하지만 밑의 소스를 참고해서 외부 객체를 여기서 안건들도록
		//Friend f = appContext.getBean(Friend.class);
		//System.out.println(f);
		
		// 위 소스 보안
		user = (User) appContext.getBean("user6", user.getClass());
		System.out.println(user);
		
		
		// list 받아오기
		user = (User) appContext.getBean("user7", user.getClass());
		System.out.println(user);
		
		
		// 자원정리
		((ConfigurableApplicationContext) appContext).close();

	}

	public static void testApplicationContext01() {
		System.out.println("testApplicationContext01()");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");

		User1 user1 = appContext.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean의 id가 자동으로 설정됨
		user1 = (User1) appContext.getBean("user1"); // 클래스 이름의 앞글자를 소문자로 자동으로 만들어진다.
		System.out.println(user1.getName());

		// 자원정리
		((ConfigurableApplicationContext) appContext).close();
	}

	/*
	 * 
	 * // XML Auto-Configuration(Annotation Scanning) public static void
	 * testBeanFactory01() { System.out.println("testBeanFactory01()"); BeanFactory
	 * bf = new XmlBeanFactory(new
	 * ClassPathResource("config/user/applicationContext01.xml"));
	 * 
	 * 
	 * User1 user1 = bf.getBean(User1.class); System.out.println(user1.getName());
	 * 
	 * 
	 * // Bean의 id가 자동으로 설정됨 user1 = (User1)bf.getBean("user1"); //클래스 이름의 앞글자를 소문자로
	 * 자동으로 만들어진다. System.out.println(user1.getName()); }
	 * 
	 * // XML Bean Configuration(Implicit Configuration) 명시적 설정 public static void
	 * testBeanFactory02() { System.out.println("testBeanFactory02()"); BeanFactory
	 * bf = new XmlBeanFactory(new
	 * ClassPathResource("config/user/applicationContext02.xml"));
	 * 
	 * 
	 * User1 user1 = bf.getBean(User1.class); System.out.println(user1.getName());
	 * 
	 * 
	 * // Bean 설정에서는 Bean의 id가 자동으로 설정되지 않음! 오류 user1 = (User1)bf.getBean("user1");
	 * //applicationContext02.xml 파일에 id를 임의 추가 System.out.println(user1.getName());
	 * }
	 */

}
