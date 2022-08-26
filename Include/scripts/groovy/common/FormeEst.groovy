package common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition

import com.kms.katalon.core.util.KeywordUtil

public class FormeEst implements ExpectedCondition{


	String expectedForme;
	String nom

	public FormeEst(String nom, String expectedForme) {
		KeywordUtil.logInfo "Waiting for $nom to have form: $expectedForme"
		this.expectedForme = expectedForme;
		this.nom = nom
	}



	@Override
	public Boolean apply(WebDriver driver) {
		WebElement item = HelperElement.getItemContainerParNom(nom)
		Boolean result = true
		switch(expectedForme.toLowerCase().trim()) {
			case "rond":
			case "ronde":
				result = HelperElement.estRond(item)
				break;
			case "carré":
			case "carre":
			case "carrée":
			case "carree":
				result = !HelperElement.estRond(item)
				break;
			default:
				KeywordUtil.markErrorAndStop("La forme $expectedForme est inconnue.")
				break;
		}
		KeywordUtil.logInfo "$nom is currentlty ${HelperElement.getForme(item)}"
		return result;
	}
}

