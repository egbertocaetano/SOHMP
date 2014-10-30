package entity;

import java.util.ArrayList;

import util.Util;
import cores.Core;
import cores.CoreAccessMemory;
import cores.CoreCacheMiss;
import cores.CoreCalculations;


public class Scheduler {
			
	
	public Scheduler() {
		
	}
	

	public boolean chooseCore(Process process) {

		int choose = process.findMax();
		
		
		if(Util.queueCore.get(choose).isAvailable()){
			
			process.setTimeResponse(Util.timeClock);
			process.setId_Core(Util.queueCore.get(choose).getId());
			process.setNome_core(Util.queueCore.get(choose).getClass().getSimpleName());				
			process.setReady(false);
			process.setExecution(true);
			if(Util.queueCore.get(choose).putProcess(process)){
				//Util.queueReady.remove(process);
				return true;
			}
			
		}
		else{
			for (Core core : Util.queueCore) {
				if (core.isAvailable()){
					
					process.setTimeResponse(Util.timeClock);
					process.setId_Core(core.getId());
					process.setNome_core(core.getClass().getSimpleName());				
					process.setReady(false);
					process.setExecution(true);
					if(core.putProcess(process)){
						//Util.queueReady.remove(process);
						return true;
					}
				}
			}
		}
		return false;
	}
		
}

