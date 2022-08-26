package common

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.webui.driver.DriverFactory



















public class HelperElement {

	private static String ROND = "item-round"
	private static String CARRE = ""
	private static String VERT = "nominal"
	private static String GRIS = "nonSupervise"
	private static String JAUNE = "alarmeMineure"
	private static String ORANGE="alarmeMajeure"
	private static String ROUGE="alarmeBloquante"

	public static String getForme(WebElement item) {
		if (estRond(item))
			return "rond"
		if (estCarre(item))
			return "carré"
		return "forme inconnue"
	}
	public static String getCouleur(WebElement item) {
		if (estJaune(item))
			return "jaune"
		if (estVert(item))
			return "vert"
		if (estGris(item))
			return "gris"
		return "couleur inconnue"
	}
	public static boolean estRond(WebElement item) {
		return item.getAttribute("class").contains(ROND)
	}

	public static boolean estCarre(WebElement item) {
		return !estRond(item)
	}

	private static boolean estJaune(WebElement item) {
		return item.getAttribute("class").contains(JAUNE)
	}

	private static boolean estVert(WebElement item) {
		return item.getAttribute("class").contains(VERT)
	}

	private static boolean estGris(WebElement item) {
		return item.getAttribute("class").contains(GRIS)
	}

	private static boolean estOrange(WebElement item) {
		return item.getAttribute("class").contains(ORANGE)
	}
	private static boolean estRouge(WebElement item) {
		return item.getAttribute("class").contains(ROUGE)
	}
	public static WebElement getItemContainerParNom(String nom) {
		new WebDriverWait(DriverFactory.getWebDriver(), 30)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("p.item-name")))
		return DriverFactory.getWebDriver().findElements(By.cssSelector(".item"))
				.find { e -> e.findElement(By.cssSelector("p.item-name")).getText().trim().equalsIgnoreCase(nom) }
	}
}
