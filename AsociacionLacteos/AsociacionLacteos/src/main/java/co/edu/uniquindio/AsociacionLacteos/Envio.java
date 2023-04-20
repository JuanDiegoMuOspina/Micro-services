package co.edu.uniquindio.AsociacionLacteos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Envio {
    @JsonProperty("nombreProducto")
    private String nombreProducto;

    @JsonProperty("Url")
    private String url;

    @JsonProperty("origen")
    private String origen;

    @JsonProperty("destino")
    private String destino;

    @JsonProperty("NombreRemitente")
    private String nombreRemitente;

    @JsonProperty("cc")
    private long cc;
}