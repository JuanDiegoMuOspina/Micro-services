package co.edu.uniquindio.ingesis.microprofile.ejemplo.test.dtos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaPostGetDto {
    private  String body=null;
    private int responseCode=0;
    private StringBuilder content=null;
    protected String url;

    public ConsultaPostGetDto(String body, String url) {
        this.body = body;
        this.url = url;
        invocoElServicioParaRegistrarUnEnvio();
    }
    public ConsultaPostGetDto( String url) {

        this.url = url;
        invocoElServicioParaConsultarRegistro();
    }
    public ConsultaPostGetDto( String body,String url,String metodo) {
        this.body = body;
        this.url = url;

        if (metodo.equals("PUT")){
            invocoElServicioParaActualizarUnEnvio();
        }else {
            invocoElServicioParaCancelarUnEnvio();
        }

    }

    public void invocoElServicioParaRegistrarUnEnvio() {

        String jsonBody =body;
        HttpURLConnection connection = null;

        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();

            // Configurar conexión
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Enviar solicitud
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonBody.getBytes());
            outputStream.flush();
            outputStream.close();

            // Leer respuesta
            responseCode = connection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            content = new StringBuilder();

            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerrar conexiones
            bufferedReader.close();

            // Imprimir resultados
            System.out.println("Response code: " + responseCode);
            System.out.println("Response content: " + content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }
    public void invocoElServicioParaConsultarRegistro() {
        HttpURLConnection connection = null;

        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();

            // Configurar conexión
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            // Leer respuesta
            responseCode = connection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            content = new StringBuilder();

            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerrar conexiones
            bufferedReader.close();

            // Imprimir resultados
            System.out.println("Response code: " + responseCode);
            System.out.println("Response content: " + content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public void invocoElServicioParaActualizarUnEnvio() {
        String jsonBody = body;
        HttpURLConnection connection = null;

        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();

            // Configurar conexión
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Enviar solicitud
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonBody.getBytes());
            outputStream.flush();
            outputStream.close();

            // Leer respuesta
            responseCode = connection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            content = new StringBuilder();

            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerrar conexiones
            bufferedReader.close();

            // Imprimir resultados
            System.out.println("Response code: " + responseCode);
            System.out.println("Response content: " + content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public void invocoElServicioParaCancelarUnEnvio() {
        String jsonBody = body;

        HttpURLConnection connection = null;

        try {
            URL urlObj = new URL(url);
            connection = (HttpURLConnection) urlObj.openConnection();

            // Configurar conexión
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Enviar solicitud
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonBody.getBytes());
            outputStream.flush();
            outputStream.close();

            // Leer respuesta
            responseCode = connection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            content = new StringBuilder();

            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerrar conexiones
            bufferedReader.close();

            // Imprimir resultados
            System.out.println("Response code: " + responseCode);
            System.out.println("Response content: " + content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


    public int getResponseCode() {
        return responseCode;
    }

    public StringBuilder getContent() {
        return content;
    }

}
