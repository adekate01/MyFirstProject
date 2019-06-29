import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

	// Calling Login test
	WebUI.callTestCase(findTestCase('LoginLogoutTest/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('CreateTripPage/buttonMytrip'))
	
	WebUI.click(findTestObject('CreateTripPage/buttonNewTrip'))
	
	//Fetching location name from excel	
	WebUI.sendKeys(findTestObject('CreateTripPage/Location/input_TripLocation'), selectLocation)
	
	WebUI.delay(2)
	
	//Selecting first suggested location from dropdown
	WebUI.sendKeys(findTestObject('CreateTripPage/Location/input_TripLocation'), Keys.chord(Keys.DOWN, Keys.ENTER))
	
	WebUI.delay(2)
	
	WebUI.click(findTestObject('CreateTripPage/label_Idea'))
	
	WebUI.delay(2)
	
	WebUI.click(findTestObject('CreateTripPage/Location/ChooseCoverPhoto'))
	
	not_run: WebUI.delay(4)
	
	not_run: WebUI.waitForElementClickable(findTestObject('CreateTripPage/Location/ChooseCoverPhoto'), 3)
	
	not_run: WebUI.sendKeys(findTestObject('CreateTripPage/Location/ChooseCoverPhoto'), Keys.chord(Keys.TAB))
	
	not_run: WebUI.sendKeys(findTestObject('CreateTripPage/Location/ChooseCoverPhoto'), Keys.chord(Keys.SPACE))
	
	WebUI.delay(2)
	
	//Clicking on Create trip button		
	WebUI.click(findTestObject('CreateTripPage/buttonCreateTrip'))
	
	//Verifying trip by location is successfully created		
	WebUI.verifyElementPresent(findTestObject('CreateTripPage/Location/div_Success'), 2)
	
	WebUI.closeBrowser()
	
