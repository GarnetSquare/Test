package ru.garnec.nikita.alarmclock.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlarmClockServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmClockServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {

            System.out.println("=======================================");

            System.out.println("ALARM CLOCK SERVER SUCCESSFULLY STARTED.");
            System.out.println("Host: http://localhost:8080");

            System.out.println("=======================================");
        };
    }

}
