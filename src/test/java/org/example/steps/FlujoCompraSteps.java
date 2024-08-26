package org.example.steps;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.example.model.Usuario;
import org.example.task.Login;
import org.example.task.AgregarProductoAlCarrito;
import org.example.task.VerCarrito;
import org.example.task.FinalizarCompra;
import org.example.task.CompletarFormularioCompra;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class FlujoCompraSteps {

    @Managed
    WebDriver driver;


    Usuario user = new Usuario();

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("el usuario agrega dos productos al carrito")
    public void elUsuarioSeAutenticaEnLaAplicacion() {
        Actor actor = theActorCalled("Usuario");
        actor.can(BrowseTheWeb.with(driver));
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                Login.conCredenciales("standard_user", "secret_sauce")
        );
    }

    @When("el usuario agrega dos productos al carrito")
    public void elUsuarioAgregaDosProductosAlCarrito() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                AgregarProductoAlCarrito.losProductos("Sauce Labs Backpack", "Sauce Labs Bike Light")

        );
    }

    @When("visualiza el carrito")
    public void visualizaElCarrito() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                VerCarrito.visualizar()
        );
    }

    @When("completa el formulario de compra")
    public void completaElFormularioDeCompra() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                CompletarFormularioCompra.conDatos("John", "Doe", "12345")
        );
    }

    @Then("la compra se finaliza correctamente")
    public void laCompraSeFinalizaCorrectamente() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                FinalizarCompra.confirmar()
        );
    }

}
