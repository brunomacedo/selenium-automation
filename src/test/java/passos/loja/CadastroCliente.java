package passos.loja;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import paginas.loja.PaginaLogin;
import robo.Robo;

public class CadastroCliente extends Robo {

    private PaginaLogin paginaLogin;
    protected Scenario cenario;

    public void carregarPagina() {
        this.paginaLogin = new PaginaLogin();
        PageFactory.initElements(driver, this.paginaLogin);
    }

    @Before(value = "@CadastroCliente")
    public void before(Scenario scenario) {
        this.cenario = scenario;
    }

    @Given("o usuario acessou a pagina de cadastro")
    public void oUsuarioAcessouAPaginaDeCadastro() {
        acessarPagina("/index.php?route=account/register");
    }
}
