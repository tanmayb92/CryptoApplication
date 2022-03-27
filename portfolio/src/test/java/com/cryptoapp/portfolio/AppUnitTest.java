package com.cryptoapp.portfolio;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import com.cryptoapp.portfolio.controller.AppController;
import com.cryptoapp.portfolio.dto.User;
import com.cryptoapp.portfolio.service.UserDaoService;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUnitTest {

	@MockBean
	private UserDaoService userService;

	@Autowired
	private AppController reverser;

	@Test
	public void getUserById() {
		given(this.userService.findById(1L)).willReturn(Optional.of(new User("Tn", "Bh", "Male", "mail", "91702392")));
		User user = reverser.getUserById(1L);
		assertThat(user.getPhoneNumber()).isEqualTo("91702392");
	}

}