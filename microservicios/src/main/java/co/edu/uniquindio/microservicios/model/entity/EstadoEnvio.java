package co.edu.uniquindio.microservicios.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
@Schema(description = "Información sobre el estado de un envío")
@Entity
@Table(name = "estado_envios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "numero seguimiento", example = "1")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_seguimiento", unique = true)
    private Long numeroSeguimiento;
    @Schema(description = "estado envio", example = "procesando")
    @Column(name = "estado_envio")
    private String estadoEnvio;
    @Schema(description = "cadena de texto para queja", example = "no llega rusver")
    @Column(name = "reclamo")
    private String reclamo;
    @Schema(description = "fecha cuando llega el envio", example = "2023-04-26")
    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

    @Column(name = "informacion_seguimiento")
    private String informacionSeguimiento;

    @Column(name = "direccion_envio")
    private String direccionEnvio;

    @Column(name = "costo_envio")
    private Integer costoEnvio;

    // Agrega aquí cualquier otro campo que necesites
    @Hidden
    @JsonBackReference
    @OneToOne(mappedBy = "estadoEnvio")
    private Envio envio;

    // Getters y setters (puedes usar Lombok para generarlos automáticamente)
    // ...
}

