package com.ntgclarity.smartcompound.ws.controller;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.spring.applicationcontext.SpringApplicationContext;

public class AbstractController {

	protected SmartCompoundManagment getSmartCompoundManagement() {
		SmartCompoundManagment smartCompoundManagment = SpringApplicationContext
				.getApplicationContext().getBean(SmartCompoundManagment.class);
		return smartCompoundManagment;
	}

}
