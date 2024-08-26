package org.example.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletarFormularioCompra implements Task {

    private final String nombre;
    private final String apellido;
    private final String codigoPostal;

    public CompletarFormularioCompra(String nombre, String apellido, String codigoPostal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoPostal = codigoPostal;
    }

    public static CompletarFormularioCompra conDatos(String nombre, String apellido, String codigoPostal) {
        return instrumented(CompletarFormularioCompra.class, nombre, apellido, codigoPostal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into("//input[@id='first-name']"),
                Enter.theValue(apellido).into("//input[@id='last-name']"),
                Enter.theValue(codigoPostal).into("//input[@id='postal-code']"),
                Click.on("//input[@id='continue']")
        );
    }
}
