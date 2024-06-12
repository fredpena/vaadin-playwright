package edu.pucmm;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author me@fredpena.dev
 * @created 28/05/2024  - 11:51
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MultiButtonViewTest extends PlaywrightIT {

    @LocalServerPort
    private int port;

    @Test
    void test_multi_button_interactions() {
        page.navigate("http://localhost:" + port + "/multi");

        assertThat(page).hasTitle("Multi Button Form");

        // Verificar visibilidad de elementos
        assertThat(page.locator("#text-field-1")).isVisible();
        assertThat(page.locator("#text-field-2")).isVisible();
        assertThat(page.locator("#button-1")).isVisible();
        assertThat(page.locator("#button-2")).isVisible();
        assertThat(page.locator("#button-3")).isVisible();

        // Interactuar con button 1 y verificar mensaje
        page.locator("#button-1").click();
        assertThat(page.locator("#msg")).containsText("Button 1 Clicked!");

        // Interactuar con button 2 y verificar mensaje
        page.locator("#button-2").click();
        assertThat(page.locator("#msg")).containsText("Button 2 Clicked!");
//

        page.fill("vaadin-text-field[id='text-field-1'] > input", "Hello");
        page.fill("vaadin-text-field[id='text-field-2'] > input", "World");
        page.locator("#button-3").click();
        assertThat(page.locator("#msg")).containsText("Button 3 Clicked! Texts: Hello, World");
    }
}
