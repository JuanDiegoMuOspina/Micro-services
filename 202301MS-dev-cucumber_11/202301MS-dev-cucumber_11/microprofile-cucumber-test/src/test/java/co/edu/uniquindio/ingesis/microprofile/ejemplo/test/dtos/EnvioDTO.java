package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;



@Getter
@Builder
@RequiredArgsConstructor(onConstructor_= @ConstructorProperties({"nombre", "origen","destino"}))
public class EnvioDTO {

    private final String nombre;
    private final String origen;
    private final String destino;


}
