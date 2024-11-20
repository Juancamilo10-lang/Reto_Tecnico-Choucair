package com.orangehrmlive.opensource_demo.tasks;

import com.orangehrmlive.opensource_demo.utils.EsperaImplicita;
import com.orangehrmlive.opensource_demo.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import java.io.IOException;

import static com.orangehrmlive.opensource_demo.ui.PaginaReclutarUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.ArrayList;
import java.util.Map;

public class PaginaAgregarCandidatoTask implements Task {

    private static ArrayList<Map<String, String>> datosExcel= new ArrayList<>();


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("src/test/resources/data/Data.xlsx", "FormularioCandidato");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        EsperaImplicita.esperaImplicita(2);
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_FIRSTNAME));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("FIRSTNAME")).into(TXT_FIRSTNAME));
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_MIDDLENAME));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("MIDDLENAME")).into(TXT_MIDDLENAME));
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_LASTNAME));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("LASTNAME")).into(TXT_LASTNAME));
        actor.attemptsTo(
                Click.on(DROPDOWN_VACANCY), // Hacer clic para abrir el dropdown
                SendKeys.of("test").into(DROPDOWN_VACANCY), // Simular la escritura de "test" en el campo del dropdown
                Hit.the(Keys.ENTER).into(DROPDOWN_VACANCY)
        );
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_EMAIL));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("EMAIL")).into(TXT_EMAIL));
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_NUMBER));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("NUMBER")).into(TXT_NUMBER));
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_KEYWORDS));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("KEYWORDS")).into(TXT_KEYWORDS));

        //actor.attemptsTo(Click.on(BTN_INGRESAR));
        EsperaImplicita.esperaImplicita(2);

    }

    public static Performable PaginaAgregarCandidatoTask(){
        return instrumented(PaginaAgregarCandidatoTask.class);
    }




}
