package edu.pucmm.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * @author me@fredpena.dev
 * @created 28/05/2024  - 13:11
 */
@PageTitle("Registration")
@Route(value = "registration")
public class RegistrationView extends VerticalLayout {

    public RegistrationView() {
        H1 title = new H1("Registration Form");
        TextField usernameField = new TextField("Username");
        usernameField.setId("username");
        EmailField emailField = new EmailField("Email Address");
        emailField.setId("email");
        Checkbox termsCheckbox = new Checkbox("I accept the terms and conditions");
        termsCheckbox.setId("accept-terms");

        Button submitButton = new Button("Submit");
        submitButton.setId("submit");

        Paragraph resultMessage = new Paragraph();
        resultMessage.setId("msg");

        submitButton.addClickListener(e -> {
            if (usernameField.getValue().isEmpty() || emailField.getValue().isEmpty() || !termsCheckbox.getValue()) {
                resultMessage.setText("Please fill out all fields and accept the terms and conditions.");
            } else {
                resultMessage.setText("Registration successful! Username: " + usernameField.getValue() + ", Email: " + emailField.getValue());
            }
        });

        add(title, usernameField, emailField, termsCheckbox, submitButton, resultMessage);
    }
}