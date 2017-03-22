import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class RR implements ProcessQueue {
	private ArrayList<Process> processes;
	private int timeQuantum = 10;
	
	public RR() {
		processes = new ArrayList<Process>();
	}
	
	public RR addProcess(Process p) {
		processes.add(p);
		
		return this;
	}
	
	public double countAverageWaitingTime() {
		ListIterator<Process> it;
		ArrayList<Process> tmp = (ArrayList<Process>) processes.clone();
		
		int waitingTime = 0;
		int totalTime = 0;
		int n = tmp.size();
		int timeToAdd = 0;
		
		while(tmp.size() > 1) {
			it = tmp.listIterator();
			
			while(it.hasNext()) {	
				Process process = it.next();
				
				System.out.println(process.id + " " + process.workTime + "(" + totalTime + ")");
				
				if(process.workTime > timeQuantum) {
					timeToAdd = timeQuantum;
					
					process.workTime -= timeQuantum;
				} else {
					timeToAdd = process.workTime;
					it.remove();
				}
				
				totalTime += timeToAdd;
				
				if(tmp.size() == 1) {
					break;
				}
			}
		}
		
		double d = (double) totalTime/n;
		
		return d;
	}
}