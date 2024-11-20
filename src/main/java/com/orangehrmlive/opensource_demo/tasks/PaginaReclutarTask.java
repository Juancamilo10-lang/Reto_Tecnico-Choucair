package com.orangehrmlive.opensource_demo.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;




import java.util.List;

public class PaginaReclutarTask implements Task {

    private List<String> names;
    private List<String> lastNames;
    private String status;

    // Constructor que recibe los valores a comparar
    public PaginaReclutarTask(List<String> names, List<String> lastNames, String status) {
        this.names = names;
        this.lastNames = lastNames;
        this.status = status;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Bucle para buscar la fila correspondiente y validarla
        // Validar si la fila en la tabla coincide con los valores esperados
        for (int rowIndex = 0; rowIndex < names.size(); rowIndex++) {
            actor.attemptsTo(
                   // Ensure.that(ValidarValoresQuestions.withValues(names.get(rowIndex), lastNames.get(rowIndex), status)).isTrue()
            );
        }

    }

    public static PaginaReclutarTask withValues(List<String> names, List<String> lastNames, String status) {
        return new PaginaReclutarTask(names, lastNames, status);
    }
}