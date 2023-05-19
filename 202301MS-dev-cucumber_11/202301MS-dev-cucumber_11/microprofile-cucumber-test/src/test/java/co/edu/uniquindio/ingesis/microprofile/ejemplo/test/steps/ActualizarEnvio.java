package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.steps;

import co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos.ConsultaPostGetDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActualizarEnvio {

    private  String body=null;
    private int responseCode=0;
    private StringBuilder content=null;


    @Given("que tengo un número de seguimiento de un envío existente Y tengo el nuevo estado del envío")
    public void queTengoLosDetallesDeUnNuevoEnvío() {
        body="{\n" +
                "    \"numeroSeguimiento\": 1682531144081,\n" +
                "    \"estadoEnvio\": \"Reparto\",\n" +
                "    \"fechaEnvio\": \"2023-04-26\",\n" +
                "    \"informacionSeguimiento\": \"En reparto, fecha de entrega confirmada\",\n" +
                "    \"direccionEnvio\": \"Armenia\",\n" +
                "    \"costoEnvio\": \"10000\",\n" +
                "    \"reclamo\": \"no registra reclamo\"\n" +
                "}";


    }

    @When("envío una solicitud PUT a numeroSeguimiento con los detalles del nuevo estado")
    public void invocoElServicioParaRegistrarUnEnvio() {
        ConsultaPostGetDto consultaPostGetDto= new ConsultaPostGetDto(body,"http://localhost:8080/compraproducto/envios/actualizaenvio/1682531144081","PUT");
        responseCode =consultaPostGetDto.getResponseCode();
        content=consultaPostGetDto.getContent();

    }

    @Then("la respuesta debe ser 200 OK Y la respuesta debe contener los detalles del estado del envío actualizado")
    public void obtengoUnStatusCode() {
        assertEquals(200, responseCode);
        String body =
                "\"numeroSeguimiento\":1682531144081,\"estadoEnvio\":\"Reparto\",\"reclamo\":\"no me a llegado mi artículo malandros tenia que ser\",\"fechaEnvio\":\"2023-04-26\",\"informacionSeguimiento\":\"En reparto, fecha de entrega confirmada\",\"direccionEnvio\":\"Armenia\",\"costoEnvio\":10000}";

        boolean contiene = content.toString().contains(body);
        assertEquals(true, contiene);
    }


}
