package co.edu.uniquindio.microservicios.model.entity;

import javax.persistence.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "envios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombreProducto;
    @NotNull
    private String url;
    @NotNull
    private String origen;
    @NotNull
    private String destino;
    @NotNull
    private String nombreRemitente;
    @NotNull
    private Long cc;
    @Hidden
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado_envio_id", referencedColumnName = "id")
    private EstadoEnvio estadoEnvio;
}
