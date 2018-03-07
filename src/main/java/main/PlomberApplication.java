package main;

import com.fasterxml.jackson.databind.Module;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlomberApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlomberApplication.class, args);
	}

    @Bean
    public Module vavrModule() {
        return new VavrModule();
    }
}
