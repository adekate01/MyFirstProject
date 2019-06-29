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

//Calling Login Test
WebUI.callTestCase(findTestCase('LoginLogoutTest/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('CreateTripPage/buttonMytrip'))

WebUI.click(findTestObject('CreateTripPage/buttonNewTrip'))

//Fetching trip name and location from excel
WebUI.sendKeys(findTestObject('CreateTripPage/TripName/input_TripName'), tripName)

WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('CreateTripPage/Location/input_TripLocation'), location)

WebUI.delay(2)

WebUI.sendKeys(findTestObject('CreateTripPage/Location/input_TripLocation'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.delay(2)

// Selecting from and to date		
WebUI.click(findTestObject('CreateTripPage/TripAll/DatePicker'))

WebUI.click(findTestObject('CreateTripPage/TripAll/FromDate'))

WebUI.click(findTestObject('CreateTripPage/TripAll/ToDate'))

WebUI.delay(2)

WebUI.click(findTestObject('CreateTripPage/label_Trip'))

not_run: WebUI.uploadFile(findTestObject('CreateTripPage/TripAll/UploadImage'), 'C:\\Users\\Windows\\Pictures\\Picture\\leh.jpg')

not_run: CustomKeywords.'utils.CustomUtilities.uploadFile'(findTestObject('CreateTripPage/TripAll/UploadImage'), 'C:\\Users\\Windows\\Pictures\\Picture\\leh.jpg')

// Add friend to trip	
WebUI.click(findTestObject('CreateTripPage/AddFriendToTrip'))

WebUI.click(findTestObject('CreateTripPage/buttonCreateTrip'))

// Verifying trip successfully created	
WebUI.verifyElementPresent(findTestObject('CreateTripPage/Location/div_Success'), 2)

//Fetching tripName from Excel
WebUI.setText(findTestObject('CreateActivityPage/Page_List Trips/input_SearchTrip'), tripName)

String expectedTripName = WebUI.getText(findTestObject('CreateTripPage/VerifyTripName'), FailureHandling.STOP_ON_FAILURE)

WebUI.comment(expectedTripName)

//Verifying the tripname in search box is equal to the tripname from list page
if (expectedTripName.equalsIgnoreCase(tripName)) {
    WebUI.comment('Trip Found.....')
} else {
    WebUI.comment('Trip Not Found .....')
}

