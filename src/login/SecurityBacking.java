package login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class SecurityBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4938147772895558232L;

	public String invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "/client/index.jsf?faces-redirect=true";
	}

	public boolean isLoggedIn(){
		if(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getUserPrincipal()!=null)
			return true;
		return false;
	}
	public String getUsername() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		return request.getUserPrincipal().getName();
	}

	public String getCodFisc() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		return ((UserPrincipal) request.getUserPrincipal()).getCodFisc();
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();

		request.getSession().invalidate();
		return "/index.jsf?faces-redirect=true";
	}

}