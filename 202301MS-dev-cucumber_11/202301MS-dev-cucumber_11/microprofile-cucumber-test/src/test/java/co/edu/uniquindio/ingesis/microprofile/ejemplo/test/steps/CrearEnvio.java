package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.steps;

import co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos.ConsultaPostGetDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CrearEnvio {

    private  String body=null;
    private int responseCode=0;
    private StringBuilder content=null;


    @Given("que tengo los detalles de un nuevo envío")
    public void queTengoLosDetallesDeUnNuevoEnvío() {
        body=
                "{"
                        + "\"nombreProducto\":\"Samsung S22 Ultra\","
                        + "\"url\":\"mercadolibre.com\","
                        + "\"origen\":\"Armina\","
                        + "\"destino\":\"Armenia\","
                        + "\"nombreRemitente\":\"Juan Manuel\","
                        + "\"cc\":1094958430"
                + "}";


    }

    @When("envío una solicitud POST a la operacion crearEnvio con los detalles del envío")
    public void invocoElServicioParaRegistrarUnEnvio() {
        ConsultaPostGetDto consultaPostGetDto= new ConsultaPostGetDto(body,"http://localhost:8080/compraproducto/envios/creaenvio");


            responseCode =consultaPostGetDto.getResponseCode();
            content=consultaPostGetDto.getContent();

    }

    @Then("la respuesta debe ser 201 OK Y la respuesta debe contener los detalles del nuevo envío")
    public void obtengoUnStatusCode() {
        assertEquals(201, responseCode);
        String body =
                "\"nombreProducto\":\"Samsung S22 Ultra\"," +
                        "\"url\":\"mercadolibre.com\"," +
                        "\"origen\":\"Armina\"," +
                        "\"destino\":\"Armenia\"," +
                        "\"nombreRemitente\":\"Juan Manuel\"," +
                        "\"cc\":1094958430" +
                        "}";

        boolean contiene = content.toString().contains(body);
        assertEquals(true, contiene);
    }


}
