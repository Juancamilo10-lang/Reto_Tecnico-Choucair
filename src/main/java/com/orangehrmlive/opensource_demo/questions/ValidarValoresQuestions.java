package com.orangehrmlive.opensource_demo.questions;

import com.orangehrmlive.opensource_demo.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ValidarValoresQuestions implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Leer datos del Excel
            ArrayList<Map<String, String>> datosExcel = Excel.leerDatosDeHojaDeExcel("src/test/resources/data/Data.xlsx", "Validacion");

            // Obtener valores
            String vacante = datosExcel.get(0).get("Vacancy");
            String candidato = datosExcel.get(0).get("Candidate");
            String estado = datosExcel.get(0).get("Status");

            // Validar los valores leídos
            return vacante.equals("payroll")
                    && candidato.equals("Juan Camilo Anacona")
                    && estado.equals("Hired");

        } catch (IOException ex) {
            throw new RuntimeException("Error al leer los datos del Excel: " + ex.getMessage(), ex);
        }
    }

    public static Question<Boolean> validarValoresQuestions() {
        return new ValidarValoresQuestions();
    }
}
