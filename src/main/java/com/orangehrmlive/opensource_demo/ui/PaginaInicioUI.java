package com.orangehrmlive.opensource_demo.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicioUI extends PageObject {

    public static final Target TXT_USUARIO = Target.the("enviar usuario").located(By.xpath("//input[@name='username']"));
    public static final Target TXT_CLAVE = Target.the("enviar clave ").located(By.xpath("//input[@name='password']"));
    public static final Target BTN_INGRESAR = Target.the("boton ingresar").located(By.xpath("//button[contains(@class, 'orangehrm-login-button')]"));




}
