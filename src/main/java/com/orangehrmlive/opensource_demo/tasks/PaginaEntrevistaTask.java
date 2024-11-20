package com.orangehrmlive.opensource_demo.tasks;

import com.orangehrmlive.opensource_demo.utils.EsperaImplicita;
import com.orangehrmlive.opensource_demo.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import static com.orangehrmlive.opensource_demo.ui.PaginaReclutarUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class PaginaEntrevistaTask  implements Task {

    private static ArrayList<Map<String, String>> datosExcel= new ArrayList<>();


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            datosExcel = Excel.leerDatosDeHojaDeExcel("src/test/resources/data/Data.xlsx", "Entrevista");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        EsperaImplicita.esperaImplicita(2);
        actor.attemptsTo(
                WaitUntil.the(TXT_INTERVIEWTITLE, isVisible()).forNoMoreThan(10).seconds(), // Espera hasta que el elemento sea visible
                Enter.theValue(Keys.BACK_SPACE).into(TXT_INTERVIEWTITLE)
        );
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_INTERVIEWTITLE));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("INTERVIEWTITLE")).into(TXT_INTERVIEWTITLE));
        actor.attemptsTo(Enter.theValue(Keys.BACK_SPACE).into(TXT_INTERVIEWER));
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("INTERVIEWER")).into(TXT_INTERVIEWER));
        EsperaImplicita.esperaImplicita(2);
        actor.attemptsTo(
                SendKeys.of(Keys.ARROW_DOWN).into(TXT_INTERVIEWER), // Simula presionar la tecla hacia abajo
                SendKeys.of(Keys.ENTER).into(TXT_INTERVIEWER)        // Simula presionar la tecla Enter
        );
        actor.attemptsTo(Enter.theValue(datosExcel.get(0).get("DATE")).into(TXT_DATE));



    }

    public static Performable PaginaEntrevistaTask(){
        return instrumented(PaginaEntrevistaTask.class);
    }





}
