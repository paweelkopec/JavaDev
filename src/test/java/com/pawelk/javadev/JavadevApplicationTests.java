package com.pawelk.javadev;

import com.pawelk.javadev.controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class JavadevApplicationTests {

	@Autowired
	private  HomeController homeController;

	@Test
	public void contextLoads() throws  Exception {

		assertThat(homeController).isNotNull();

	}


}
