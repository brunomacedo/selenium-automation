package robo;

import navegador.SeleniumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Robo {

    protected static WebDriver driver;

    public Robo() {
        iniciarWebdriver();
    }

    public void iniciarWebdriver() {
        try {
            driver = SeleniumDriver.getDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPropriedade(String arquivo, String propriedade) {
        Properties properties = new Properties();
        String value = null;

        try {
            properties.load(new FileInputStream("propriedades/" + arquivo));
            value = properties.getProperty(propriedade);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public void acessarPagina(String urlComplemento) {
        String urlPrincipal = getPropriedade("sistema", "url");
        driver.get(urlPrincipal + urlComplemento);
        aguardar();
    }

    /**
     * Faz uma espera implícita de até 30 segundos. O robô reconhece quando a
     * tela carregou. Se a tela não carregar em até 30 segundos, o robô falha o
     * passo.
     */
    public void aguardar() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * Aguarda um determinado número de segundos.
     *
     * @param segundos
     */
    public void aguardarSegundosComThreadSleep(int segundos) {
        long milisegundos = segundos * 1000;
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aguarda um atributo do tipo By. Como usar:
     * aguardar(pagina.getNomeDoCampo().getAttribute("id"));
     *
     * @param id
     */
    public void aguardar(String id) {
        By idEsperar = By.id(id);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(idEsperar));
        } catch (ExceptionInInitializerError e) {
            Assert.fail("Não encontrou o elemento " + id + " na tela.");
            e.printStackTrace();
        }
    }

    public void digitar(WebElement elemento, String informacao) {
        elemento.sendKeys(informacao);
    }

    public void clicar(WebElement elemento) {
        elemento.click();
    }

    public void fecharDriversAbertos() {
        try {
            Runtime.getRuntime().exec("taskkill -f -im chromedriver.exe").waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
