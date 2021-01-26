package clockController;

import clockModel.ClockModel;

public class ClockControllerEmpty extends AClockController {

	public ClockControllerEmpty(ClockModel m) {
		super(m);
	}


	public void setHour(int hour) {
		//System.out.println("ControllerEmpty - setHour");
	}

	public void incHour(int hour) {
		//System.out.println("ControllerEmpty - incHour");
	}


	public void setMinute(int minute) {
		//System.out.println("ControllerEmpty - setMinute");
	}

	public void incMinute(int minute) {
		//System.out.println("ControllerEmpty - incMinute");
	}

	public void setSecond(int second) {
		//System.out.println("ControllerEmpty - setSecond");
	}


	public void incSecond(int second) {
		//System.out.println("ControllerEmpty - incSecond");
	}

}
