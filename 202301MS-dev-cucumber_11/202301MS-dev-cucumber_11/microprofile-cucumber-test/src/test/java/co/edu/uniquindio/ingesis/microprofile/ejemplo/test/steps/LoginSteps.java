package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.steps;

import co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos.EnvioDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.net.http.HttpHeaders;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class LoginSteps {

    private EnvioDTO loginDTO;
    private static final String BASE_URL = "http://localhost:8080/envios";
    private Response response;
    @Given("Soy un usuario que tiene acceso al Url del Api para registro de envios")
    public void soyUnUsuarioRegistradoDelSistemaUsandoCredencialesValidas() {
        loginDTO = EnvioDTO.builder().nombre("Juan").origen("alemania").destino("Francia").build();
    }

    @When("invoco el servicio para registrar un envio")
    public void invocoElServicioParaRegistrarUnEnvio() {
        baseURI = BASE_URL;
        response = given().contentType(ContentType.JSON).body(loginDTO).when().post();

    }

    @Then("obtengo un status code 200")
    public void obtengoUnStatusCode() {
        response.then().statusCode(200);
    }


}
