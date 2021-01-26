package clockTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import clockController.ClockController;
import clockController.IClockController;
import clockModel.ClockModel;


public class ClockTestsBasique {
	private static int HMS_VALEUR = 10;
	private static int ZERO = 0;
	private static int UN = 1;
	private IClockController controller;
	private ClockModel model;

	
	// initialisation des variables controller controller.
		//annotation "@Before" : la méthode initial() est exécutée avant les tests
		@Before
		public void initial() {
			model = new ClockModel(0,0,0);
			controller = new ClockController(model);
		}


		// test les méthodes setHour() et getHour()
		// Minuteurcontrollere.MAX_HEURE == 24
		@Test
		public void testSetHeure() {
			controller.setHour(ClockModel.MAX_HOUR -  UN);
			assertEquals(ClockModel.MAX_HOUR - UN, model.getHour());
			controller.setHour(HMS_VALEUR);
			assertEquals(HMS_VALEUR, model.getHour());
			controller.setHour(ZERO);
			assertEquals(ZERO, model.getHour());
			controller.setHour(ClockModel.MAX_HOUR *66);
			assertEquals(ZERO, model.getHour());

		}

		// test les méthodes setMinute() et getMinute()
		// Minuteurcontrollere.MAX_MINSEC== 60
		@Test
		public void testSetMinute() {
			controller.setMinute(ClockModel.MAX_MINSEC-UN);
			assertEquals(ClockModel.MAX_MINSEC - UN, model.getMinute());
			controller.setMinute(HMS_VALEUR);
			assertEquals(HMS_VALEUR, model.getMinute());
			controller.setMinute(UN);
			controller.setHour(UN);
			assertEquals(UN, model.getMinute());
		}

		// test les méthodes setSecond() et getSecond()
		@Test
		public void testSetSeconde() {
			controller.setSecond(ClockModel.MAX_MINSEC-UN);
			assertEquals(ClockModel.MAX_MINSEC  -  UN, model.getSecond());
			controller.setSecond(HMS_VALEUR);
			assertEquals(HMS_VALEUR, model.getSecond());
			controller.setSecond(ZERO);
			assertEquals(ZERO, model.getSecond());
		}

}
