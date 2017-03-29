import java.util.ListIterator;

public class CPUAccessShedulingAlgorithms {

	public static void main(String[] args) {
		ProcessList processes = ProcessList.createFromFile("New-Best.txt");
		
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
		
		/**sjf.addProcess(new Process(0, 0, 19));
		sjf.addProcess(new Process(1, 1, 12));
		sjf.addProcess(new Process(2, 2, 5));
		sjf.addProcess(new Process(3, 3, 27));
		sjf.addProcess(new Process(4, 4, 3));
		sjf.addProcess(new Process(5, 5, 10));
		sjf.addProcess(new Process(6, 6, 47));
		sjf.addProcess(new Process(7, 7, 17));
		sjf.addProcess(new Process(8, 8, 7));
		sjf.addProcess(new Process(9, 9, 32));**/
		
		System.out.println("SJF: " + sjf.countAverageWaitingTime());
		
		System.out.println("SJFw: " + sjfw.countAverageWaitingTime());
		
		
		/**rr.addProcess(new Process(0, 0, 19));
		rr.addProcess(new Process(1, 1, 12));
		rr.addProcess(new Process(2, 2, 5));
		rr.addProcess(new Process(3, 3, 27));
		rr.addProcess(new Process(4, 4, 3));
		rr.addProcess(new Process(5, 5, 10));
		rr.addProcess(new Process(6, 6, 47));
		rr.addProcess(new Process(7, 7, 17));
		rr.addProcess(new Process(8, 8, 7));
		rr.addProcess(new Process(9, 9, 32));
		**/
		
		System.out.println("RR: " + rr.countAverageWaitingTime());
	}

}
