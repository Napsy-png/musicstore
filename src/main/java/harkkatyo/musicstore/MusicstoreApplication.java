package harkkatyo.musicstore;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import harkkatyo.musicstore.domain.Genre;
import harkkatyo.musicstore.domain.GenreRepository;
import harkkatyo.musicstore.domain.LP;
import harkkatyo.musicstore.domain.LPRepository;


@SpringBootApplication
public class MusicstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MusicstoreApplication.class);
		
	public static void main(String[] args) {
		SpringApplication.run(MusicstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner musicRunner(LPRepository lrepo, GenreRepository grepo){
		return (args) -> {
			log.info("save categories to H2-database");
			grepo.save(new Genre("Jazz"));
			grepo.save(new Genre("Pop"));
			
			log.info("save LPs to H2-database");
			lrepo.save(new LP("Greatest Hits", "Daniel Buselli", 2020,
						grepo.findByName("Jazz").get(0)));
			lrepo.save(new LP("Midnight", "Elope", 2020,
					grepo.findByName("Pop").get(0)));

			
		
	};
		
	}
	
}
