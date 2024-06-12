package edu.pucmm.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

/**
 * @author me@fredpena.dev
 * @created 27/05/2024  - 23:23
 */
@PageTitle("Basic Form")
@Route(value = "basic")
@RouteAlias(value = "")
public class BasicView extends VerticalLayout {

    public BasicView() {
        var msg = new Paragraph("");
        // Add id to make testing easier
        msg.setId("msg");

        Button button = new Button("Click me", e -> {
            msg.setText("Clicked!");
        });

        add(button, msg);
    }
}
