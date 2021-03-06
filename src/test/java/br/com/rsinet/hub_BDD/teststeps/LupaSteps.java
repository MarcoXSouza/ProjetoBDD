package br.com.rsinet.hub_BDD.teststeps;

import org.testng.Assert;

import br.com.rsinet.hub_BDD.PageFactory.HomePage;
import br.com.rsinet.hub_BDD.PageFactory.LupaPage;
import br.com.rsinet.hub_BDD.managers.TestContext;
import br.com.rsinet.hub_BDD.utils.Wait;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class LupaSteps {
	private LupaPage lupa;
	private HomePage home;
	private TestContext testContext;
	private Wait wait;

	public LupaSteps(TestContext context) {
		testContext = context;
		home = testContext.getPageObjectFactory().getHomePage();
		lupa = testContext.getPageObjectFactory().getLupaPage();
		wait = testContext.getPageObjectFactory().getWait();
	}

	@Dado("que cliquei na lupa")
	public void que_cliquei_na_lupa() {
		home.getMenu();
	}

	@Quando("pesquisar o produto \"([^\"]*)\"")
	public void pesquisar_o_produto(String produto) {
		home.getDigita(produto);
		lupa.produto();
	}

	@Quando("pesquisar o produto inexistente \"([^\"]*)\"")
	public void pesquisar_o_produto_inexistente(String produto) {
		home.getDigita(produto);
	}

	@Entao("escolher produto")
	public void escolher_produto() {
		lupa.adicionaAoCarrinho();
		wait.untilPageLoadComplete();
		Assert.assertTrue(lupa.verificaCarrinho().equals("1"));

	}

	@Entao("a mensagem de item nao encontrado aparecera")
	public void a_mensagem_de_item_nao_encontrado_aparecera() {
		wait.untilPageLoadComplete();
		Assert.assertTrue(lupa.buscaInvalida().contains("No results for "));

	}

}
