package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.steps;

import co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos.ConsultaPostGetDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ConsultarEnvio {

    private  String body=null;
    private int responseCode=0;
    private StringBuilder content=null;


    @Given("que tengo el número de seguimiento de un envío existente")
    public void queTengoLosDetallesDeUnNuevoEnvío() {
        body="";


    }

    @When("envío una solicitud GET a numeroSeguimiento")
    public void invocoElServicioParaRegistrarUnEnvio() {
        ConsultaPostGetDto consultaPostGetDto= new ConsultaPostGetDto("http://localhost:8080/compraproducto/envios/10");


            responseCode =consultaPostGetDto.getResponseCode();
            content=consultaPostGetDto.getContent();

    }

    @Then("la respuesta debe ser 200 OK Y la respuesta debe contener los detalles del estado del envío")
    public void obtengoUnStatusCode() {
        assertEquals(200, responseCode);
        String body =
                "{\"id\":10,\"numeroSeguimiento\":1682531144081,\"estadoEnvio\":\"reparto\",\"reclamo\":\"no me a llegado mi artículo malandros tenia que ser\",\"fechaEnvio\":\"2023-04-26\",\"informacionSeguimiento\":\"En reparto, fecha de entrega confirmada\",\"direccionEnvio\":\"Armenia\",\"costoEnvio\":10000}";

        boolean contiene = content.toString().contains(body);
        assertEquals(true, contiene);
    }


}
