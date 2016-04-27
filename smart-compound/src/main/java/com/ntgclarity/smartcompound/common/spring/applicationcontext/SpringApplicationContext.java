package com.ntgclarity.smartcompound.common.spring.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		applicationContext = appContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
