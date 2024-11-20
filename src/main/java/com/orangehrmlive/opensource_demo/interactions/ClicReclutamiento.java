package com.orangehrmlive.opensource_demo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import com.orangehrmlive.opensource_demo.ui.PaginaReclutarUI;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClicReclutamiento implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaReclutarUI.BTN_RECRUITMENT) // Usa el Target definido en tu clase UI.
        );
    }

    public static Performable ClicPaginaReclutamiento(){
        return  instrumented(ClicReclutamiento.class);
    }



}
