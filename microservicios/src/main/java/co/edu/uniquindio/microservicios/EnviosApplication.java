package co.edu.uniquindio.microservicios;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(info = @Info(title = "Gestiòn de envios", version = "1.0", description = "API para gestionar envíos de los usuarios que han realizado compras, las operaciones van orientadas a usuarios y empresas de envios"))

@SpringBootApplication
public class EnviosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviosApplication.class, args);
	}

}
