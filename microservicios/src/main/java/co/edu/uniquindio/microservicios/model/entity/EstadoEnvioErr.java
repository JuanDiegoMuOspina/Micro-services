package co.edu.uniquindio.microservicios.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoEnvioErr {

    private Long numeroSeguimiento;

    private String estadoEnvio;

    private String reclamo;

}

