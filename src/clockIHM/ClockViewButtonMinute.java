package clockIHM;

import clockController.ClockController;
import clockModel.ClockModel;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ClockViewButtonMinute extends ClockView {

	public ClockViewButtonMinute(String label, ClockModel tm, ClockController tc, int posX, int posY) {
		super(label, tm, tc, posX, posY);
		myModel.addHourObserver(this);
		myModel.addMinuteObserver(this);
		myModel.addSecondObserver(this);
		afficherScene();
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		afficherScene();
	}
	
	public HBox creerLigneBouton() {
		HBox hbox = new HBox(10);
		hbox.setStyle("-fx-background-color: #84CFFF;");
		hbox.setAlignment(Pos.CENTER);
		
		Button buttonPlus = new Button("+");
		buttonPlus.setPrefSize(50, 10);
		buttonPlus.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				myController.incMinute(1);
				afficherScene();
			}
		});
		
		Button buttonMoins = new Button("-");
		buttonMoins.setPrefSize(50, 10);
		buttonMoins.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				myController.incMinute(-1);
				afficherScene();
			}
		});
		
		
		hbox.getChildren().addAll(buttonPlus, buttonMoins);
		return hbox;
	}
	
	public void afficherScene() {
		BorderPane border = creerContenu();
		Scene scene = new Scene(border);
		setScene(scene);
	}
	
	public HBox creerLigneTexte() {
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER_LEFT);
		Text text = new Text("   " + String.valueOf(myModel.getMinute()));
		
		hbox.getChildren().addAll(text);
		return hbox;
		
		
	}
	public BorderPane creerContenu() {
		BorderPane border = new BorderPane();
		border.setBottom(creerLigneBouton());
		border.setCenter(creerLigneTexte());
		return border;
	}


}
