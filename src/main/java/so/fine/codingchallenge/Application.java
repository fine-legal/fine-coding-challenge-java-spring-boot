package so.fine.codingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "so.fine.codingchallenge.repository")
@EntityScan("so.fine.codingchallenge.types")
public class Application {
    
    public static void main(String[] args){

        System.out.println("Application run start");
        SpringApplication.run(Application.class, args);
    }
}
