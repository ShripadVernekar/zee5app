package com.zee.zee5app;

import java.math.BigDecimal;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repoistory.UserRepoistory;

public class MainSpring {

	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		
		UserRepoistory repoistory = applicationContext.getBean(UserRepoistory.class);
		System.out.println(repoistory);
		
		UserRepoistory repoistory2 = applicationContext.getBean(UserRepoistory.class);
		System.out.println(repoistory2);
		
		System.out.println(repoistory.hashCode());
		System.out.println(repoistory2.hashCode());
		
		System.out.println(repoistory.equals(repoistory2));
		
		DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
		System.out.println(dataSource != null);
		
		try {
			Register register = new Register("shri00018", "hari", "shankar", "harki314@gmail.com", "343323",new BigDecimal("9235567810"));
			System.out.println(repoistory.addUser(register));
		} catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationContext.close();

	}
}
