package sam

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.TimeoutException
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import common.CouleurEst
import common.FormeEst
import common.HelperElement
import internal.GlobalVariable

public class Element {

	private static String ROND = "item-round"
	private static String CARRE = ""
	private static String VERT = "nominal"
	private static String GRIS = "aucunEtat"
	private static String JAUNE = "alarmeMineure"

	@Keyword
	def static cliquerElement(String nom) {

		// Parfois au chargement le page fait un resfresh non-stop (pb appli ou browser ?)
		// Pour pallier à ça si l'item que lon recherche n'a pas été trouvé alors
		// on refresh la page et on retente (5 fois max)
		int MAX_TRIES = 5
		WebDriverWait driverWait = new WebDriverWait(DriverFactory.getWebDriver(), 30)
		WebElement container

		for (def index : (1..5)) {
			container = HelperElement.getItemContainerParNom nom
			if (container != null)
				index = 5
			else
				WebUI.refresh()
		}

		// Si on a tjrs rien, on failed le test
		if (container == null)
			KeywordUtil.markFailedAndStop("Aucun item nommé $nom n'a été trouvé")

		container.click()
	}

	/**
	 * Vérifie que l'item de l'interface SAM correspond à l'attendu. 
	 * Retrouve l'élément via son nom puis check ses classes pour vérifier la forme et la couleur
	 * @param nom Nom de l'élément à vérifier
	 * @param forme Forme attendue de l'élément
	 * @param couleur Couleur attendue de l'élement
	 */
	@Keyword
	def static verifierElement(String nom, String forme, String couleur) {

		// Parfois au chargement le page fait un resfresh non-stop (pb appli ou browser ?)
		// Pour pallier à ça si l'item que lon recherche n'a pas été trouvé alors
		// on refresh la page et on retente (5 fois max)
		int MAX_TRIES = 5
		WebDriverWait driverWait = new WebDriverWait(DriverFactory.getWebDriver(), 30)
		WebElement container

		for (def index : (1..5)) {
			container = HelperElement.getItemContainerParNom nom
			if (container != null)
				index = 5
			else
				WebUI.refresh()
		}

		// Si on a tjrs rien, on failed le test
		if (container == null)
			KeywordUtil.markFailedAndStop("Aucun item nommé $nom n'a été trouvé")

		// Sinon on check les classes du container pour vérifier si ça correpond à l'attendu (forme+couleur)
		// Attention le changement est asynchrone vis-à-vis du chargement de jeux de donnée
		// PAr conséquent, il faut pouvoir vérifier continuellement jusqu'à un timeout
		boolean colorMatch = false
		boolean formeMatch = false

		try {
			colorMatch = driverWait.until(new CouleurEst(nom, couleur))
		} catch (TimeoutException e) {
			colorMatch = false
		}
		try {
			formeMatch = driverWait.until(new FormeEst(nom, forme))
		} catch (TimeoutException e) {
			formeMatch = false
		}

		if (!colorMatch && !formeMatch) {
			KeywordUtil.markFailedAndStop("FAILED ! L'item de $nom n'a pas la forme ni la couleur attendue !")
		}
		if (colorMatch && !formeMatch) {
			KeywordUtil.markFailedAndStop("FAILED ! L'item de $nom a la couleur attendue mais la mauvaise forme!")
		}
		if (!colorMatch && formeMatch) {
			KeywordUtil.markFailedAndStop("FAILED ! L'item de $nom a la forme attendue mais la mauvaise couleur !")
		}
		if (colorMatch && formeMatch) {
			KeywordUtil.markPassed("PASSED ! L'item de $nom a la forme et la couleur attendue !")
		}
	}







}
