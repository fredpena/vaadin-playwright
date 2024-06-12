package edu.pucmm;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * @author me@fredpena.dev
 * @created 27/05/2024  - 23:27
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BasicPlaywrightTest extends PlaywrightIT {

    @LocalServerPort
    private int port;

    @Test
    void series_are_displayed() {
        page.navigate("http://localhost:" + port + "/basic");

        assertThat(page).hasTitle("Basic Form");

        assertThat(page.getByText("Click me")).isVisible();

//        page.locator("id=button").click();
        page.locator("vaadin-button").getByText("Click me").click();

        assertThat(page.locator("#msg")).containsText("Clicked!");

        Locator seriesLayouts = page.locator("vaadin-vertical-layout");
        assertThat(seriesLayouts).hasCount(1);

    }
}
