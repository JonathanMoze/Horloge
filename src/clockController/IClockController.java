package clockController;

public interface IClockController {

	void setHour(int hour);

	void incHour(int hour);

	void setMinute(int minute);

	void incMinute(int minute);

	void setSecond(int second);

	void incSecond(int second);

}