package springboothackathon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springboothackathon.controllers.HomeController;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = {"controllers"})
@ComponentScan(basePackageClasses = HomeController.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
