package org.example.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductoAlCarrito implements Task {

    private final String producto1;
    private final String producto2;

    public AgregarProductoAlCarrito(String producto1, String producto2) {
        this.producto1 = producto1;
        this.producto2 = producto2;
    }

    public static AgregarProductoAlCarrito losProductos(String producto1, String producto2) {
        return instrumented(AgregarProductoAlCarrito.class, producto1, producto2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on("//div[text()='" + producto1 + "']/following-sibling::button"),
                Click.on("//div[text()='" + producto2 + "']/following-sibling::button")
        );
    }


}
