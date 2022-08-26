package sam

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import common.Helpers
import internal.GlobalVariable





public class Grid {

	private static String MINEURE = "alarmeMineure"
	private static String MAJEURE="alarmeMajeure"
	private static String BLOQUANTE="alarmeBloquante"

	/**
	 * Pour le tableau donné, vérifie pour toutes les lignes:
	 * 1. Que l'on a pas que des icones info ou ok dans la seconde colonne (Etat)
	 * 2. Que l'on a pas de gravité indiqué dans la 6ème colonne (Gravité)
	 * @param grid
	 * @return
	 */
	@Keyword
	def static verifierAucuneErreur(TestObject grid) {

		WebElement gridEl = WebUiCommonHelper.findWebElement(grid, 30)

		// 1. Vérification que l'on a pas d
		List<String> cellEtatImgSrc = gridEl
				.findElements(By.cssSelector("tbody > tr > td:nth-child(2) > img"))
				.collect {img -> img.getAttribute("src") }
				.eachWithIndex  { it, index ->
					if (!it.contains("ok.svg") && !it.contains("information.svg")) {
						KeywordUtil.markFailedAndStop("La grille de données des sous-système contient une erreur non attendue à la ligne ${index+1}")
					}
				}

		List<String> cellGraviteClasses	= gridEl
				.findElements(By.cssSelector("tbody > tr > td:nth-child(6)"))
				.collect {td -> td.getAttribute("class") }
				.eachWithIndex  { it, index ->
					if (it.contains(MINEURE) || it.contains(MAJEURE) || it.contains(BLOQUANTE)) {
						KeywordUtil.markFailedAndStop("La grille de données des sous-système contient une erreur non attendue à la ligne ${index+1}")
					}
				}

		KeywordUtil.markPassed("La grille de données des sous-systèmes ne contient aucune erreur ou indice de rgavité")
	}

	@Keyword
	def static verifierPresenceErreur(TestObject grid, Map erreursAttendues) {
		WebElement gridEl = WebUiCommonHelper.findWebElement(grid, 30)

		int rowMax = gridEl.findElements(By.cssSelector("tbody > tr")).size()

		// Pour chaque igne on vérifie la clolonne Date puis la colonne Durée
		for (def index : (1..rowMax)) {
			WebElement row = gridEl.findElement(By.cssSelector("tbody > tr:nth-child($index)"))
			String name =  row.findElement(By.cssSelector("td:nth-child(1)")).getText()
			String etatImgSrc = row.findElement(By.cssSelector("td:nth-child(2) > img")).getAttribute("src")
			String grviteClasses = row.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("class")

			if(erreursAttendues.containsKey(name)) {
				if (!etatImgSrc.contains("ko.svg")) {
					KeywordUtil.markFailedAndStop("La grille de données des sous-système ne contient pas l'icone d'erreur attendue à la ligne ${index}. Attendue: ko.svg, réel: $etatImgSrc")
				}
				if (!grviteClasses.contains(erreursAttendues[name])) {
					KeywordUtil.markFailedAndStop("La grille de données des sous-système ne contient pas la gravité attendue à la ligne ${index}. Attendue: ${erreursAttendues[name]}, réelle: $grviteClasses ")
				}
			} else {
				if (!etatImgSrc.contains("ok.svg") && !etatImgSrc.contains("information.svg")) {
					KeywordUtil.markFailedAndStop("La grille de données des sous-système contient une erreur non attendue à la ligne ${index}")
				}
				if (grviteClasses.contains(MINEURE) || grviteClasses.contains(MAJEURE) || grviteClasses.contains(BLOQUANTE)) {
					KeywordUtil.markFailedAndStop("La grille de données des sous-système contient une gravité non attendue à la ligne ${index}")
				}
			}

		}

	}


	@Keyword
	def static verifierHorodatageOk(TestObject grid, int maxSecondsRefresh) {
		WebElement gridEl = WebUiCommonHelper.findWebElement(grid, 30)

		// Contrairement à verifierAucuneErreur, on ne doit récupérer les cellules à vérifier une par une
		// Comme on va devoir vérifier la cohérence d'un horodatage à quelques secondes et que la valeur
		// est updatée très régulièrement, on doit récupérer pour chaque ligne la valeur la plus fraîche possible

		// 1. Récupérer le nombre de ligne à vérifier

		int rowMax = gridEl.findElements(By.cssSelector("tbody > tr")).size()

		// Pour chaque igne on vérifie la clolonne Date puis la colonne Durée
		for (def index : (1..rowMax)) {
			gridEl = WebUiCommonHelper.findWebElement(grid, 30)
			String horodatage = gridEl.findElement(By.cssSelector("tbody > tr:nth-child($index) > td:nth-child(3)")).getText()
			def result = Helpers.isDateLessThanXSecondes(horodatage, maxSecondsRefresh)
			if (!result['result']) {
				KeywordUtil.markFailedAndStop("La date de la ligne $index est passée de plus de $maxSecondsRefresh secondes. Date affichée: $horodatage, Date de vérification: ${result['now']}")
			}
			// Pour la seconde vérif on refresh encore la référence au tableau puis la ligne
			gridEl = WebUiCommonHelper.findWebElement(grid, 30)
			String since = gridEl.findElement(By.cssSelector("tbody > tr:nth-child($index) > td:nth-child(4)")).getText()
			boolean sinceResult = Helpers.isSinceLessThanXSeconds(since, maxSecondsRefresh)
			if (!sinceResult ) {
				KeywordUtil.markFailedAndStop("La date de la ligne $index à une durée depuis la dernière lecture de plus de $maxSecondsRefresh. Durée affichée: $since")
			}
		}


	}


}
