package co.edu.uniquindio.AsociacionLacteos;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class EnvioController {

    public ArrayList<Envio> listaEnvios=new ArrayList<>();
    @PostMapping("/envios")
    public ArrayList<Envio> crearEnvio(@RequestBody Envio envio) {
        // Aquí puedes hacer lo que necesites con el objeto Envio recibido
        // Por ejemplo, almacenarlo en una base de datos
        listaEnvios.add(envio);

        System.out.println("Envío creado: " + envio.getNombreProducto());
        return listaEnvios;
    }
    @PostMapping("/envio")

    public String crearEnvios() {
        // Aquí puedes hacer lo que necesites con el objeto Envio recibido
        // Por ejemplo, almacenarlo en una base de datos
        return "El envío se ha creado exitosamente";
    }
}