package com.ntgclarity.smartcompound.portal.converter.base;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.common.spring.applicationcontext.SpringApplicationContext;

public class BaseConverter {


	public SmartCompoundManagment getSmartCompoundManagment() {
		return SpringApplicationContext.getApplicationContext().getBean(SmartCompoundManagment.class);
	}

	
	
	
	
	
}
