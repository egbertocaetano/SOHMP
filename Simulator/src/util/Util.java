package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import cores.Core;
import cores.CoreAccessMemory;
import cores.CoreCacheMiss;
import cores.CoreCalculations;
import entity.Process;

public class Util {
	
	public static ArrayList<Process> queueProcess;
	public static ArrayList<Process> queueReady;
	public static ArrayList<Process> queueFinished;
	public static ArrayList<Core> queueCore;
	public static int timeClock;
	public static int numProcess;
	public static int numProcessTotal;
	
	
	public static void init() throws IOException{
		
		queueReady = new ArrayList<>();
		queueFinished = new ArrayList<>();
		queueProcess = new ArrayList<>();
		timeClock = 0;
		numProcess = 0;
		numProcessTotal = 0;
		
		loadProcess();	
		startCore();
	}
	
	
	private static void loadProcess() {

		File file = new File("Process.txt");

		FileReader fr = null;
		try {
			fr = new FileReader(file);	
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(fr);

		String line;
		
		//loading process to queue of process
		try {
			while ((line = br.readLine()) != null) {

				String vetorLine[] = line.split(",");

				int id = Integer.parseInt(vetorLine[0]);
				int timeArriving = Integer.parseInt(vetorLine[1]);
				int timeCPU = Integer.parseInt(vetorLine[2]);
				int rateCacheMiss = Integer.parseInt(vetorLine[3]);
				int rateAccess = Integer.parseInt(vetorLine[4]);
				int rateCalculations = Integer.parseInt(vetorLine[5]);
							
				queueProcess.add(new Process(id, 
											 timeArriving,
											 timeCPU,
											 rateCacheMiss,
											 rateAccess,
											 rateCalculations));
				numProcessTotal++;
			}
		} 
		catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void finishProcess(Process process) {
		
		Util.queueFinished.add(process);
		Util.numProcess++;
	}
	
	public static void addProcessInQueueReady(Process p){
		
		queueReady.add(p);
		//queueProcess.remove(p);
	}
	
	public static Process getProcessFromQueueReady(){
		
		Process process = queueReady.get(0);
		queueReady.remove(0);
		return process;
	}
	
	private static void startCore(){
		
		Core core_0;
		CoreCacheMiss core_1;
		CoreAccessMemory core_2;
		CoreCalculations core_3;
			
		queueCore = new ArrayList<>();
		
		core_0 = new Core(0);
		queueCore.add(core_0);
		core_1 = new CoreCacheMiss(1);
		queueCore.add(core_1);
		core_2 = new CoreAccessMemory(2);
		queueCore.add(core_2);
		core_3 = new CoreCalculations(3);
		queueCore.add(core_3);
	}
	
	public static void executeCores(){
		
		for(Core core : Util.queueCore){
			if(!core.isAvailable())
				core.execute();
		}
	}
	
	public static void plusTimerClock(){
		
		timeClock++;
	}
}
