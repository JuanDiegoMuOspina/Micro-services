package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.steps;

import co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos.ConsultaPostGetDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CancelarEnvio {

    private  String body=null;
    private int responseCode=0;
    private StringBuilder content=null;
    private  int valor=14;


    @Given("que tengo la ID de una venta con un envío asociado")
    public void queTengoLosDetallesDeUnNuevoEnvío() {
        body="{\n" +
                "    \"idVenta\": "+valor+",\n" +
                "    \"url\": \"mercadolibre.com\",\n" +
                "    \"verDetalle\": \"Compra Samsung S22 en Armenia\",\n" +
                "    \"buzonJustificacion\": \"Cancelo pedido porque se demoró en la entrega\"\n" +
                "}";


    }

    @When("envío una solicitud DELETE a idVenta con la justificación de la cancelación")
    public void invocoElServicioParaRegistrarUnEnvio() {
        ConsultaPostGetDto consultaPostGetDto= new ConsultaPostGetDto(body,"http://localhost:8080/compraproducto/envios/cancelaelenvio/"+valor,"DELETE");
        responseCode =consultaPostGetDto.getResponseCode();
        content=consultaPostGetDto.getContent();

    }

    @Then("la respuesta debe ser 201 OK Y la respuesta debe contener los detalles de la cancelación del envío")
    public void obtengoUnStatusCode() {
        assertEquals(201, responseCode);
        String body =
                "\"url\":\"mercadolibre.com\",\"verDetalle\":\"Compra Samsung S22 en Armenia\",\"buzonJustificacion\":\"Cancelo pedido porque se demoró en la entrega\"}";

        boolean contiene = content.toString().contains(body);
        assertEquals(true, contiene);
    }


}
