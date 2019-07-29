package cucumberOptions;

import org.openqa.selenium.remote.UnreachableBrowserException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import commons.Constansts;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Hooks {
// Khởi tạo browser/ đóng browser cho tất cả các scenario trong feature\
	// Run for many thread
		private static WebDriver driver;
		private static final Logger log = Logger.getLogger(Hooks.class.getName());

		@Before
		public synchronized static WebDriver openAndQuitBrowser() {
			// Run by Maven command line
			String browser = System.getProperty("BROWSER");

			// Check driver đã được khởi tạo hay chưa?
			if (driver == null) {
				try {
					// Kiem tra BROWSER = null -> gan = chrome/ firefox (browser default for project)
					if (browser == null) {
						browser = System.getenv("BROWSER");
						if (browser == null) {
							browser = "firefox";
						}
					}

					switch (browser) {
					case "chrome":
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
						break;
					case "hchrome":
						WebDriverManager.chromedriver().setup();
						ChromeOptions options = new ChromeOptions();
						options.addArguments("headless");
						options.addArguments("window-size=1366x768");
						driver = new ChromeDriver(options);
						break;
					case "firefox":
						// Download gecko driver
						//WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						break;
					case "hfirefox":
						//WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						break;
					case "ie":
						WebDriverManager.iedriver().arch32().setup();
						driver = new InternetExplorerDriver();
						break;
					default:
						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
						break;
					}
				// Browser crash
				} catch (UnreachableBrowserException e) {
					driver = new ChromeDriver();
				// driver crash
				} catch (WebDriverException e) {
					driver = new ChromeDriver();
				}
				// Code này luôn luôn được chạy dù pass hay fail
				finally {
					Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
				}

				System.out.println("Browser name = " + browser);
				
				driver.get(Constansts.BANK_URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				log.info("------------- Started the browser -------------");
			}
			return driver;
		}

//		@After
//		public static void quitBrowser() {
//			if (driver != null) {
//				driver.quit();
//			}
//		}

		public static void close() {
			try {
				if (driver != null) {
					openAndQuitBrowser().quit();
					log.info("------------- Closed the browser -------------");
				}
			} catch (UnreachableBrowserException e) {
				System.out.println("Can not close the browser");
			}
		}

		private static class BrowserCleanup implements Runnable {
			public void run() {
				close();
			}
		}

}
