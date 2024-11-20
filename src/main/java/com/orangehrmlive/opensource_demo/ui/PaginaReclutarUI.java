package com.orangehrmlive.opensource_demo.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaReclutarUI extends PageObject {


        public static final Target BTN_RECRUITMENT = Target.the("Boton recluitment").located(By.xpath("//span[contains(@class, 'oxd-text oxd-text--span oxd-main-menu-item--name') and text()='Recruitment']"));
        public static final Target BTN_ADD = Target.the("Boton Add de recluitment").located(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary' and contains(., 'Add')]"));
        public static final Target TXT_FIRSTNAME = Target.the("Texto primer nombre").located(By.xpath("//input[@name='firstName' and contains(@class, 'oxd-input')]"));
        public static final Target TXT_MIDDLENAME = Target.the("Texto segundo nombre").located(By.xpath("//input[@name='middleName' and contains(@class, 'oxd-input')]"));
        public static final Target TXT_LASTNAME = Target.the("Texto Apellido").located(By.xpath("//input[@name='lastName' and contains(@class, 'oxd-input')]"));
        public static final Target DROPDOWN_VACANCY = Target.the("Lista con vacante").located(By.xpath("//div[@class='oxd-select-text-input']"));
        public static final Target TXT_EMAIL = Target.the("Texto de correo").located(By.xpath("(//input[@placeholder='Type here' and contains(@class, 'oxd-input')])[1]"));
        public static final Target TXT_NUMBER = Target.the("Texyto numero telefono").located(By.xpath("(//input[@placeholder='Type here' and contains(@class, 'oxd-input')])[2]"));
        public static final Target TXT_KEYWORDS = Target.the("Texto con palabras Claves").located(By.xpath("//input[@placeholder='Enter comma seperated words...' and contains(@class, 'oxd-input')]"));
        public static final Target BTN_SAVECANDIDATE = Target.the("Boton guardar candidato").located(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--secondary')]"));
        public static final Target BTN_SHORTLIST = Target.the("Boton Lista corta").located(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--success')]"));
        public static final Target BTN_SCHEDULEINTERVIEW = Target.the("Boton horario de entrevista").located(By.xpath("//button[contains(@class, 'oxd-button') and contains(@class, 'oxd-button--success')]"));
        public static final Target TXT_INTERVIEWTITLE = Target.the("Texto titulo de la entrevista").located(By.xpath("(//div[@class='']//input)[5]"));
        public static final Target TXT_INTERVIEWER = Target.the("Texto entrevistador").located(By.xpath("//input[@placeholder='Type for hints...' and @include-employees='onlyCurrent']"));
        public static final Target TXT_INTERVIEWERPRUEBA = Target.the("Texto entrevistador").located(By.xpath("(//div[contains(@class, 'oxd-autocomplete-text-input--active')]//div)[1]"));
        public static final Target TXT_DATE = Target.the("Texto Fecha").located(By.xpath("//input[@placeholder='yyyy-dd-mm' and contains(@class, 'oxd-input')]"));
        public static final Target BTN_MARKINTERVIEWPASSED = Target.the("Boton entrevista aprobada").located(By.xpath("(//button[contains(@class, 'oxd-button--success') and contains(@class, 'oxd-button--medium')])[1]"));
        public static final Target BTN_OFFERJOB = Target.the("Boton entrevista aprobada").located(By.xpath("(//button[contains(@class, 'oxd-button--success') and contains(@class, 'oxd-button--medium')])[2]"));
        public static final Target BTN_HIRE = Target.the("Boton entrevista aprobada").located(By.xpath("//button[@type='button' and contains(@class, 'oxd-button--medium') and contains(@class, 'oxd-button--success')]"));public static final Target BTN_Candidatos = Target.the("Boton Candidatos").located(By.xpath("//li[@class='oxd-topbar-body-nav-tab --visited']"));











}
