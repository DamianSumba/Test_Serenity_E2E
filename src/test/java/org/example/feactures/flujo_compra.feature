Feature: Flujo de compra en SauceDemo

  Scenario: Realizar un flujo de compra completo
    Given el usuario se autentica en la aplicación
    When el usuario agrega dos productos al carrito
    And visualiza el carrito
    And completa el formulario de compra
    Then la compra se finaliza correctamente