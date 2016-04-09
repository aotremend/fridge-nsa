package ro.tremend.poets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ro.tremend.poets.config.FridgeNsaApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FridgeNsaApplication.class)
@WebAppConfiguration
public class FridgeNsaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
