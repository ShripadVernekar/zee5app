package com.zee.zee5app;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.RoleServie;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.utils.FileUtils;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appSpringbootApplication.class,
				args);
//		MovieService movieService = applicationContext.getBean(MovieService.class);
//		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
		
//		UserRepository repository = applicationContext.getBean(UserRepository.class);

//		System.out.println(repository.existsByEmail("shri8@gmail.com"));
		// here combining of two conditions using and
//		System.out.println(repository.existsByEmailAndContactNumber("shri8@gmail.com",new BigDecimal("9213456780")));

//		MoviesRepository moviesRepository = applicationContext.getBean(MoviesRepository.class);
//		System.out.println(moviesRepository.existsByMovieName("KGF"));
//		System.out.println(moviesRepository.findByMovienameAndLanguage("KGF","Kannada"));

//		Optional<movies> optional = moviesRepository.findByMovieNameAndLanguage("KGF","Kannada");
//		System.out.println(optional.get());
//		
//		Optional<movies> moviesRel = moviesRepository.findByMovieNameAndReleaseDate("KGF", "2022-04-04");
//		System.out.println(moviesRel.get());
//		
//		Optional<List<movies>> optional2 = moviesRepository.findByCast("rdj,pp");
//		optional2.get().forEach(e->System.out.println(e));
//		
//		SeriesRepository seriesRepository = applicationContext.getBean(SeriesRepository.class);
//		Optional<series> optional = seriesRepository.findBySeriesNameAndLanguage("Dark3","English");
//		System.out.println(optional.get());
//
//		Role role = new Role();
//		role.setRoleName(EROLE.ROLE_ADMIN);
//
//		Role role2 = new Role();
//		role2.setRoleName(EROLE.ROLE_USER);
//
//		RoleServie roleServie = applicationContext.getBean(RoleServie.class);
//		System.out.println(roleServie.addRole(role));
//		System.out.println(roleServie.addRole(role2));

//		UserService service = applicationContext.getBean(UserService.class);
//		RoleServie roleServie = applicationContext.getBean(RoleServie.class);
//		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
////		
//		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
//		Register register ;
//		try {
//			register = new Register("shri000272", "Shripad", "Vernekar", "yahoo131@gmail.com", "335323",
//					new BigDecimal("9935569911"), null,null);
//			Set<Role> roles = new HashSet<>();
//			roles.add(roleRepository.findById(1).get());
//			roles.add(roleRepository.findById(2).get());
//			register.setRoles(roles);
//			subscription sub = new subscription("Sub001", "2022-02-02", "2023-02-02", 499, "Debit", "Active", "Annual", "Yes", register);
//			
//			System.out.println(service.addUser(register));
//			System.out.println(subscriptionService.addSubscription(sub));
//		} catch (AlreadyExistsException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

//		series Series = new series();
//		Series.setId("ser001");
//		Series.setGenre("Action");
//		Series.setCast("MB,PP,SH");
//		Series.setLanguage("Hindi");
//		Series.setTrailer("https:youtube/shdghs88");
//		Series.setReleaseDate("2021-10-02");
//		Series.setAgeLimit(12);
//		Series.setNoOfEpisodes(10);
//		Series.setEpisodes(null);
//		Series.setSeriesName("Family Man");
//		
////		System.out.println(seriesService.addSeries(Series));
//		
//		Episodes episodes = new Episodes("epi001", "episode1", 120, "drive", "https:youtube/sjd", Series);
//		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
//		try {
//			System.out.println(episodeService.addEpisode(episodes));
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		

