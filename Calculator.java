import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField textField;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        textField = new TextField();
        GridPane.setConstraints(textField, 0, 0, 4, 1);

        Button btn0 = new Button("0");
        GridPane.setConstraints(btn0, 1, 4);

        Button btn1 = new Button("1");
        GridPane.setConstraints(btn1, 0, 3);

        Button btn2 = new Button("2");
        GridPane.setConstraints(btn2, 1, 3);

        Button btn3 = new Button("3");
        GridPane.setConstraints(btn3, 2, 3);

        Button btn4 = new Button("4");
        GridPane.setConstraints(btn4, 0, 2);

        Button btn5 = new Button("5");
        GridPane.setConstraints(btn5, 1, 2);

        Button btn6 = new Button("6");
        GridPane.setConstraints(btn6, 2, 2);

        Button btn7 = new Button("7");
        GridPane.setConstraints(btn7, 0, 1);

        Button btn8 = new Button("8");
        GridPane.setConstraints(btn8, 1, 1);

        Button btn9 = new Button("9");
        GridPane.setConstraints(btn9, 2, 1);

        Button btnAdd = new Button("+");
        GridPane.setConstraints(btnAdd, 3, 1);

        Button btnSubtract = new Button("-");
        GridPane.setConstraints(btnSubtract, 3, 2);

        Button btnMultiply = new Button("*");
        GridPane.setConstraints(btnMultiply, 3, 3);

        Button btnDivide = new Button("/");
        GridPane.setConstraints(btnDivide, 3, 4);

        Button btnEquals = new Button("=");
        GridPane.setConstraints(btnEquals, 2, 4);

        Button btnClear = new Button("C");
        GridPane.setConstraints(btnClear, 0, 4);

        grid.getChildren().addAll(textField, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear);

        btn0.setOnAction(e -> buttonPressed("0"));
        btn1.setOnAction(e -> buttonPressed("1"));
        btn2.setOnAction(e -> buttonPressed("2"));
        btn3.setOnAction(e -> buttonPressed("3"));
        btn4.setOnAction(e -> buttonPressed("4"));
        btn5.setOnAction(e -> buttonPressed("5"));
        btn6.setOnAction(e -> buttonPressed("6"));
        btn7.setOnAction(e -> buttonPressed("7"));
        btn8.setOnAction(e -> buttonPressed("8"));
        btn9.setOnAction(e -> buttonPressed("9"));
        
        btnAdd.setOnAction(e -> operatorPressed("+"));
        btnSubtract.setOnAction(e -> operatorPressed("-"));
        btnMultiply.setOnAction(e -> operatorPressed("*"));
        btnDivide.setOnAction(e -> operatorPressed("/"));
        btnEquals.setOnAction(e -> equalsPressed());
        btnClear.setOnAction(e -> clearPressed());

        Scene scene = new Scene(grid, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buttonPressed(String buttonText) {
        if (start) {
            textField.setText("");
            start = false;
        }
        textField.setText(textField.getText() + buttonText);
    }

    private void operatorPressed(String operatorText) {
        num1 = Double.parseDouble(textField.getText());
        operator = operatorText;
        start = true;
    }

    private void equalsPressed() {
        double num2 = Double.parseDouble(textField.getText());
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        textField.setText(Double.toString(result));
        start = true;
    }

    private void clearPressed() {
        textField.setText("");
        start = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

