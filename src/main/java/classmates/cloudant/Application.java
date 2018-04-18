package classmates.cloudant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(classmates.cloudant.Application.class, args);
        System.out.println("Classmates collection is ready!");
    }
}
