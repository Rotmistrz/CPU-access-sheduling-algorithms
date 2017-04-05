import java.io.IOException;
import java.util.ListIterator;

public class CPUAccessShedulingAlgorithms {

	public static void main(String[] args) {
		
		try {
			ProcessList processes = ProcessList.createFromFile("data-best.txt");
			
			FCFS fcfs = new FCFS();
			SJF sjf = new SJF();
			RR rr = new RR(10);
			SJFw sjfw = new SJFw();
			
			ListIterator<Process> it = processes.listIterator();
			
			while(it.hasNext()) {
				Process process = it.next();
				fcfs.addProcess(new Process(process.comeTime, process.workTime));
				sjf.addProcess(new Process(process.comeTime, process.workTime));
				rr.addProcess(new Process(process.comeTime, process.workTime));
				sjfw.addProcess(new Process(process.comeTime, process.workTime));
			}
			
			System.out.println("FCFS: " + fcfs.countAverageWaitingTime());
			
			System.out.println("SJF: " + sjf.countAverageWaitingTime());
			
			System.out.println("SJFw: " + sjfw.countAverageWaitingTime());
			
			System.out.println("RR: " + rr.countAverageWaitingTime());
		} catch(Exception e) {
			System.out.println("There's a problem occured while processing the file.");
		}
	}

}
