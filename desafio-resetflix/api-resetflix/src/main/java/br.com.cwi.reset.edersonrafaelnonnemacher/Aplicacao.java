package br.com.cwi.reset.edersonrafaelnonnemacher;

// http://localhost:8080/h2-console
// JDBC URL jdbc:h2:file:~/resetflix

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplicacao {
    public static void main(String[] args) throws Exception {

        SpringApplication.run(Aplicacao.class, args);
    }
}
