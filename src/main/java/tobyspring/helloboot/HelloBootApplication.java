package tobyspring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class HelloBootApplication {
    private final JdbcTemplate jdbcTemplate;

    public HelloBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init(){
        jdbcTemplate.execute("create table if not EXISTS hello(name VARCHAR (50) PRIMARY KEY , count INT )");
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloBootApplication.class, args);
    }
}
