package entity;

import java.util.ArrayList;

import cores.Core;
import cores.CoreAccessMemory;
import cores.CoreCacheMiss;
import cores.CoreCalculations;

public class SchedulerFCFS {
	
	
	private ArrayList<Core> qCore;
	private ArrayList<CoreCacheMiss> qCoreCacheMiss;
	private ArrayList<CoreAccessMemory> qCoreAccessMemory;
	private ArrayList<CoreCalculations> qCoreCalculations;
	
	private Core core_0;
	private CoreCacheMiss core_1;
	private CoreAccessMemory core_2;
	private CoreCalculations core_3;
	
	
	public void startScheduling() {

	}

}
