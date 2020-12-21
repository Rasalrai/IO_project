package pl.put.poznan.JSONtools.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.JSONtools.rest"})
public class JSONtoolsApp {
    public static void main(String[] args) {
        SpringApplication.run(JSONtoolsApp.class, args);
    }
}
