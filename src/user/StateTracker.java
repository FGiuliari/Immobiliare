package user;
import database.*;

public class StateTracker {
	
		
	private Vendita current_tentata_vendita;
	private User user;
	
	public StateTracker(){
		this.current_tentata_vendita = null;
		this.user=null;
		
	}

	public Vendita getCurrent_tentata_vendita() {
		return current_tentata_vendita;
	}

	public void setCurrent_tentata_vendita(Vendita current_tentata_vendita) {
		this.current_tentata_vendita = current_tentata_vendita;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
