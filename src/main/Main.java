package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    
    private final Random rand = new Random();
    private int n = 100;
    private int number;
    
    private Label order = new Label(), response = new Label();
    private TextField input = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        setOrder();
	
	    GridPane root = new GridPane();
	    root.add(order, 0, 0);
	    root.add(input, 0, 1);
	    root.add(response, 0, 2);
	    
	    primaryStage.setTitle("Guessing Game");
	    primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    
    private void setOrder() {
    	order.setText("Enter maximum number.");
	
	    input.setOnAction(e -> {
		    try {
			    n = Integer.valueOf(input.getText());
			    input.clear();
			    setRandom();
			    setEvaluationAction();
		    } catch (Exception ex) {
			    System.out.println(ex.getMessage());
		    }
	    });
    }
	
	private void setRandom() {
    	number = rand.nextInt(n + 1) + 1;
	}
	
	private void setEvaluationAction() {
    	order.setText("Enter your guess.");
    	
    	input.setOnAction(e -> {
		    int guess = Integer.valueOf(input.getText());
		    input.clear();
		
		    String r = "You guessed " + guess + ". ";
		    if(guess != number) {
			    r += (guess > number) ? "Too high." : "Too low.";
		    } else {
			    r = "Correct!";
			    setOrder();
		    }
		    response.setText(r);
	    });
	}


    /*public static void main(String[] args) {
        launch(args);
    }*/
}
