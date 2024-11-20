package com.orangehrmlive.opensource_demo.tasks;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerificarTextoEnTabla implements Task {

    private final String textoBuscado;

    public VerificarTextoEnTabla(String textoBuscado) {
        this.textoBuscado = textoBuscado;
    }

    // Metodo estático para instanciar la tarea
    public static VerificarTextoEnTabla conElTexto(String textoBuscado) {
        return new VerificarTextoEnTabla(textoBuscado);
    }


    private static final Target FILAS_DE_LA_TABLA = Target.the("Filas de la tabla")
            .located(By.xpath("//div[@role='row']"));

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Imprime en consola el texto que está buscando
        System.out.println("Buscando el texto: " + textoBuscado);
        // Obtiene todas las filas de la tabla
        ListOfWebElementFacades filas = FILAS_DE_LA_TABLA.resolveAllFor(actor);

        for (WebElement fila : filas) {
            // Encuentra todas las celdas dentro de cada fila
            List<WebElement> celdas = fila.findElements(By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell']"));

            for (WebElement celda : celdas) {
                String textoCelda = celda.getText();

                // Si encontramos el texto buscado, lo recordamos en el actor
                if (textoCelda.contains(textoBuscado)) {
                    actor.remember("textoEncontrado", true);
                    return;  // Si encontramos el texto, terminamos la tarea
                }
            }
        }

        // Si no encontramos el texto, lo recordamos como false
        actor.remember("textoEncontrado", false);
        System.out.println("No se encontró el texto buscado: " + textoBuscado);
    }
}