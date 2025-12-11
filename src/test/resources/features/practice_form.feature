Feature: Registro en el formulario PracticeForm

  Como usuario quiero registrarme en el formulario PracticeForm

  Scenario: Registro exitoso con campos obligatorios
    Given el usuario está en el formulario PracticeForm
    When ingresa el first name "diego"
    And ingresa el last name "sanchez"
    And selecciona el gender Male
    And ingresa el mobile number "1234567890"
    And hace click al button Submit
    Then me abre el modal de confirmacion
    And el título del modal debe ser "Thanks for submitting the form"
    And el contenido del modal debe mostrar el nombre completo "diego sanchez"

  Scenario: Registro con campos adicionales:
    Given el usuario está en el formulario PracticeForm
    When ingresa el first name "diego"
    And ingresa el last name "sanchez"
    And ingresa el email "diego@gmail.com"
    And selecciona el gender Male
    And ingresa el mobile number "1234567890"
    And selecciona un hobbie Sports
    And ingresa el current address "av. salaverry 2"
    And hace click al button Submit
    Then me abre el modal de confirmacion
    And el título del modal debe ser "Thanks for submitting the form"
    And el contenido del modal debe mostrar el nombre completo "diego sanchez"

  Scenario: Validacion de formulario incorrecto:
    Given el usuario está en el formulario PracticeForm
    When ingresa el first name "diego"
    And ingresa el last name "sanchez"
    And selecciona el gender Male
    And ingresa el mobile number ""
    And ingresa el current address "av. salaverry 2"
    And hace click al button Submit
    Then me marca en rojo el campo mobile number