package login;

import java.security.Principal;

public class UserPrincipal implements Principal {

	private String name;
	private String codFisc;

	public UserPrincipal(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setCodFisc(String name) {
		this.codFisc = name;
	}

	public String getCodFisc() {
		return codFisc;
	}

}
