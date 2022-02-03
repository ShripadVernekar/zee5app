package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.movies;
import com.zee.zee5app.dto.series;
import com.zee.zee5app.dto.subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MoviesRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.RoleServie;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appSpringbootApplication.class,
				args);
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
		
		UserService service = applicationContext.getBean(UserService.class);
		RoleServie roleServie = applicationContext.getBean(RoleServie.class);
		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//		
		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
		Register register ;
		try {
			register = new Register("shri000272", "Shripad", "Vernekar", "yahoo131@gmail.com", "335323",
					new BigDecimal("9935569911"), null,null);
			Set<Role> roles = new HashSet<>();
			roles.add(roleRepository.findById(1).get());
			roles.add(roleRepository.findById(2).get());
			register.setRoles(roles);
			subscription sub = new subscription("Sub001", "2022-02-02", "2023-02-02", 499, "Debit", "Active", "Annual", "Yes", register);
			
			System.out.println(service.addUser(register));
			System.out.println(subscriptionService.addSubscription(sub));
		} catch (AlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		
		
//		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
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
		applicationContext.close();

	}

}
