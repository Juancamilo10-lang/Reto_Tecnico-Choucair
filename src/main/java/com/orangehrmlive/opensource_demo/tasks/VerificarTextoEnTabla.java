package com.orangehrmlive.opensource_demo.tasks;


import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class VerificarTextoEnTabla implements Task {

    private final String vacancy;
    private final String candidate;
    private final String hiringManager;
    private final String status;

    public VerificarTextoEnTabla(String vacancy, String candidate, String hiringManager, String status) {
        this.vacancy = vacancy;
        this.candidate = candidate;
        this.hiringManager = hiringManager;
        this.status = status;
    }

    public static VerificarTextoEnTabla conLosDatos(String vacancy, String candidate, String hiringManager, String status) {
        return new VerificarTextoEnTabla(vacancy, candidate, hiringManager, status);
    }

    private static final Target FILAS_DE_LA_TABLA = Target.the("Filas de la tabla")
            .located(By.xpath("//div[@role='row']"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Validacion: Vacancy = " + vacancy + ", Candidate = " + candidate +
                ", Hiring Manager = " + hiringManager + ", Status = " + status);

        // Obtener todas las filas visibles
        ListOfWebElementFacades filas = FILAS_DE_LA_TABLA.resolveAllFor(actor);

        for (WebElement fila : filas) {
            // Obtener las celdas de las columnas relevantes
            WebElement vacancyCelda = fila.findElement(By.xpath(".//div[@role='cell'][2]"));
            WebElement candidateCelda = fila.findElement(By.xpath(".//div[@role='cell'][3]"));
            WebElement hiringManagerCelda = fila.findElement(By.xpath(".//div[@role='cell'][4]"));
            WebElement statusCelda = fila.findElement(By.xpath(".//div[@role='cell'][6]"));

            // Validar los valores
            if (vacancy.equals(vacancyCelda.getText().trim()) &&
                    candidate.equals(candidateCelda.getText().trim()) &&
                    hiringManager.equals(hiringManagerCelda.getText().trim()) &&
                    status.equals(statusCelda.getText().trim())) {
                System.out.println("¡Se encontraron los datos correctos en la tabla!");
                actor.remember("datosValidados", true);
                return;
            }
        }
    }
}