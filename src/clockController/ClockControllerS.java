package clockController;

import clockModel.ClockModel;

public class ClockControllerS extends ClockControllerDecorator {

	public ClockControllerS (AClockController controller)  	{super(controller);}

	@Override
	public void setSecond(int second){
		//System.out.println("ControllerS - setSecond");
		int s = second%ClockModel.MAX_MINSEC;
		int m = second/ClockModel.MAX_MINSEC;
		if(s< ClockModel.MIN_TIME) {
			s=s+ClockModel.MAX_MINSEC;
			m=m-1;
		}
		myController.incMinute(m);
		try {
			myController.getModel().setSecond(s);
		}catch(Exception e) {
			System.err.println(e);
		}
	}
	
	@Override
	public void incSecond(int second){
		//System.out.println("ControllerS - incSecond");
		int ss = myController.getModel().getSecond();
		this.setSecond(ss+second);
	}
}
