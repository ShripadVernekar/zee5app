package com.zee.zee5app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.repoistory.UserRepoistory;

@SpringBootApplication
public class Zee5appSpringbootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =	SpringApplication.run(Zee5appSpringbootApplication.class, args);
		
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource!=null);
		
		UserRepoistory repoistory = applicationContext.getBean(UserRepoistory.class);
		System.out.println(repoistory);
		
		
/*		
		DataSource dSource1 = applicationContext.getBean("ds",DataSource.class);
		DataSource dSource2 = applicationContext.getBean("ds",DataSource.class);
		
		System.out.println(dSource1.hashCode());
		System.out.println(dSource2.hashCode());
		System.out.println(dSource1.equals(dSource2));
*/
		
		try {
			Register register = new Register("shri000161", "harish", "shankar", "harish4@gmail.com", "341323",new BigDecimal("9235569810"));
			System.out.println(repoistory.addUser(register));
		} catch (InvalidIdLengthException |javax.naming.InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		applicationContext.close();
		
	}

}
