import database.*;

public class StateTracker {
	
	
	private static StateTracker instance;
	
	private Vendita current_tentata_vendita;
	
	private StateTracker(){
		this.current_tentata_vendita = null;
	}
	
	public static StateTracker getStateTracker(){
		if (instance == null) instance = new StateTracker();
		return instance;
	}
	
	public Vendita getCurrent_tentata_vendita() {
		return current_tentata_vendita;
	}

	public void setCurrent_tentata_vendita(Vendita current_tentata_vendita) {
		this.current_tentata_vendita = current_tentata_vendita;
	}

}
