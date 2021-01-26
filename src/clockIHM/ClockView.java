package clockIHM;



import clockController.ClockController;
import clockModel.ClockModel;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;

public abstract class ClockView extends Stage implements ChangeListener<Number> {

	protected ClockModel myModel;
	protected ClockController myController;
	

	public ClockView(String label, ClockModel tm, ClockController tc, int posX, int posY){
		this(label, posX, posY);	
		myModel = tm; myController = tc;
	}

	public ClockView(String label, int posX, int posY){
		super();
		myModel = null; myController = null;
		setWidth(300);
		setHeight(100);
		setTitle(label);
		setX(posX);
		setY(posY);
		setOnCloseRequest(e-> Platform.exit());
		show();
	}


}
