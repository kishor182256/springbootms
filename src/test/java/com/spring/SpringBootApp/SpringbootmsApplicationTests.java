package com.spring.SpringBootApp;

import com.spring.SpringBootApp.model.User;
import com.spring.SpringBootApp.repository.UserRepository;
import com.spring.SpringBootApp.security.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootApTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtHelper jwtHelper;



	@Test
	void contextLoads() {
	}

	@Test
	void token() {
		String user = "kishor.gunjal@gmail.com";
        String token = jwtHelper.generateToken(String.valueOf(user));
        System.out.println("Generated token: " + token);
        System.out.println("System.out.println(\"Generated token: \" + token);: " + jwtHelper.getUsernameFromToken(token));
    }


}
