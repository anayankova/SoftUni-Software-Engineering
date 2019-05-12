package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    public TextField num1;
    public TextField num2;
    public TextField result;
    public Button submit;

    public void SumNumber(ActionEvent actionEvent) {
        int a = Integer.parseInt(this.num1.getText());
        int b = Integer.parseInt(this.num2.getText());

        int result = a+b;
        this.result.setText(String.valueOf(result));
    }
}
