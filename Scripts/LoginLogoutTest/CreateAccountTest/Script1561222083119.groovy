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

CustomKeywords.'utils.CustomUtilities.launchSite'()

WebUI.click(findTestObject('CreateAccountPage/Page_SignUp/a_Create an Account'))

WebUI.setText(findTestObject('CreateAccountPage/Page_SignUp/input__username'), findTestData('LoginCredential/CreateAccountTestData').getValue(
        1, 1))

WebUI.setText(findTestObject('CreateAccountPage/Page_SignUp/input__FirstName'), findTestData('LoginCredential/CreateAccountTestData').getValue(
        2, 1))

WebUI.setText(findTestObject('CreateAccountPage/Page_SignUp/input__LastName'), findTestData('LoginCredential/CreateAccountTestData').getValue(
        3, 1))

WebUI.setText(findTestObject('CreateAccountPage/Page_SignUp/input__emailID'), findTestData('LoginCredential/CreateAccountTestData').getValue(
        4, 1))

WebUI.setText(findTestObject('CreateAccountPage/Page_SignUp/input_Password'), findTestData('LoginCredential/CreateAccountTestData').getValue(
        5, 1))

WebUI.setText(findTestObject('CreateAccountPage/Page_SignUp/input__ConfirmPassword'), findTestData('LoginCredential/CreateAccountTestData').getValue(
        6, 1))

WebUI.click(findTestObject('Object Repository/CreateAccountPage/Page_SignUp/button_Submit'))

// Comment , wait after submittion

WebUI.verifyElementPresent(findTestObject('Object Repository/CreateAccountPage/Page_SignUp/div_user not created'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/CreateAccountPage/Page_SignUp/div_Error'), 2)

