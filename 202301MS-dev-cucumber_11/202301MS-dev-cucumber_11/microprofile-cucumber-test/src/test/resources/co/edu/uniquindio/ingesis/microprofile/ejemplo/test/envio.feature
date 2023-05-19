Feature: Gestión de envíos
  Como usuario de la API de gestión de envíos
  Quiero estar seguro de que todas las operaciones de envíos funcionan correctamente

  Scenario: Crear un nuevo envío
    Given que tengo los detalles de un nuevo envío
    When envío una solicitud POST a la operacion crearEnvio con los detalles del envío
    Then la respuesta debe ser 201 OK Y la respuesta debe contener los detalles del nuevo envío

  Scenario: Consultar el estado de un envío
    Given que tengo el número de seguimiento de un envío existente
    When envío una solicitud GET a numeroSeguimiento
    Then la respuesta debe ser 200 OK Y la respuesta debe contener los detalles del estado del envío

  Scenario: Actualizar el estado de un envío
    Given que tengo un número de seguimiento de un envío existente Y tengo el nuevo estado del envío
    When envío una solicitud PUT a numeroSeguimiento con los detalles del nuevo estado
    Then la respuesta debe ser 200 OK Y la respuesta debe contener los detalles del estado del envío actualizado

  Scenario: Crear una incidencia de entrega de un envío
    Given que tengo un envío con un problema
    When envío una solicitud POST a incidenciaenvio con los detalles del problema
    Then la respuesta debe ser 200 OK Y la respuesta debe contener los detalles del estado del envío con la incidencia

  Scenario: Cancelar un envío
    Given que tengo la ID de una venta con un envío asociado
    When envío una solicitud DELETE a idVenta con la justificación de la cancelación
    Then la respuesta debe ser 201 OK Y la respuesta debe contener los detalles de la cancelación del envío