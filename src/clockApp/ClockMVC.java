package clockApp;


import clockController.ClockController;
import clockIHM.*;
import clockModel.ClockModel;
import javafx.application.Application;
import javafx.stage.Stage;


public class ClockMVC extends Application {
		@Override
		public void init () { }

		public static void main(String args[]) {	launch(args);	}
			
		@SuppressWarnings("unused")
		@Override
		public void start(Stage stage) {
			ClockModel m = new ClockModel(10,0,0);
			ClockController c = new ClockController(m);
			//c.start();
			ClockView vh = 
				new ClockViewButtonHour("Moze/Debbah - Hour", m, c, 200, 100);
			ClockView vm = 
				new ClockViewButtonMinute("Moze/Debbah - Minute", m,c, 200, 200);
			ClockView vs = 
				new ClockViewButtonSecond("Moze/Debbah - Second", m,c, 200, 300);
			ClockView va =	
					new ClockViewLess("Moze/Debbah - Less",m,c, 500, 100);
			ClockView vmo =	
					new ClockViewMore("Moze/Debbah - More",m,c, 500, 300);
		
		}
}
