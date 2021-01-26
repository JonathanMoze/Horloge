package clockTest;

import static org.junit.Assert.assertEquals;

import clockController.IClockController;
import clockModel.ClockModel;

public class TestClock {
	
	static public void testIncHour(ClockModel model, IClockController controller, int ajout) {
		testIncDecHour(model, controller, ajout);	}
	
	//debit est un entier positif qui sera retiré de hour
	static public void testDecHour(ClockModel model, IClockController controller, int debit) {
		testIncDecHour(model, controller, -debit);		}
	
	// valeur est un entier positif, négatif ou nul
	static private void testIncDecHour(ClockModel model, IClockController controller, int val) {
				int   h,  heure ;
				h = model.getHour();
				heure = (h+val)%ClockModel.MAX_HOUR;
				if(heure<0) heure+=ClockModel.MAX_HOUR;
				controller.incHour(val);
				assertEquals(heure, model.getHour());		}
		
	static public void testIncMinute(ClockModel model, IClockController controller, int ajout) {
		testIncDecMinute(model, controller, ajout) ;	}

	//debit est un entier positif qui sera retire d'heure
	static  public void testDecMinute(ClockModel model, IClockController controller, int debit) {
		testIncDecMinute(model, controller, -debit) ;  }
	
	// valeur est un entier positif, négatif ou nul
	static  private void testIncDecMinute(ClockModel model, IClockController controller, int valeur) {
		int  m, h, min, heure ;
		m = model.getMinute();
		h = model.getHour();
		min = (m+valeur)%ClockModel.MAX_MINSEC;
		heure  = (h + (m+valeur)/ClockModel.MAX_MINSEC)%ClockModel.MAX_HOUR;
		if(min<0) {
			min+=ClockModel.MAX_MINSEC; heure  = (heure -1)%ClockModel.MAX_HOUR;
		}
		if(heure < 0) heure  += ClockModel.MAX_HOUR;
		controller.incMinute(valeur);
		assertEquals(min, model.getMinute());
		assertEquals(heure, model.getHour());	}

	static public void testIncSecond(ClockModel model, IClockController controller, int ajout) {
		testIncDecSecond(model, controller, ajout);  }

	// debit est un entier positif ou null qui sera retire de second
	static public void testDecSecond( ClockModel model, IClockController controller, int debit) {
		testIncDecSecond(model, controller, -debit);	}

	// valeur est un entier positif, négatif ou nul
	static private void testIncDecSecond(ClockModel model, IClockController controller, int valeur) {
		int  s, m, h, sec, min, heure, reportMin = 0, reportHeure = 0;
		s = model.getSecond();
		m = model.getMinute();
		h = model.getHour();
		sec = (s+valeur)%ClockModel.MAX_MINSEC;
		if (sec <0) {sec+=ClockModel.MAX_MINSEC; reportMin  = -1;}
		min  = (m + reportMin + 
				(s+valeur)/ClockModel.MAX_MINSEC)%ClockModel.MAX_MINSEC;
		if(min<0) {	min+=ClockModel.MAX_MINSEC; reportHeure = -1; }
		heure = (h + reportHeure +
				(m + reportMin +
						(s+valeur)/ClockModel.MAX_MINSEC
						) /ClockModel.MAX_MINSEC 
				)
				%ClockModel.MAX_HOUR;
		if(heure < 0) heure  += ClockModel.MAX_HOUR;
		controller.incSecond(valeur);
		assertEquals(sec, model.getSecond());
		assertEquals(min, model.getMinute());
		assertEquals(heure, model.getHour());	
	}

	
}
