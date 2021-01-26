package clockController;

import clockModel.ClockModel;

public abstract class AClockController implements IClockController {
	protected ClockModel myModel;

	public AClockController(ClockModel m) {
		this.myModel = m;	}
	
	public ClockModel getModel() {
		//System.out.println("AbstractController - getModel");
		return myModel; }

}
