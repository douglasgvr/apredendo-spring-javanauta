package apredendo_spring;

import apredendo_spring.infastructure.entity.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApredendoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApredendoSpringApplication.class, args);

		Usuario douglas = new Usuario("Douglas", "douglas@email.com", "123456");
		System.out.println("Douglas email: " + douglas.getEmail());
	}

}
