
public class Process {
	public int id;
	public int comeTime; /* [ms] */
	public int workTime; /* [ms] */
	
	public Process() {
		
	}
	
	public Process(int id, int comeTime, int workTime) {
		this.id = id;
		this.comeTime = comeTime;
		this.workTime = workTime;
	}
}
