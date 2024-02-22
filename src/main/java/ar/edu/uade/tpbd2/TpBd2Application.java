package ar.edu.uade.tpbd2;

import ar.edu.uade.tpbd2.dao.MongoDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpBd2Application {

	public static void main(String[] args) {
		MongoDB mongoDB = MongoDB.getInstance();
		SpringApplication.run(TpBd2Application.class, args);
	}

}
