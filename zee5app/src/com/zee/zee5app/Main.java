package com.zee.zee5app;

import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.movies;
import com.zee.zee5app.dto.series;
import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.MovieServiceImpl;
import com.zee.zee5app.service.impl.SeriesServieImpl;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// register : reference which will refer the ur object
		// Register () : constructor =>DC==>IDC
		Register register = new Register();
		subscription Subscription = new subscription();
		movies Movies = new movies();
		series Series = new series();
		
		String res;
		
		

		try {
			register.setId("shri100");
			register.setFirstName("Shripad");
			register.setLastName("Vernekar");
			register.setEmail("shripad@gmail.com");
			register.setPassword("abcd@123");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(register);
		System.out.println(register.toString()); 
		// both gives same output since both call toString() method whenever we print reference
		System.out.println(register.getFirstName());
		
		Login login = new Login();
		
		login.setUserName("shripad");
		login.setPassword("abcd@123");
		
		System.out.println(login);
		
//		UserService1 service = UserService1.getInstance();
//		MovieService movieService = MovieService.getInstance();
//		SeriesService seriesService = SeriesService.getInstance();
//		SubscriptionService subscriptionService = SubscriptionService.getInstance();
		// main consuming from service according to layered arch
		
		// using interface
		UserService service = UserServiceImpl.getInstance();
		MovieService movieService = MovieServiceImpl.getInstance();
		SeriesService seriesService = SeriesServieImpl.getInstance();
		SubscriptionService subscriptionService = SubscriptionServiceImpl.getInstance();
	
//		Register
		
		for (int i=0;i<12;i++) {
			Register reg = new Register();
			try {
				reg.setId("shri00"+i);
				reg.setFirstName("shri"+i);
				reg.setLastName("Vernekar"+i);
				reg.setEmail("shri@g"+i);
				reg.setPassword("1234"+i);
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidEmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			res = service .addUser(reg);
			System.out.println(res);
		}
		
		
//		Register reg2 = service.getUserById("shri002");
//		System.out.println(reg2!=null);
		
		try {
			res = service.updateUser("shri001", register);
			System.out.println("update " + res);
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		


		try {
			res = service.deleteUserById("shri002");
			System.out.println("delete " + res);
		} catch (IdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		for(Register reg3 : service.getAllUsers()){
//			if(reg3 != null)
//				System.out.println(reg3);
////			System.out.println(reg3);
//		}

		try {
			Register reg1 = new Register("shri1100","shripad","Vernekar","Shri@gmail.com","shri1234");
			System.out.println(reg1);
		} catch (InvalidNameException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Optional<Register> optional = null;
		try {
			optional = service.getUserById("shri000");
			if(optional.isPresent()) {
				System.out.println("Got user by id "+ optional.get());
			}else {
				System.out.println("Id not found/available");
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.getAllUserDetails().forEach(e->System.out.println(e));
		
//		System.out.println(service.getAllUsers());
		
		
/*
	=================================Subscription=================================
		
		Subscription.setType("Annual");
		Subscription.setDateOfPurchase("12-01-2022");
		Subscription.setPackCountry("India");
		Subscription.setStatus("active");
		Subscription.setAutoRenewal("Yes");
		Subscription.setExpiryDate("12-01-2023");
		Subscription.setId("S01");
		Subscription.setPaymentMode("Card");
		
		res = subscriptionService .addSubscription(Subscription);
		System.out.println("subscription " + res);
*/		
		
		for (int i=1;i<=12;i++) {
			subscription sub = new subscription();
			try {
				sub.setId("Sub00"+i);
				sub.setType("Annual");
				sub.setStatus("Active");
				sub.setDateOfPurchase("12-"+i+"-2022");
				sub.setAmount(1000+i);
				sub.setPackCountry("India");
				sub.setPaymentMode("card");
				sub.setAutoRenewal("Yes");
				sub.setExpiryDate("12-"+i+"-2023");
			} catch(InvalidIdLengthException e) {
				e.printStackTrace();
			}catch (InvalidAmountException e) {
				e.printStackTrace();
			}
			
			res = subscriptionService.addSubscription(sub);
			System.out.println(res);
		}
		
		for(subscription Sub : subscriptionService.getAllSubscription()){
			if(Sub != null)
				System.out.println(Sub);
		}
		
//		subscription Sub;
//		try {
//			Sub = new subscription("new1100","Half-yearly","Active","13-01-2022",900,
//					"USA","card","No","13-07-2022");
//			System.out.println(Sub);
//		} catch (InvalidIdLengthException | InvalidAmountException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
////		System.out.println(Sub);
		
		
		
//	=================================Movie=================================
		String[] cast = new String[] {"Tom C", "Rock"};
		String[] location = new String[] {"India", "Dubai"};
		try {
			Movies.setCategory("Action");
			Movies.setId("A00112");
			Movies.setLanguage("English");
			Movies.setMovieName("MIB_intl");
			Movies.setReleaseDate("18-12-2019");
			Movies.setTrailer("http:youtube:sjsjkkf/9489de/");
			Movies.setAllowedLocations(location);
			Movies.setCast(cast);
			Movies.setLength(192.2f);
		} catch (InvalidNameException | InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		res = movieService.addMovie(Movies);
		System.out.println("movie " + res);
		
		Optional<movies> optional1 = null;
		try {
			optional1 = movieService.getMovieByName("MIB_intl");
			if(optional1.isPresent()) {
				System.out.println("Got movie by name "+ optional1.get());
			}else {
				System.out.println("Id not found/available");
			}
		} catch (LocationNotFoundException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//	=================================Series=================================
		String[] cast2 = new String[] {"Manoj", "Priyamani", "Sohail"};
		try {
			Series.setCategory("Drama");
			Series.setId("D00112");
			Series.setLanguage("Hindi");
			Series.setSeriesName("Family Man");
			Series.setReleaseDate("10-09-2020");
			Series.setTrailer("http:youtube:hfdjdsf/9124de/");
			Series.setCast(cast2);
			Series.setLength(302.2f);
		} catch (InvalidNameException | InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		res = seriesService .addSeries(Series);
		System.out.println("series "+ res); 
		
		
	}//end of main
}//end of class
