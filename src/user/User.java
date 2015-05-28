package user;
import database.*;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import database.DataSource;

@ManagedBean(name = "User")
@SessionScoped
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String codFisc;
	private boolean loggedIn;
	private DataSource ds;
	
	
	@PostConstruct
	public void initialize() {
		StateTracker.getStateTracker().setUser(this);

		try {
			this.ds = new DataSource();
		} catch (ClassNotFoundException e) {
			this.ds = null;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String newValue) {
		username = newValue;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String newValue) {
		password = newValue;
	}	
	
	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String login() {
		loggedIn = ds.login(username, password);
		if (!loggedIn) {
			username = null;
			password = null;
			codFisc = null;
		}
		return "index";
	}

	public String logout() {
		username = null;
		password = null;
		loggedIn = false;
		codFisc = null;
		return "index";
	} 
}
