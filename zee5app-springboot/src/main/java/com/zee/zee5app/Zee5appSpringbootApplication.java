package com.zee.zee5app;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appSpringbootApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appSpringbootApplication.class,
				args);

		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource != null);

		UserRepository repoistory = applicationContext.getBean(UserRepository.class);

		UserService service = applicationContext.getBean(UserService.class);
		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
		MovieService movieService = applicationContext.getBean(MovieService.class);
		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);

		System.out.println(repoistory);

		/*
		 * DataSource dSource1 = applicationContext.getBean("ds",DataSource.class);
		 * DataSource dSource2 = applicationContext.getBean("ds",DataSource.class);
		 * 
		 * System.out.println(dSource1.hashCode());
		 * System.out.println(dSource2.hashCode());
		 * System.out.println(dSource1.equals(dSource2));
		 */
/*
		Register register = new Register("shri000263", "Shri", "V", "shri8@gmail.com", "335323",
				new BigDecimal("9935569911"));
		System.out.println(service.addUser(register));
		
		for(int i=1;i<=5;i++) {
			subscription Subscription = new subscription();
			Subscription.setId("sub00"+i);
			Subscription.setDateOfPurchase("2022-0"+i+"-0"+i);
			Subscription.setExpiryDate("2023-0"+i+"-0"+i);
			Subscription.setAutoRenewal("Yes");
			Subscription.setAmount(499);
			Subscription.setType("Anuual");
			Subscription.setPaymentMode("Debit");
			Subscription.setRegId("reg00"+i);
			Subscription.setStatus("Active");
			subscriptionService.addSubscription(Subscription);
		}
		
		for(int i=1;i<=5;i++) {
			movies movie = new movies();
			movie.setId("mov00"+i);
			movie.setMovieName("Fast&Furious"+i);
			movie.setAgeLimit(10);
			movie.setCast("rock,xyz,abc");
			movie.setGenre("action");
			movie.setLanguage("English");
			movie.setTrailer("https://youtube:sjdghcg9"+i);
			movie.setReleaseDate("2022-0"+i+"-0"+i);
			movie.setLength(7090+i);
			movieService.addMovie(movie);
		}

		for (int i = 1; i <= 5; i++) {
			series Series = new series();
			Series.setId("ser00" + i);
			Series.setSeriesName("Money Heist" + i);
			Series.setAgeLimit(16);
			Series.setCast("Berlin,Tokyo,abc");
			Series.setGenre("Crime,Drama");
			Series.setLanguage("English");
			Series.setTrailer("https://youtube:sfgghcg9" + i);
			Series.setReleaseDate("2022-0" + i + "-0" + i);
			Series.setNoOfEpisodes(10);
			seriesService.addSeries(Series);
		}

		for (int i = 1; i <= 5; i++) {
			Episodes episodes = new Episodes();
			episodes.setEpiId("epi00" + i);
			episodes.setEpiLength(7080 + i);
			episodes.setEpisodeName("episode" + i);
			episodes.setLocation("India,US,Spain");
			episodes.setTrailer("https://youtube:sfgghscg9" + i);
			episodes.setSeriesId("ser00" + i);
			try {
				episodeService.addEpisode(episodes);
			} catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
		
		try {
			Optional<Register> optional = service.getUserById("shri00261");
			if(optional.isEmpty()) {
				System.out.println("Not found");
			}else {
				System.out.println("User found "+optional.get());
			}
		} catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException
				| com.zee.zee5app.exception.InvalidNameException | InvalidPasswordException | InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Optional<Subscription> optional = subscriptionService.getSubscriptionById("sub001");
			if(optional.isEmpty()) {
				System.out.println("Not found");
			}else {
				System.out.println("Subscription found "+optional.get());
			}
		} catch (IdNotFoundException |InvalidAmountException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			Optional<Movies> optional = movieService.getMovieById("mov001");
			if(optional.isEmpty()) {
				System.out.println("Not found");
			}else {
				System.out.println("Movie found "+optional.get());
			}
		} catch (IdNotFoundException |InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			Optional<Series> optional = seriesService.getSeriesById("ser002");
			if(optional.isEmpty()) {
				System.out.println("Not found");
			}else {
				System.out.println("series found "+optional.get());
			}
		} catch (IdNotFoundException |InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			Register[] list = service.getAllUsers();
			System.out.println(list) ;
		} catch (InvalidNameException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String res;
		
		try {
			res = service.deleteUserById("shri000261");
			System.out.println("User deletion :"+res);
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			res = subscriptionService.deleteSubscription("sub001");
			System.out.println("Subscription deletion :"+res);
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			res = movieService.deleteMovie("mov001");
			System.out.println("Movie deletion :"+res);
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			res = seriesService.deleteSeries("ser001");
			System.out.println("Series deletion :"+res);
		} catch (IdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		Optional<List<Register>> optional;
		try {
			optional = service.getAllUserDetails();
			if (optional.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional.get().forEach(e->System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Optional<List<Subscription>> optional1;
		try {
			optional1 = subscriptionService.getAllSubscription();
			if (optional1.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional1.get().forEach(e->System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidAmountException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Optional<List<Series>> optional3;
		try {
			optional3 = seriesService.getAllSeries();
			if (optional3.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional3.get().forEach(e->System.out.println(e));
			}
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Optional<List<Episodes>> optional4;
		try {
			optional4 = episodeService.getAllEpisodeList();
			if (optional4.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional4.get().forEach(e->System.out.println(e));
			}
		} catch (InvalidIdLengthException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Optional<List<Movies>> optional5;
		try {
			optional5 = movieService.getAllMovie();
			if (optional5.isEmpty()) {
				System.out.println("there are no records");
			}
			else {
				optional5.get().forEach(e->System.out.println(e));
			}
		} catch (InvalidIdLengthException | InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		applicationContext.close();

	}

}
