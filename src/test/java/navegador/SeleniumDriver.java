package navegador;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumDriver {

    static WebDriver driver = null;

    public static WebDriver getDriver() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities
                .chrome();
        capabilities.setJavascriptEnabled(true);
        capabilities
                .setCapability("chrome.binary",
                        "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
        capabilities.setCapability("acceptInsecureCerts", true);
        capabilities.setCapability("acceptSslCerts", true);

        // Lança o ChromeDriver em modo anonimo e máximizado
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY,
                options);

        // Pega driver do workspace do Jenkins
        /*
         * String dir = System.getenv("WORKSPACE"); if (dir ==
         * null){ throw new Exception(
         * "Nao foi definida a variável de ambiente 'WORKSPACE' no Run do Projeto."
         * ); }
         */

        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");
        driver = new ChromeDriver(capabilities);

        return driver;
    }
}