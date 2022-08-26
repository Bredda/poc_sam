package common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition

import com.kms.katalon.core.util.KeywordUtil

public class CouleurEst implements ExpectedCondition{


	String expectedColor;
	String nom

	public CouleurEst(String nom, String expectedColor) {
		KeywordUtil.logInfo "Waiting for $nom to have color: $expectedColor"
		this.expectedColor = expectedColor;
		this.nom = nom
	}



	@Override
	public Boolean apply(WebDriver driver) {
		WebElement item = HelperElement.getItemContainerParNom(nom)
		Boolean result = true;
		switch(expectedColor.toLowerCase().trim()) {
			case "vert":
				result = HelperElement.estVert(item)
				break;
			case "gris":
				result = HelperElement.estGris(item)
				break;
			case "jaune":
				result = HelperElement.estJaune(item)
				break;
			case "orange":
				result = HelperElement.estOrange(item)
				break;
			case "rouge":
				result = HelperElement.estRouge(item)
				break;
			default:
				KeywordUtil.markErrorAndStop("La couleur $expectedColor est inconnue.")
				break;
		}
		return result;
	}
}
