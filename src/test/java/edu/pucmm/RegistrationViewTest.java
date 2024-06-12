package edu.pucmm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author me@fredpena.dev
 * @created 28/05/2024  - 13:12
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RegistrationViewTest extends PlaywrightIT {

    @LocalServerPort
    private int port;

    @Test
    void testRegistrationFormAcceptTerms() {
        page.navigate("http://localhost:" + port + "/registration");

        // Verificar visibilidad de elementos
        assertThat(page.locator("h1")).isVisible();
        assertThat(page.locator("#username")).isVisible();
        assertThat(page.locator("#email")).isVisible();
        assertThat(page.locator("#accept-terms")).isVisible();
        assertThat(page.locator("#submit")).isVisible();


        page.fill("vaadin-text-field[id='username'] > input", "fred");
        page.fill("vaadin-email-field[id='email'] > input", "me@fredpena.dev");
        page.locator("#accept-terms").click();

        // Enviar el formulario
        page.locator("#submit").click();
        assertThat(page.locator("#msg")).containsText("Registration successful! Username: fred, Email: me@fredpena.dev");
    }

    @Test
    void testRegistrationFormNoAcceptTerms() {
        page.navigate("http://localhost:" + port + "/registration");

        // Verificar visibilidad de elementos
        assertThat(page.locator("h1")).isVisible();
        assertThat(page.locator("#username")).isVisible();
        assertThat(page.locator("#email")).isVisible();
        assertThat(page.locator("#accept-terms")).isVisible();
        assertThat(page.locator("#submit")).isVisible();


        page.fill("vaadin-text-field[id='username'] > input", "fred");
        page.fill("vaadin-email-field[id='email'] > input", "me@fredpena.dev");
//        page.locator("#accept-terms").click();

        // Enviar el formulario
        page.locator("#submit").click();
        assertThat(page.locator("#msg")).containsText("Please fill out all fields and accept the terms and conditions.");
    }
}