package library;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class UtilityScreenShot {
			
	public static void captureScreenShot(WebDriver driver, String Screenshot ) {
	try {	
	TakesScreenshot scnShot = (TakesScreenshot)driver;
	java.io.File Scrn = scnShot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(Scrn, new java.io.File ("./ScreenShots/"+Screenshot+".png"));
	System.out.println("ScreenShot Taken");
	}
	catch(Exception e){
		System.out.println("Exception while taking screenshot"+e.getMessage());
		
	}
	}

}
