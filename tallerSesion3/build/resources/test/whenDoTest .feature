Feature: Agregar recordatorio

  Scenario: COMO usuario
            QUIERO ingresar detalles del recordatorio
            PARA QUE el sistema guarde el recordatorio

    Given yo abro el aplicativo
    When yo realizo click en agregarAlarma
    And yo realizo click en el boton fijarRecordatorio
    And yo realizo click en el boton ingresarFechaLimite
    And yo realizo click en el boton fijarHora
    And yo realizo click en el boton recordarATiempo : "15 minutos antes"
    And yo lleno la caja de texto titulo con : "Titulo de Prueba "
    And yo lleno la caja de texto notas con : "Notas de Prueba "
    And yo realizo click en el boton guardar
    Then yo deberia guardar el recordatorio : "Titulo de Prueba "
