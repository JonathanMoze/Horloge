package clockController;

import clockModel.ClockModel;

public class ClockController extends ClockControllerDecorator {
	
	public ClockController (ClockModel model)  {  
		super(model);
		AClockController c1 = new ClockControllerEmpty(model);
		AClockController c2 = new ClockControllerH(c1);
		AClockController c3 = new ClockControllerM(c2);
		myController = new ClockControllerS(c3);
	}


}
