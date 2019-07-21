package webSite.stepDefinitions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hook {
	public static WebDriver navegador;

	@Before
	public WebDriver IniciarNavegador()  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pichau\\eclipse-workspace\\FrameworkDesafioWebSite\\src\\test\\resourses\\chromedriver.exe");
		Dimension d = new Dimension(1382,744);
		Hook.navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().window().setSize (d);
		Hook.navegador.get("https://phptravels.net/admin");
		Hook.navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return Hook.navegador;
	}
	
	public static WebDriver getNavegador() {
		return Hook.navegador;
	}
	
	@After
	public void fechar() {
		Hook.navegador.quit();
	}
}
