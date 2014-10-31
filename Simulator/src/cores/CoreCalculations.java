package cores;

import util.Util;

public class CoreCalculations extends Core {

	private double bonus = 0.20;
	
	public CoreCalculations(int _id) {
		super(_id);
		this.nome_core = CoreCalculations.class.getSimpleName();
	}

	@Override
	public void execute() {
		
		int count;
		double countplus;
		
		process.setTimeResponse(Util.timeClock);
		process.setId_Core(this.id);
		process.setNome_core(this.nome_core);
		
		process.setReady(false);
		process.setExecution(true);
		
		for(count = 0; count < process.getTimeCPU(); count++){
			this.cicloClock++;
		}
		
		if(process.getRateCalculations() >= 30){
			
			countplus = (count - (count*bonus)); 
			process.setTimeExecution(countplus);
		}
		else{
			process.setTimeExecution(count);
		}
			
		process.setExecution(false);
		
		process.setFinished(true);
		
		process.calcTime();
		Util.finishProcess(process);
		this.setAvailable(true);
	}
	
	
}
