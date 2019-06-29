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

//Calling Login Test
WebUI.callTestCase(findTestCase('LoginLogoutTest/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('CreateTripPage/buttonMytrip'))

WebUI.delay(2)

//Click on New Trip button
WebUI.click(findTestObject('CreateTripPage/buttonNewTrip'))

WebUI.delay(2)

// Fetching Trip Name from Excel sheet
WebUI.sendKeys(findTestObject('CreateTripPage/TripName/input_TripName'), findTestData('CreateTrip/TripInfoTestData').getValue(
        3, 1))

WebUI.click(findTestObject('CreateTripPage/label_Idea'))

WebUI.delay(3)

WebUI.click(findTestObject('CreateTripPage/buttonCreateTrip'))

WebUI.delay(1)

//Verifying Success msg is shown
WebUI.verifyElementPresent(findTestObject('CreateTripPage/TripName/div_Success'), 1)

//Verifying List Trip Page is Open
WebUI.getWindowTitle()


//moving to idea list tab
WebUI.click(findTestObject('CreateTripPage/IdeaLink'))

WebUI.delay(3)

//Fetching tripName from Excel  
WebUI.setText(findTestObject('CreateActivityPage/Page_List Trips/input_SearchTrip'), ideaName)

String expectedIdeaName = WebUI.getText(findTestObject('CreateTripPage/VerifyTripName'), FailureHandling.STOP_ON_FAILURE)

WebUI.comment(expectedIdeaName)

// Verifying the tripname in search box is equal to the tripname from list page
if (expectedIdeaName.equalsIgnoreCase(ideaName)) {
    WebUI.comment('Idea Found.....')
} else {
    WebUI.comment('Idea Not Found')
}

not_run: CustomKeywords.'utils.CustomUtilities.uploadFile'(findTestObject('CreateTripPage/TripAll/UploadImage'), 'C:\\Users\\Windows\\Pictures\\Picture\\leh.jpg')

