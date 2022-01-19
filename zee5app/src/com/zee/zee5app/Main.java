package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.movie_dto.movies;
import com.zee.zee5app.movie_service.MovieService;
import com.zee.zee5app.series_dto.series;
import com.zee.zee5app.series_service.SeriesService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.subscription_dto.subscription;
import com.zee.zee5app.subscription_service.SubscriptionService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// register : reference which will refer the ur obj
		// Register () : constructor =>DC==>IDC
		Register register = new Register();
		subscription Subscription = new subscription();
		movies Movies = new movies();
		series Series = new series();
		
		String res;
		
		register.setFirstName("Shripad");
		register.setLastName("V");
		register.setEmail("shripad@gmail.com");
		register.setPassword("abcd@123");
		register.setId("s1");
		
		System.out.println(register);
		System.out.println(register.toString()); 
		// both gives same output since both call toString() method whenever we print reference
		System.out.println(register.getFirstName());
		
		Login login = new Login();
		
		login.setUserName("shripad");
		login.setPassword("abcd@123");
		
		System.out.println(login);
		
		UserService service = UserService.getInstance();
		MovieService movieService = MovieService.getInstance();
		SeriesService seriesService = SeriesService.getInstance();
		SubscriptionService subscriptionService = SubscriptionService.getInstance();
		// main consuming from service according to layered arch
	
//		Register
		
		for (int i=0;i<12;i++) {
			Register reg = new Register();
			reg.setId("shri00"+i);
			reg.setFirstName("shri"+i);
			reg.setLastName("V"+i);
			reg.setEmail("shri@g"+i);
			reg.setPassword("123"+i);
			res = service .addUser(reg);
//			System.out.println(res);
		}
		
		Register reg2 = service.getUserById("shri002");
		System.out.println(reg2!=null);
		
		res = service.updateUser("shri001", register);
		System.out.println("update " + res);
		
		res = service.deleteUser("shri001");
		System.out.println("delete " + res);
		
		for(Register reg3 : service.getUsers()){
			if(reg3 != null)
				System.out.println(reg3);
//			System.out.println(reg3);
		}
		
//		Subscription
		
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
		
//		Movie
		String[] cast = new String[] {"Tom C", "Rock"};
		Movies.setCategory("Action");
		Movies.setId("A112");
		Movies.setLanguage("English");
		Movies.setMovieName("MIB intl");
		Movies.setReleaseDate("18-12-2019");
		Movies.setTrailer("http:youtube:sjsjkkf/9489de/");
		Movies.setCast(cast);
		Movies.setLength(192.2f);
		
		res = movieService .addMovie(Movies);
		System.out.println("movie " + res);
		
//		Series
		String[] cast2 = new String[] {"Manoj", "Priyamani", "Sohail"};
		Series.setCategory("Drama");
		Series.setId("D112");
		Series.setLanguage("Hindi");
		Series.setSeriesName("Family Man");
		Series.setReleaseDate("10-09-2020");
		Series.setTrailer("http:youtube:hfdjdsf/9124de/");
		Series.setCast(cast2);
		Series.setLength(302.2f);
		
		res = seriesService .addSeries(Series);
		System.out.println("series "+ res);
		
	}//end of main
}//end of class
