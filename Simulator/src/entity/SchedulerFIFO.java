package entity;

import java.util.ArrayList;

import util.Util;
import cores.Core;
import cores.CoreAccessMemory;
import cores.CoreCacheMiss;
import cores.CoreCalculations;

public class SchedulerFIFO {

	private ArrayList<Core> queueCore;

	
	public SchedulerFIFO(ArrayList<Core> qCore) {
		this.queueCore = qCore;
	}

	//
	public void chooseCore(Process process) {

		for (Core core : queueCore) {
			if (core.isAvailable()
					&& process.getTimeArriving() == Util.timeClock
					&& !process.isExecution()) {
				core.putProcess(process);
				break;
			}
		}

	}

}
