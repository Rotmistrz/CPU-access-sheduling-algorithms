
public class Process {
	public int id;
	public int comeTime;
	public int workTime;
	public int waitingTime;
	public boolean active;
	public int lastWaitingTime;
	
	public Process() {
		this.waitingTime = 0;
		this.active = true;
		this.lastWaitingTime = 0;
	}
	
	public Process(int comeTime, int workTime) {
		this.id = 0;
		this.comeTime = comeTime;
		this.workTime = workTime;
		this.waitingTime = 0;
		this.active = true;
		this.lastWaitingTime = 0;
	}
	
	public Process increaseWaitingTime(int time) {
		this.waitingTime += time;
		
		return this;
	}
	
	public Process activate() {
		active = true;
		
		return this;
	}
	
	public Process deactivate() {
		active = false;
		
		return this;
	}
}
