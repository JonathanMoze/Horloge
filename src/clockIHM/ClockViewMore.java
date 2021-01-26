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

public class ClockViewMore extends ClockView{

	public ClockViewMore(String label, ClockModel tm, ClockController tc, int posX, int posY) {
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
		
		Button buttonSec = new Button("+1000s");
		buttonSec.setPrefSize(100, 10);
		buttonSec.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				myController.incSecond(1000);
				afficherScene();
			}
		});
		
		Button buttonMin = new Button("+100m");
		buttonMin.setPrefSize(75, 10);
		buttonMin.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				myController.incMinute(100);
				afficherScene();
			}
		});
		
		Button buttonHour = new Button("+10h");
		buttonHour.setPrefSize(50, 10);
		buttonHour.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				myController.incHour(10);
				afficherScene();
			}
		});
		
		
		hbox.getChildren().addAll(buttonSec, buttonMin, buttonHour);
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
		Text text = new Text("   "+myModel.getHour()+"h:"+myModel.getMinute()+"m:"+myModel.getSecond()+"s");
		
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
