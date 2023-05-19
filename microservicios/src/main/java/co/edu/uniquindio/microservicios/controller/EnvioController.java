package co.edu.uniquindio.microservicios.controller;

import co.edu.uniquindio.microservicios.model.entity.CancelarEnvio;
import co.edu.uniquindio.microservicios.model.entity.Envio;
import co.edu.uniquindio.microservicios.model.entity.EstadoEnvio;
import co.edu.uniquindio.microservicios.model.entity.EstadoEnvioErr;
import co.edu.uniquindio.microservicios.service.CancelarEnvioService;
import co.edu.uniquindio.microservicios.service.EnvioService;
import co.edu.uniquindio.microservicios.service.EstadoEnvioService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Tag(name = "Envíos", description = "Operaciones relacionadas con la creaciòn, consulta y eliminaciòn de los envios")

@RestController
@RequestMapping("/compraproducto/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @Autowired
    private EstadoEnvioService estadoEnvioService;

    @Autowired
    private CancelarEnvioService cancelarEnvioService;

    // Consultar estado del envío
    @GetMapping("/{numeroSeguimiento}")
    public ResponseEntity<EstadoEnvio> consultarEstadoEnvio(@PathVariable @Parameter(description = "ID del envío a realizar el seguimiento"
            , required = true, example = "1") Long numeroSeguimiento) {
        EstadoEnvio estadoEnvio = estadoEnvioService.findById(numeroSeguimiento);
        if (estadoEnvio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(estadoEnvio, HttpStatus.OK);
    }

    // Actualizar el estado del envío
    @PutMapping("/actualizaenvio/{numeroSeguimiento}")
    public ResponseEntity<EstadoEnvio> actualizarEstadoEnvio(@PathVariable @Parameter(description = "numero de seguimiento del envío a buscar", required = true, example = "155421") Long numeroSeguimiento,
                                                             @RequestBody EstadoEnvio estadoEnvioActualizado) {
        EstadoEnvio estadoEnvio = estadoEnvioService.findByNumeroSeguimiento(numeroSeguimiento);
        if (estadoEnvio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        estadoEnvio.setDireccionEnvio(estadoEnvioActualizado.getDireccionEnvio());
        estadoEnvio.setFechaEnvio(estadoEnvioActualizado.getFechaEnvio());
        estadoEnvio.setInformacionSeguimiento(estadoEnvioActualizado.getInformacionSeguimiento());
        estadoEnvio.setDireccionEnvio(estadoEnvioActualizado.getDireccionEnvio());
        estadoEnvio.setCostoEnvio(estadoEnvioActualizado.getCostoEnvio());
        estadoEnvio.setEstadoEnvio(estadoEnvioActualizado.getEstadoEnvio());
        estadoEnvioService.save(estadoEnvio);
        return new ResponseEntity<>(estadoEnvio, HttpStatus.OK);
    }

    // Crear envío
    @PostMapping("/creaenvio")
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio envio) {
        EstadoEnvio estadoEnvio=new EstadoEnvio();
        estadoEnvio.setNumeroSeguimiento(System.currentTimeMillis());
        estadoEnvio.setEstadoEnvio("sin enviar");
        estadoEnvio.setInformacionSeguimiento("no se ha iniciado la entrega");
        estadoEnvio.setCostoEnvio(10);
        Envio envioCreado=envio;
        envioCreado.setEstadoEnvio(estadoEnvio);
         envioService.save(envioCreado);
        return new ResponseEntity<>(envioCreado, HttpStatus.CREATED);
    }

    // Cancelar envío
    @DeleteMapping("/cancelaelenvio/{idVenta}")
    public ResponseEntity<CancelarEnvio> cancelarEnvio(@PathVariable @Parameter(description = "ID del envío a cancelar", required = true, example = "2")Long idVenta, @RequestBody CancelarEnvio cancelarEnvio) {
        Envio envio = envioService.findById(idVenta);
        if (envio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CancelarEnvio cancelar=cancelarEnvio;
        cancelarEnvioService.save(cancelar);
        envioService.deleteById(idVenta);
        return new ResponseEntity<>(cancelar,HttpStatus.CREATED);
    }

    // Incidir entrega del envío
    @PostMapping("/incidenciaenvio")
    public ResponseEntity<EstadoEnvio> incidirEntregaEnvio(@RequestBody EstadoEnvioErr estadoEnvioIncidencia) {
        EstadoEnvio estadoEnvio = estadoEnvioService.findByNumeroSeguimiento(estadoEnvioIncidencia.getNumeroSeguimiento());
        if (estadoEnvio == null) {
            estadoEnvio=new EstadoEnvio();
            return new ResponseEntity<>(estadoEnvio,HttpStatus.NOT_FOUND);
        }
        estadoEnvio.setReclamo(estadoEnvioIncidencia.getReclamo());
        estadoEnvio.setEstadoEnvio("reparto");
        estadoEnvioService.save(estadoEnvio);
        return new ResponseEntity<>(estadoEnvio, HttpStatus.OK);
    }
}
