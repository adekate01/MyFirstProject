
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String


def static "com.kms.katalon.keyword.uploadfile.UploadFile.uploadFile"(
    	TestObject object	
     , 	String file	) {
    (new com.kms.katalon.keyword.uploadfile.UploadFile()).uploadFile(
        	object
         , 	file)
}

def static "com.kms.katalon.keyword.uploadfile.UploadFile.uploadFileUsingRobot"(
    	TestObject object	
     , 	String file	) {
    (new com.kms.katalon.keyword.uploadfile.UploadFile()).uploadFileUsingRobot(
        	object
         , 	file)
}

def static "utils.CustomUtilities.launchSite"() {
    (new utils.CustomUtilities()).launchSite()
}

def static "utils.CustomUtilities.login"(
    	String userName	
     , 	String password	) {
    (new utils.CustomUtilities()).login(
        	userName
         , 	password)
}

def static "utils.CustomUtilities.uploadFile"(
    	TestObject to	
     , 	String filePath	) {
    (new utils.CustomUtilities()).uploadFile(
        	to
         , 	filePath)
}
