package passos.loja;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import paginas.loja.PaginaLogin;
import robo.Robo;

public class Login extends Robo {

    private PaginaLogin paginaLogin;
    protected Scenario cenario;


    public void carregarPagina() {
        this.paginaLogin = new PaginaLogin();
        PageFactory.initElements(driver, this.paginaLogin);
    }

    @Before(value = "@LoginLoja")
    public void before(Scenario scenario){
        this.cenario = scenario;
    }

    @Given("o usuario esta logado")
    public void oUsuárioEstaLogado() {
        acessarPagina("/index.php?route=account/login");
        carregarPagina();
        digitar(paginaLogin.getCampoUsuario(), "teste.cadastro@mailcatch.com");
        digitar(paginaLogin.getCampoSenha(), "123456");
        clicar(paginaLogin.getBotaoFazerLogin());
    }

    @Given("o usuario acessou a pagina de login")
    public void oUsuarioAcessouAPaginaDeLogin() {
        acessarPagina("/index.php?route=account/login");
    }

    @When("digitar o email {string} e a senha {string} no login")
    public void digitarOEmailEASenha(String email, String senha) {
        carregarPagina();
        digitar(paginaLogin.getCampoUsuario(), email);
        digitar(paginaLogin.getCampoSenha(), senha);
        clicar(paginaLogin.getBotaoFazerLogin());
    }
}
