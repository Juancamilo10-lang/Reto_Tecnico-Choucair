package com.orangehrmlive.opensource_demo.tasks;

import com.orangehrmlive.opensource_demo.utils.Excel;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VerificarTextoEnTabla implements Task {

    // Constante para localizar las filas de la tabla
    private static final Target FILAS_DE_LA_TABLA = Target.the("Filas de la tabla")
            .located(By.xpath("//div[@role='row']"));

    // Ruta y hoja del archivo Excel
    private static final String RUTA_EXCEL = "src/test/resources/data/Data.xlsx";
    private static final String HOJA_EXCEL = "Validacion";

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            // Leer datos del archivo Excel
            ArrayList<Map<String, String>> datosExcel = Excel.leerDatosDeHojaDeExcel(RUTA_EXCEL, HOJA_EXCEL);

            // Extraer valores esperados del Excel
            String vacanteEsperada = datosExcel.get(0).get("Vacancy");
            String candidatoEsperado = datosExcel.get(0).get("Candidate");
            String estadoEsperado = datosExcel.get(0).get("Status");

            // Obtener todas las filas de la tabla
            ListOfWebElementFacades filas = FILAS_DE_LA_TABLA.resolveAllFor(actor);

            boolean datosCoinciden = false;

            // Recorrer cada fila y verificar las celdas
            for (WebElement fila : filas) {
                List<WebElement> celdas = fila.findElements(By.xpath(".//div[@class='oxd-table-cell oxd-padding-cell']"));

                if (celdas.size() >= 3) { // Verificar que haya al menos 3 celdas (Vacante, Candidato, Estado)
                    String vacanteTabla = celdas.get(1).getText().trim();
                    String candidatoTabla = celdas.get(2).getText().trim();
                    String estadoTabla = celdas.get(5).getText().trim();

                    // Imprimir los valores encontrados en cada fila
                    System.out.println("Fila encontrada: Vacante = " + vacanteTabla +
                            ", Candidato = " + candidatoTabla +
                            ", Estado = " + estadoTabla);

                    // Comparar valores de la tabla con los del Excel
                    if (vacanteTabla.equals(vacanteEsperada)
                            && candidatoTabla.equals(candidatoEsperado)
                            && estadoTabla.equals(estadoEsperado)) {
                        datosCoinciden = true;
                        break; // Salir del bucle si encontramos coincidencia
                    }
                }
            }

            // Recordar el resultado en el actor
            actor.remember("datosCoinciden", datosCoinciden);

            // Imprimir resultado en consola
            if (datosCoinciden) {
                System.out.println("Los datos coinciden con los de la tabla.");
            } else {
                System.out.println("Los datos no coinciden con los de la tabla.");
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al leer los datos del Excel: " + e.getMessage(), e);
        }
    }

    // Método estático para instanciar la tarea
    public static VerificarTextoEnTabla compararConExcel() {
        return new VerificarTextoEnTabla();
    }
}
