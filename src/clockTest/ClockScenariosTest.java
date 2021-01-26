package clockTest;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;

import clockController.ClockController;
import clockController.IClockController;
import clockModel.ClockModel;

public class ClockScenariosTest {
	private static int HMS_VALEUR = 10;
	private static int ZERO = 0;
	private static int UN = 1;
	private static int MAX_TESTS = 1000;
	private Random rd;
	private IClockController controller;
	private ClockModel model;


	// initialisation de l'attribut metier.
	//annotation "@Before" : la méthode initial() est exécutée avant les tests
	@Before
		public void initial() {
		model = new ClockModel(0,0,0);
		controller = new ClockController(model);
		rd = new Random();
	}
		
	// test la méthode addHour(x) avec x positif
	@Test
	public void scenariosIncHour() {
		/* 23h plus une heure = 0h */
		controller.setHour(ClockModel.MAX_HOUR  -  UN);
		TestClock.testIncHour(model, controller, UN);
		/* 0h plus une heure = 1h */
		TestClock.testIncHour( model, controller, UN);
		/* 1h plus 24h heures = 1h */
		TestClock.testIncHour(model, controller, ClockModel.MAX_HOUR);
		//tests aleatoires
		for (int i = 0 ; i < MAX_TESTS; i++) {
			TestClock.testIncHour(model, controller, rd.nextInt(MAX_TESTS));
		}
	}

	// test la méthode addHour(x) avec x  negatif
	@Test
	public void scenariosDecHour() {
		/* 0h moins une heure = 23h */
		controller.setHour(ZERO);
		TestClock.testDecHour(model, controller, UN);
		/* 23h moins une heure = 22h */
		TestClock.testDecHour( model, controller, UN);
		/* 22h moins 24h heure = 22h */
		TestClock.testDecHour( model, controller, ClockModel.MAX_HOUR);
		//tests aleatoires
		for (int i = 0 ; i < MAX_TESTS; i++) {
			TestClock.testDecHour( model, controller, rd.nextInt(MAX_TESTS));
		}
	}
	
	// test la méthode addMinute(x) avec x positif
	@Test
	public void scenariosIncMinute() {
		// 10h:59m plus une minute = 11h:0m 
		controller.setHour(HMS_VALEUR);
		controller.setMinute(ClockModel.MAX_MINSEC - UN);
		TestClock.testIncMinute( model, controller, UN);
		// 11h:0m plus une minute = 11h:1m 
		TestClock.testIncMinute( model, controller, UN);
		// 11h:1m plus 24*60 minutes  = 11h:1m 
		TestClock.testIncMinute( model, controller, ClockModel.MAX_MINSEC*ClockModel.MAX_HOUR);
		//tests aleatoires
		for (int i = 0 ; i < MAX_TESTS; i++) {
			TestClock.testIncMinute( model, controller, rd.nextInt(MAX_TESTS));
		}
	}

	// test la méthode addMinute(x) avec x negatif
	@Test
	public void scenariosDecMinute() {
		// 10h:0m moins une minute = 9h:59m 
		controller.setHour(HMS_VALEUR); controller.setMinute(ZERO);
		TestClock.testDecMinute( model, controller, UN);
		// 9h:59m moins une minute = 9h:58m 
		TestClock.testDecMinute( model, controller, UN);
		controller.setHour(ZERO);
		controller.setMinute(ZERO);
		// 0h:0m moins une minute = 23h:59m 
		TestClock.testDecMinute( model, controller, UN);
		// 23h:59m  moins 24*60 minutes  = 23h:59m
		TestClock.testDecMinute( model, controller,ClockModel.MAX_MINSEC*ClockModel.MAX_HOUR);
		//tests aleatoires
		for (int i = 0 ; i < MAX_TESTS; i++) {
			TestClock.testDecMinute( model, controller, rd.nextInt(MAX_TESTS));
		}
	}

	// test la méthode addSecond(x) avec x positif
	@Test
	public void scenariosIncSecond() {
		// 10m:59s plus une seconde = 11m:0s 
		controller.setMinute(HMS_VALEUR);
		controller.setSecond(ClockModel.MAX_MINSEC - UN);
		TestClock.testIncSecond( model, controller, UN);
		// 11m:0s plus une seconde = 11m:1s 
		TestClock.testIncSecond( model, controller, UN);
		// 10h:59m:59s plus une seconde = 11h:0m:0s 
		controller.setHour(HMS_VALEUR);
		controller.setMinute(ClockModel.MAX_MINSEC - UN);
		controller.setSecond(ClockModel.MAX_MINSEC - UN);
		TestClock.testIncSecond( model, controller, UN);
		// 23h:59m:59s plus une seconde = 0h:0m:0s 
		controller.setHour(ClockModel.MAX_HOUR - UN);
		controller.setMinute(ClockModel.MAX_MINSEC - UN);
		controller.setSecond(ClockModel.MAX_MINSEC - UN);
		TestClock.testIncSecond( model, controller, UN);
		// 0h:0m:0s plus 24*3600 secondes  = 0h:0m:0s 
		TestClock.testIncSecond( model, controller, 
				ClockModel.MAX_MINSEC*ClockModel.MAX_MINSEC*ClockModel.MAX_HOUR);
		//tests aleatoire
		for (int i = 0 ; i < MAX_TESTS; i++) {
			TestClock.testIncSecond( model, controller, rd.nextInt(MAX_TESTS));
		}
	}

	// test la méthode addSecond(x) avec x negatif
	@Test
	public void scenariosDecSecond() {
		// 10m:0s moins une seconde = 9m:59s 
		controller.setMinute(HMS_VALEUR); controller.setSecond(ZERO);
		TestClock.testDecSecond( model, controller, UN);
		// 9m:59s moins une seconde = 9m:58s 
		TestClock.testDecSecond( model, controller, UN);
		// 10h:0m:0s moins une seconde = 9h:59m:59s 
		controller.setHour(HMS_VALEUR); controller.setMinute(ZERO); controller.setSecond(ZERO);
		TestClock.testDecSecond( model, controller, UN);
		// 0h:0m:0s moins une seconde = 23h:59m:59s 
		controller.setHour(ZERO); controller.setMinute(ZERO); controller.setSecond(ZERO);
		TestClock.testDecSecond( model, controller, UN);
		// 23h:59m:59s  moins 24*3600 secondes = 23h:59m:59s  
		TestClock.testDecSecond( model, controller, 
				ClockModel.MAX_MINSEC*ClockModel.MAX_MINSEC*ClockModel.MAX_HOUR);
		// 23h:59m:59s  moins 23*3600 secondes = 0h:59m:59s  
		TestClock.testDecSecond( model, controller,
				ClockModel.MAX_MINSEC*ClockModel.MAX_MINSEC*(ClockModel.MAX_HOUR-UN));
		// 0h:59m:59s  moins 3600 secondes = 23h59m:59s  
		TestClock.testDecSecond( model, controller, 
				ClockModel.MAX_MINSEC*ClockModel.MAX_MINSEC);
		//tests aleatoires
		for (int i = 0 ; i < MAX_TESTS; i++) {
			TestClock.testDecSecond( model, controller, rd.nextInt(MAX_TESTS));
		}
	}


}

