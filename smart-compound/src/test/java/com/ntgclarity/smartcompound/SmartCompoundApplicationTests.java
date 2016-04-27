package com.ntgclarity.smartcompound;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ntgclarity.smartcompound.spring.initializer.SmartCompoundApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmartCompoundApplication.class)
@WebAppConfiguration
public class SmartCompoundApplicationTests {

	@Test
	public void contextLoads() {
	}

}
