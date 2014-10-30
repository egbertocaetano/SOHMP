package entity;

import java.io.IOException;
import java.util.ArrayList;

import util.Util;
import cores.Core;
import cores.CoreAccessMemory;
import cores.CoreCacheMiss;
import cores.CoreCalculations;

public class Simulator {
	
	private ArrayList<Core> queueCore;
	Scheduler scheduler;
	SchedulerFIFO schedulerFCFS;
	
	
	
	public Simulator() {
		
		try{
			Util.init();
		}
		catch(IOException e){
			e.printStackTrace();
		}
				
		scheduler = new Scheduler();
		

	}
	
	public void startSimulator(){
		
		
		while (Util.numProcess != Util.numProcessTotal) {


			if (Util.queueProcess.size() != 0) {

				while (Util.queueProcess.size() != 0) {

					if (Util.queueProcess.get(0).getTimeArriving() == Util.timeClock) {
						
						Util.queueReady.add(Util.queueProcess.get(0));
						scheduler.chooseCore(Util.queueProcess.get(0));
						Util.queueProcess.remove(0);			

					} 
					else {
						break;
					}
				}				
			}
			
			Util.timeClock++;
		}
		
		
		
	}
	
	

}
