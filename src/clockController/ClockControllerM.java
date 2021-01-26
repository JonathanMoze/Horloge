package clockController;

import clockModel.ClockModel;

public class ClockControllerM extends ClockControllerDecorator {
	
	public ClockControllerM (AClockController controller)  {super(controller);}
	
	@Override
	public void setMinute(int minute){
		//System.out.println("ControllerM - setMinute");
		int m = minute%ClockModel.MAX_MINSEC;
		int h = minute/ClockModel.MAX_MINSEC;
		
		if(m< ClockModel.MIN_TIME) {
			m=m+ClockModel.MAX_MINSEC;
			h=h-1;
		}
		myController.incHour(h);
		try {
			myController.getModel().setMinute(m);
		}catch(Exception e) {
			System.err.println(e);
		}
		
	}
	
	@Override
	public void incMinute(int minute){
		//System.out.println("ControllerM - incMinute");
		int mm = myController.getModel().getMinute();
		this.setMinute(mm+minute);
	}	
}
