package com.examcom.udacity.jwdnd.c1.review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	private String port;

	private static WebDriver driver;
	private SignUpPage signUpPage;
	private LoginPage loginPage;

	@BeforeAll
	public static void beforeAll(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	void contextLoads() throws InterruptedException {
		testSignUp();
		Thread.sleep(1000);
		testLogin();
	}

	@Test
	void testSignUp(){
		driver.get("http:localhost:" + port + "/signup");
		signUpPage = new SignUpPage(driver);
		signUpPage.setFirstNameField("guangqi");
		signUpPage.setLastNameField("qing");
		signUpPage.setPasswordField("helloworld");
		signUpPage.setUsernameField("test");
		signUpPage.submit();
	}

	@Test
	void testLogin(){
		driver.get("http:localhost:" + port + "/login");
		loginPage = new LoginPage(driver);
		loginPage.setPassword("helloworld");
		loginPage.setUsername("test");
		loginPage.submit();
	}
}
