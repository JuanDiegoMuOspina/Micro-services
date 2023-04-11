Feature: El API de envios registra los envios realizados por los usuarios de la plataforma

  Scenario: Yo como usuario con acceso al API, deseo realizar registro de nuevos productos
            de forma que podamos tener registro a futuro de los mismo.
    Given Soy un usuario que tiene acceso al Url del Api para registro de envios
    When invoco el servicio para registrar un envio
    Then obtengo un status code 200