//		movies movie = new movies();
//		movie.setId("mov001");
//		movie.setAgeLimit(18);
//		movie.setCast("Allu Arjun");
//		movie.setLanguage("hindi");
//		movie.setLength(250);
//		movie.setMovieName("pushpa");
//		movie.setGenre("abc");
//		FileInputStream fileInputStream = null;
//		try {
//			fileInputStream = new FileInputStream("C:\\Users\\shripad.vernekar\\Downloads\\video.mp4");
//			long fileSize = new File("C:\\Users\\shripad.vernekar\\Downloads\\video.mp4").length();
//			byte[] allBytes = new byte[(int) fileSize];
//
//			fileInputStream.read(allBytes);
//
//			movie.setTrailer(allBytes);
//
//			movie.setReleaseDate("2022-12-15");
//			movieService.addMovie(movie);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				fileInputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		FileOutputStream fileOutputStream =null;
//		try {
//			Optional<Movies> optional = movieService.getMovieById("mov001");
//			if(optional.isEmpty()) {
//				System.out.println("record not found");
//			}else {
//				// we shd print info and copy file to movies folder with name
//				Movies movie = optional.get();
//				fileOutputStream = new FileOutputStream("C:\\Users\\shripad.vernekar\\Videos\\read\\video2.mp4");
//				fileOutputStream.write(movie.getTrailer());			}
//		} catch (InvalidNameException | IdNotFoundException | InvalidIdLengthException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				fileOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}		}
//
//		applicationContext.close();
//
//	}

//		
//		Movies movie = new Movies();
//		movie.setId("mov001");
//		
//		movie.setAgeLimit(18);
//		movie.setCast("Allu Arjun");
//		movie.setLanguage("hindi");
//		movie.setLength(250);
//		movie.setMovieName("pushpa");
//		movie.setGenre("abc");
//		FileInputStream fileInputStream = null;
//		FileOutputStream fileOutputStream = null;
//		try {
//		 fileInputStream = new FileInputStream("C:\\Users\\shripad.vernekar\\Downloads\\video.mp4");
//		 File file = new File("C:\\Users\\shripad.vernekar\\Downloads\\video.mp4");
//		 long fileSize= file.length();
//         byte[] allBytes = new byte[(int) fileSize];
//         
//         
//         movie.setTrailer("C:\\Users\\shripad.vernekar\\Videos\\movieStore\\"+file.getName());
//         
//         movie.setReleaseDate("2022-12-15");
//       String result =  movieService.addMovie(movie);
//       
//       if(result.equals("success")) {
//    	   
//    	   fileOutputStream = new FileOutputStream("C:\\Users\\shripad.vernekar\\Videos\\movieStore\\"+file.getName());
//
//    	   fileInputStream.read(allBytes);
//    	   fileOutputStream.write(allBytes);
//    	   
//       }
//         
//         
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				fileInputStream.close();
//				fileOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
		

//		Series series = new Series();
//		series.setId("ser001");
//		series.setAgeLimit(18);
//		series.setCast("Manoj B");
//		series.setLanguage("hindi");
//		series.setSeriesName("Family Man");
//		series.setGenre("abc");
//		series.setEpisodes(null);
//		series.setNoOfEpisodes(10);
//		series.setReleaseDate("2022-09-09");
//		FileInputStream fileInputStream = null;
//		FileOutputStream fileOutputStream = null;
//		FileUtils fileUtils = new FileUtils();
//		try {
//		 
//		 File file = new File("C:\\Users\\shripad.vernekar\\Downloads\\new.mp4");
//		 byte[] allBytes = fileUtils.readFile(file);
//         
//         series.setTrailer("C:\\Users\\shripad.vernekar\\Videos\\movieStore\\"+file.getName());
//         
//       String result =  seriesService.addSeries(series);
//       
//       if(result.equals("success")) {
//    	   fileInputStream = new FileInputStream("C:\\Users\\shripad.vernekar\\Downloads\\new.mp4");
//    	   fileInputStream.read(allBytes);
//    	   String res = fileUtils.writeFile(allBytes, "C:\\Users\\shripad.vernekar\\Videos\\movieStore\\");
//    	   if(res.equals("success")) {
//    		   System.out.println("Record added! ");
//    	   }else {
//    		   System.out.println("Record not added!");
//    	   }
//    	   
//       }
//         
//         
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				fileInputStream.close();
//				fileOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
	}
}
