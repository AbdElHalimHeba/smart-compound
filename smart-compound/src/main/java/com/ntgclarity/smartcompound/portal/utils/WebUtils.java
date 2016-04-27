package com.ntgclarity.smartcompound.portal.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class WebUtils {

	public static HttpSession getCurrentHTTPSession()
	{
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return httpSession;
	}
	
	
	public static void injectIntoSession(String string, Object obj) {
		HttpSession httpSession = getCurrentHTTPSession();	
		httpSession.setAttribute(string, obj);
	}

}
