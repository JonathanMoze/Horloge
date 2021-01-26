package clockController;

import clockModel.ClockModel;

public class ClockControllerDecorator extends AClockController {
	protected AClockController myController;
	
	public void setHour(int hour) {
		//System.out.println("ControllerDecorator - setHour");
		myController.setHour(hour);
	}


	public void incHour(int hour) {
		//System.out.println("ControllerDecorator - incHour");
		myController.incHour(hour);
	}


	public void setMinute(int minute) {
		//System.out.println("ControllerDecorator - setMinute");
		myController.setMinute(minute);
	}


	public void incMinute(int minute) {
		//System.out.println("ControllerDecorator - incMinute");
		myController.incMinute(minute);
	}

	
	public void setSecond(int second) {
		//System.out.println("ControllerDecorator - setSecond");
		myController.setSecond(second);
	}

	
	public void incSecond(int second) {
		//System.out.println("ControllerDecorator - incSecond");
		myController.incSecond(second);
	}

	public ClockControllerDecorator(AClockController controller) {
		super(controller.getModel());
		this.myController = controller;
	}
	
	public ClockControllerDecorator(ClockModel model) {
		super(model);
		this.myController = new ClockControllerEmpty(model);
	}

}
