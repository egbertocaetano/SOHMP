package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Process {
	
	//Process's states
	private int id;
	private boolean fresh; 
	private boolean ready; 
	private boolean execution;
	private boolean wait; 
	private boolean finished;

	// Process's statistics
	private int idCore;
	private String nome_core;
	private int timeArriving;
	private int timeCPU;
	private double timeWaiting;
	private double timeResponse;
	private double timeExecution;
	private double timeDelay;
	private double turnAround;
	
	//Process's Feature
	private int rateCacheMiss;
	private int rateAccessMemory;
	private int rateCalculations;
	
	//Statistc
	private TreeMap<Integer, Integer> statistic;
	
	
	public Process(int _id, int _timeArriving, int _timeCPU, int _rateCacheMiss,
			int _rateAccessMemory, int _rateCalculations) {
		
		this.id = _id;
		this.timeArriving = _timeArriving;
		this.timeCPU = _timeCPU;
		this.rateCacheMiss = _rateCacheMiss;
		this.rateAccessMemory = _rateAccessMemory;
		this.rateCalculations = _rateCalculations;
		this.fresh = true;
		this.ready = true;
		
		this.statistic = new TreeMap<Integer, Integer>();
			
		this.statistic.put(rateCacheMiss,1);
		this.statistic.put(rateAccessMemory,2);
		this.statistic.put(rateCalculations,3);
	}
	
	public void calcTime(){
		
		this.setTurnAround();
		this.setTimeWaiting();
		this.setTimeDelay();
	}
	
	@Override
	public String toString() {
		
		String string = "--------------------------------" + "\n" +
				"ID do Processo           : " + this.id + "\n" +
				"ID Core                  : " + this.idCore + "\n" +
				"Nome do Core             : " + this.nome_core + "\n" +
				"Tempo de Chegada         : " + this.timeArriving + "\n" +
				"Tempo de Resposta        : " + this.timeResponse + "\n" +
				"Tempo de Espera          : " + this.timeWaiting + "\n" +
				"Tempo de Execucao        : " + this.timeExecution + "\n" +
				"Turnaround               : " + this.turnAround + "\n" +
				"Tempo de Atraso          : " + this.timeDelay;
		
		return string;
		
	}
		
	
	//Getters and Setters
	
	public void plusExecute(){
		this.timeExecution++
		;
	}
	
	public int getTimeCPU() {
		return timeCPU;
	}
	public boolean isExecution() {
		return execution;
	}

	public int getTimeArriving() {
		return timeArriving;
	}

	public int getId_Core() {
		return idCore;
	}

	public void setId_Core(int id_Core) {
		this.idCore = id_Core;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public void setExecution(boolean execution) {
		this.execution = execution;
	}
	public void setWait(boolean wait) {
		this.wait = wait;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public void setTimeWaiting() {
		this.timeWaiting = this.timeResponse;
	}
	public void setTimeResponse(int timeResponse) {
		this.timeResponse = timeResponse;
	}
	public double getTimeExecution() {
		return timeExecution;
	}
	public void setTimeExecution(double timeExecution) {
		this.timeExecution = timeExecution;
	}
	public void setTimeDelay() {
		this.timeDelay = this.turnAround/this.timeExecution;
	}
	public void setTurnAround() {
		this.turnAround = this.timeExecution + this.timeWaiting;
	}
	public int getRateCacheMiss() {
		return rateCacheMiss;
	}
	public int getRateAccessMemory() {
		return rateAccessMemory;
	}
	public int getRateCalculations() {
		return rateCalculations;
	}
	public String getNome_core() {
		return nome_core;
	}
	public void setNome_core(String nome_core) {
		this.nome_core = nome_core;
	}

	public int findMax(){

		/*int i;
	    int max = statistic.get(0);
	    int indice = 0;
	    
	    for(i = 1; i < 3; i++){
	      if(statistic.get(i) > max){
	        max = statistic.get(i);
	        indice = i;
	      }
	    }*/
	    
	    return statistic.get(statistic.lastKey());
	}
}
