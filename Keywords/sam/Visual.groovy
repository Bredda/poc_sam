package sam

import java.awt.Color
import java.awt.image.BufferedImage
import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO

import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import kms.turing.katalon.plugins.helper.DateTimeHelper
import kms.turing.ru.yandex.qatools.ashot.AShot
import kms.turing.ru.yandex.qatools.ashot.Screenshot
import kms.turing.ru.yandex.qatools.ashot.comparison.ImageDiff
import kms.turing.ru.yandex.qatools.ashot.comparison.ImageDiffer
import kms.turing.ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import kms.turing.ru.yandex.qatools.ashot.shooting.ShootingStrategies

public class Visual {

	static final String baselineDir = RunConfiguration.getProjectDir() + File.separator + "Screenshots"
	static final String reportScreenshotdir = RunConfiguration.getReportFolder() + File.separator + "Screenshots"

	static final Color ignoredColor = Color.GRAY
	static final int scrollTimeout = 100
	static final int timeout = 10
	static final String extension = ".png"
	/**
	 * Take the picture of a specific web element using AShot and save to screenshots folder in current working project
	 * @param object the web element need to take picture
	 * @param filename the image will be save with the name
	 */
	@Keyword
	static void takeWebElementBaseline(TestObject object, String filename){
		try{
			KeywordUtil.logInfo "Take baseline screenshot of object $object within $timeout seconds"
			def screenshot = _takeWebElementScreenshot object
			KeywordUtil.logInfo "Save the screenshot into file: $filename"
			saveScreenshot(Paths.get(baselineDir), filename, screenshot)
		}catch(ex){
			System.out.println(ex)
		}
	}


	/**
	 * Take the picture of a specific web element using AShot and save to screenshots folder in current working project
	 * @param object the web element need to take picture
	 * @param filename the image will be save with the name
	 */
	@Keyword
	static void takeWebElementScreenshot(TestObject object, String filename){
		try{
			KeywordUtil.logInfo "Take screenshot of object $object within $timeout seconds"
			def screenshot = _takeWebElementScreenshot object
			saveScreenshot(Paths.get(reportScreenshotdir), filename, screenshot)
		}catch(ex){
			System.out.println(ex)
		}
	}


	@Keyword
	static void verifierWebElementBaseline(TestObject object, String filename) {
		String expectedImgPath = Paths.get(baselineDir).resolve(filename+extension)
		takeWebElementScreenshot(object, filename)
		WebUiBuiltInKeywords.delay(1)
		String actualImgPath = Paths.get(reportScreenshotdir).resolve(filename+extension)
		areMatched(expectedImgPath, actualImgPath)
	}

	@Keyword prendreScreenPage(String filename) {
		try{
			KeywordUtil.logInfo "Prise de screenshot de la page entière"
			def screenshot = _takeFullpageScreenshot()
			saveScreenshot(Paths.get(reportScreenshotdir), filename, screenshot)
		}catch(ex){
			System.out.println(ex)
		}
	}

	private static void saveScreenshot(Path pathDir, String filename, Screenshot screenshot){
		if(!pathDir.toFile().exists()){
			pathDir.toFile().mkdir()
		}
		Path finalPath = pathDir.resolve(filename+extension)
		KeywordUtil.logInfo "Enregistrement du screnshot dans ${finalPath.toString()}"
		try {
			ImageIO.write(screenshot.getImage(), "png", finalPath.toFile())
		} catch (Exception e) {
			KeywordUtil.markError("Erreur write image")
			throw e
		}
	}

	private static Screenshot _takeFullpageScreenshot() {
		def screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(scrollTimeout))
				.takeScreenshot(DriverFactory.getWebDriver())
		return screenshot
	}

	private static Screenshot _takeWebElementScreenshot(TestObject object) {
		def timeoutMsg = "Fail to take web element screenshot due to timeout"
		def driver = DriverFactory.getWebDriver()
		def startTime = Calendar.getInstance().getTime()
		def element = WebUiCommonHelper.findWebElement(object, timeout)
		def remainingTime = timeout - DateTimeHelper.getElapsedTime(startTime, Calendar.getInstance().getTime())
		if (remainingTime <= 0) {
			KeywordUtil.markErrorAndStop("Fail to take web element screenshot due to timeout")
		}

		WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), remainingTime)
		wait.until(ExpectedConditions.visibilityOf(element))

		def screenshot = new AShot()
				.coordsProvider(new WebDriverCoordsProvider())
				.shootingStrategy(ShootingStrategies.viewportPasting(scrollTimeout))
				.takeScreenshot(driver, element)
		return screenshot
	}

	private static boolean areMatched(String expectedImgPath, String actualImgPath){

		if (!new File(expectedImgPath).exists())
			KeywordUtil.markErrorAndStop "L'image baseline $expectedImgPath n'existe pas. Faire un run avec createBaseline à true ?"

		try{
			KeywordUtil.logInfo "Verify the image at location: $expectedImgPath is matched the other image at: $actualImgPath"
			BufferedImage expectedImage = ImageIO.read(new File(expectedImgPath+extension))
			BufferedImage actualImage = ImageIO.read(new File(actualImgPath+extension))

			ImageDiffer imgDiff = new ImageDiffer()
			ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage)
			if(diff.hasDiff()){
				String filename = new File(actualImgPath).getName()
				File diffFile =  Paths.get(reportScreenshotdir).resolve(filename + "diff_").toFile()
				ImageIO.write(diff.getMarkedImage(), extension, diffFile)
				KeywordUtil.markFailedAndStop("L'image ne correspond pas à l'affichage actuel. Attendu: $expectedImgPath, réel: $actualImgPath. Une image diff est disponible ici: ${diffFile.toString()}")
			} else {
				KeywordUtil.markPassed("Comparaison visuelle ok entre $expectedImgPath et $actualImgPath")
			}
		}catch(ex){
			System.out.println(ex)
		}
	}
}
