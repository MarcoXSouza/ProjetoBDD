package br.com.rsinet.hub_BDD.PageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class BuscaPage {
	public BuscaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "1")
	private WebElement itens;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement adicionaAoCarrinho;

	@FindBy(how = How.NAME, using = "quantity")
	private WebElement quantidade;

	@FindBy(how = How.ID, using = "Description")
	private WebElement mensagem;

	@FindBy(how = How.XPATH, using = "//*[@id=\"productProperties\"]/label")
	private WebElement texto;

	public void escolheItem() {
		itens.click();
	}

	public void adicionaAoCarrinho() {
		adicionaAoCarrinho.click();
	}

	public void quantidade() {
		quantidade.sendKeys("11");
	}

	public void comparaPositivo() {
		String text = mensagem.getText();
		Assert.assertTrue(text.contains("HP PAVILION 15T TOUCH LAPTOP"));
	}
	
	public void comparaNegativo() {
		String text = texto.getText();
		Assert.assertTrue(text.equals("Oops! We only have 10 in stock. We updated your order accordingly"));
	}
	
}