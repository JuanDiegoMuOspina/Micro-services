package co.edu.uniquindio.AsociacionLacteos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvioController {

    @PostMapping("/envios")
    public String crearEnvio(@RequestBody Envio envio) {
        // Aquí puedes hacer lo que necesites con el objeto Envio recibido
        // Por ejemplo, almacenarlo en una base de datos
        return "El envío se ha creado exitosamente";
    }
    @PostMapping("/envio")
    public String crearEnvios() {
        // Aquí puedes hacer lo que necesites con el objeto Envio recibido
        // Por ejemplo, almacenarlo en una base de datos
        return "El envío se ha creado exitosamente";
    }
}