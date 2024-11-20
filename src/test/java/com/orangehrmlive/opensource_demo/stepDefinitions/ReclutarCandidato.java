package com.orangehrmlive.opensource_demo.stepDefinitions;

import com.orangehrmlive.opensource_demo.interactions.*;
import com.orangehrmlive.opensource_demo.tasks.PaginaAgregarCandidatoTask;
import com.orangehrmlive.opensource_demo.tasks.PaginaEntrevistaTask;
import com.orangehrmlive.opensource_demo.tasks.PaginaInicioTask;
import com.orangehrmlive.opensource_demo.tasks.VerificarTextoEnTabla;
import com.orangehrmlive.opensource_demo.utils.EsperaImplicita;
import com.orangehrmlive.opensource_demo.utils.Excel;
import io.cucumber.java.Before;
import io.cucumber.java.ast.Cuando;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ReclutarCandidato {

    @Before
    public void setUser(){
        OnStage.setTheStage(new OnlineCast());
    }



    @Cuando("que el usuario abra el navegador en la url")
    public void que_el_usuario_abra_el_navegador_en_la_url() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://opensource-demo.orangehrmlive.com/")
        );
    }

    @Cuando("inicie sesion")
    public void inicie_sesion() {
        theActorCalled("usuario").attemptsTo(PaginaInicioTask.PaginaInicioTask());
    }

    @Cuando("navega a la pestaña de Reclutamiento")
    public void navega_a_la_pestaña_de_reclutamiento() {
        theActorCalled("usuario").attemptsTo(ClicReclutamiento.ClicPaginaReclutamiento());
    }

    @Cuando("hace clic en el botón Add")
    public void hace_clic_en_el_botón_add() {
        theActorCalled("usuario").attemptsTo(ClicAgregar.Clicagregar());
    }

    @Cuando("registra los datos del candidato")
    public void registra_los_datos_del_candidato() {

        theActorCalled("usuario").attemptsTo(PaginaAgregarCandidatoTask.PaginaAgregarCandidatoTask());


    }

    @Entonces("guarda los datos del candidato")
    public void guarda_los_datos_del_candidato() {
        theActorCalled("usuario").attemptsTo(ClicBotonSave.ClicBotonSave());
        theActorCalled("usuario").attemptsTo(ClicBotonShortList.ClicBotonClicBotonShortList());
        theActorCalled("usuario").attemptsTo(ClicBotonSave.ClicBotonSave());
        theActorCalled("usuario").attemptsTo(ClicBotonScheduleInterview.ClicBotonScheduleInterview());


    }

    @Entonces("completa el registro de programar entrevista")
    public void completa_el_registro_de_programar_entrevista() {

        theActorCalled("usuario").attemptsTo(PaginaEntrevistaTask.PaginaEntrevistaTask());
        theActorCalled("usuario").attemptsTo(ClicBotonSave.ClicBotonSave());

    }

    @Entonces("Marca la entrevista como aprobada")
    public void marca_la_entrevista_como_aprobada() {
        theActorCalled("usuario").attemptsTo(ClicBotonMarkinterViewPassed.ClicBotonMarkinterViewPassed());
        theActorCalled("usuario").attemptsTo(ClicBotonSave.ClicBotonSave());

    }

    @Entonces("realiza una oferta de trabajo")
    public void realiza_una_oferta_de_trabajo() {
        theActorCalled("usuario").attemptsTo(ClicBotonOfferJob.ClicBotonOfferJob());
        theActorCalled("usuario").attemptsTo(ClicBotonSave.ClicBotonSave());
    }

    @Entonces("realiza la contratación")
    public void realiza_la_contratación() {
        theActorCalled("usuario").attemptsTo(ClicBotonHire.ClicBotonHire());
        theActorCalled("usuario").attemptsTo(ClicBotonSave.ClicBotonSave());

    }

    @Entonces("verifica que el candidato está en la lisa con estado del candidato es Contratado")
    public void verifica_que_el_candidato_está_en_la_lista() {
        theActorCalled("usuario").attemptsTo(ClicReclutamiento.ClicPaginaReclutamiento());

        theActorCalled("usuario").attemptsTo(
                VerificarTextoEnTabla.conElTexto("payroll"),
                VerificarTextoEnTabla.conElTexto("Juan Camilo Anacona"),
                VerificarTextoEnTabla.conElTexto("Hired")
        );

        EsperaImplicita.esperaImplicita(10);
    }






}
