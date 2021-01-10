package tn.spring.bookStore;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EntityScan
public class BookStoreProjectApplication  {
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreProjectApplication.class, args);
		
	}
	
		
	

	

}
