package com.ntgclarity.smartcompound.portal.base;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
@ManagedBean
public class BaseBean implements Serializable {

	

	/**  
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addErrorMessage(String key) {
		String message = getMessageValue(key);
		addMessage(FacesMessage.SEVERITY_ERROR, message);

	}
	
	public void addInfoMessage(String key) {
		String message = getMessageValue(key);
		addMessage(FacesMessage.SEVERITY_INFO, message);
   
	}
	
	
	
	private String getMessageValue(String key) {
		// get the value from resource bundle
		return key;
	}

	public void addMessage(FacesMessage.Severity severity, String summary,
			String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, summary, detail));
	}

	public void addMessage(FacesMessage.Severity severity, String summary) {
		addMessage(severity,summary, "");
	}
}
