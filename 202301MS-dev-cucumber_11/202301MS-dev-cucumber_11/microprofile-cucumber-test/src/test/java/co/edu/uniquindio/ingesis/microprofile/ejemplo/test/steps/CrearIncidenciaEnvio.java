package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.steps;

import co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos.ConsultaPostGetDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CrearIncidenciaEnvio {

    private  String body=null;
    private int responseCode=0;
    private StringBuilder content=null;


    @Given("que tengo un envío con un problema")
    public void queTengoLosDetallesDeUnNuevoEnvío() {
        body=
                "{\n" +
                        "    \"numeroSeguimiento\": 1682531144081,\n" +
                        "    \"estadoEnvio\": \"Reparto\",\n" +
                        "    \"reclamo\": \"no me a llegado mi artículo malandros tenia que ser\"\n" +
                        "}";


    }

    @When("envío una solicitud POST a incidenciaenvio con los detalles del problema")
    public void invocoElServicioParaRegistrarUnEnvio() {
        ConsultaPostGetDto consultaPostGetDto= new ConsultaPostGetDto(body,"http://localhost:8080/compraproducto/envios/incidenciaenvio");


            responseCode =consultaPostGetDto.getResponseCode();
            content=consultaPostGetDto.getContent();

    }

    @Then("la respuesta debe ser 200 OK Y la respuesta debe contener los detalles del estado del envío con la incidencia")
    public void obtengoUnStatusCode() {
        assertEquals(200, responseCode);
        String body =
                "\"numeroSeguimiento\":1682531144081,\"estadoEnvio\":\"reparto\",\"reclamo\":\"no me a llegado mi artículo malandros tenia que ser\",\"fechaEnvio\":\"2023-04-26\",\"informacionSeguimiento\":\"En reparto, fecha de entrega confirmada\",\"direccionEnvio\":\"Armenia\",\"costoEnvio\":10000}";

        boolean contiene = content.toString().contains(body);
        assertEquals(true, contiene);
    }


}
