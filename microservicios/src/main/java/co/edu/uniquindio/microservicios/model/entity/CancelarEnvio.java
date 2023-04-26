package co.edu.uniquindio.microservicios.model.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "cancelar_envios")
@Getter
@Setter
@AllArgsConstructor
public class CancelarEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NonNull
    private Integer idVenta;
    @NonNull
    private String url;
    @NonNull
    private String verDetalle;
    @NonNull
    private String buzonJustificacion;
}
