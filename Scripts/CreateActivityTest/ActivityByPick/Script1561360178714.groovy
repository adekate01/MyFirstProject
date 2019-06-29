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

WebUI.delay(3)

//Fetching tripName from excel on which activity needs to be created
WebUI.setText(findTestObject('CreateActivityPage/Page_List Trips/input_SearchTrip'), tripName)

WebUI.delay(2)

WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/ClickOnSearchedTrip'))

WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/SelectTimeForActivity'))

// Activity Type is "Pick"
WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/PickActivity'))

WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/EndTimeForActivityByPick'))

WebUI.sendKeys(findTestObject('CreateActivityPage/Page_List Trips/EndTimeForActivityByPick'), Keys.chord(Keys.ARROW_LEFT, 
        Keys.ARROW_UP))

WebUI.click(findTestObject('CreateActivityPage/Page_List Trips/SelectQuickPick'))

