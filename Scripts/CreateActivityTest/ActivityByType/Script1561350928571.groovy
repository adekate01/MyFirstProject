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


//Calling Login test
WebUI.callTestCase(findTestCase('LoginLogoutTest/LoginTest'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('CreateTripPage/buttonMytrip'))

WebUI.delay(3)

// fetching tripName from excel on which activity needs to be created
WebUI.setText(findTestObject('CreateActivityPage/Page_List Trips/input_SearchTrip'), tripName)

WebUI.delay(2)

WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/ClickOnSearchedTrip'))

//Selecting time for the activity
WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/SelectTimeForActivity'))


// Activity type is Type
WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/TypeActivity'))

WebUI.setText(findTestObject('CreateActivityPage/Page_List Trips/input_NameOfActivity'), 'Lunch')

WebUI.sendKeys(findTestObject('CreateActivityPage/Page_List Trips/input_AddressOfActivity'), 'Kerela')

WebUI.delay(2)

WebUI.sendKeys(findTestObject('CreateActivityPage/Page_List Trips/input_AddressOfActivity'), Keys.chord(Keys.DOWN, Keys.ENTER))

// Selecting Endtime by increasing 1 hr from start time

WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/EndTimeForActivityByType'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('CreateActivityPage/Page_List Trips/EndTimeForActivityByType'), Keys.chord(Keys.ARROW_LEFT, 
        Keys.ARROW_UP))

WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/button_SaveActivity'))


//Checking the Success Message once activity is successfully created
WebUI.verifyElementPresent(findTestObject('CreateActivityPage/Page_List Trips/ActivitySuccMsg'), 0)

