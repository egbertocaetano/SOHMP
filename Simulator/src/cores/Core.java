package cores;

import util.Util;
import entity.Process;

public class Core {
	
	protected int id;
	protected boolean available;
	protected Process process;
	protected int cicloClock = 0;
	protected String nome_core;
	
	public Core(int _id) {
		
		this.id = _id;
		this.available = true;
		this.cicloClock = 0;
		this.nome_core = Core.class.getSimpleName() + " Normal";
	}
	
	public void execute(){
			
				
		process.plusExecute();
		
		if(process.getTimeCPU() == process.getTimeExecution()){
			
			process.setExecution(false);
			process.setFinished(true);
			process.calcTime();
			Util.finishProcess(process);
			this.setAvailable(true);
		}
	}
	
	public boolean putProcess(Process _process) {
		
		if(isAvailable()){
			this.process = _process;
			this.setAvailable(false);
			return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}	
}
