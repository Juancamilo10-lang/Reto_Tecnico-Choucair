package com.orangehrmlive.opensource_demo.questions;

import com.orangehrmlive.opensource_demo.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ValidarValoresQuestions implements Question<Boolean> {

    String nombreCandidato="";
    String vacante="";
    String estado="Hired";

    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            ArrayList<Map<String, String>> datosExcel = Excel.leerDatosDeHojaDeExcel("src/test/resources/data/Data.xlsx", "FormularioCandidato");

            String nombre = datosExcel.get(0).get("FIRSTNAME");
            String segundoNombre = datosExcel.get(0).get("MIDDLENAME");
            String apellido = datosExcel.get(0).get("LASTNAME");

            nombreCandidato = nombre +" " + segundoNombre + " " + apellido;


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }




        return false;
    }

    public static Question ValidarValoresQuestions(){
        return new ValidarValoresQuestions();
    }
}
