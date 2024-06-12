package edu.pucmm.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * @author me@fredpena.dev
 * @created 28/05/2024  - 11:50
 */
@PageTitle("Multi Button Form")
@Route(value = "multi")
public class MultiButtonView extends VerticalLayout {

    public MultiButtonView() {
        TextField textField1 = new TextField("Text Field 1");
        textField1.setId("text-field-1");

        TextField textField2 = new TextField("Text Field 2");
        textField2.setId("text-field-2");

        Paragraph msg = new Paragraph("");
        msg.setId("msg");

        Button button1 = new Button("Button 1", e -> {
            msg.setText("Button 1 Clicked!");
        });
        button1.setId("button-1");

        Button button2 = new Button("Button 2", e -> {
            msg.setText("Button 2 Clicked!");
        });
        button2.setId("button-2");

        Button button3 = new Button("Button 3", e -> {
            String text1 = textField1.getValue();
            String text2 = textField2.getValue();
            msg.setText("Button 3 Clicked! Texts: " + text1 + ", " + text2);
        });
        button3.setId("button-3");

        add(textField1, textField2, button1, button2, button3, msg);
    }
}