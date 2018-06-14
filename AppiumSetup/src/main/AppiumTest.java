package main;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {
	
	public static void main(String[] args) {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "S7M7N16623000789"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("appPackage", "com.inditex.ecommerce.bershka.test"); // Put the application here
		caps.setCapability("appActivity", "es.sdos.sdosproject.ui.splash.activity.LaunchActivity"); //Put Activity here
		caps.setCapability("noReset", "true");
		
		//Instantiate Appium Driver
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);		
				Thread.sleep(8000);
				
				Dimension dim = driver.manage().window().getSize();
				int width = (int) (dim.getWidth()/2);
				int start = (int) (dim.height*0.80);
				int end = (int) (dim.height*0.05);
				
				new TouchAction(driver).press(width,start).waitAction(Duration.ofMillis(2000)).moveTo(width,end).release().perform();
				Thread.sleep(1000);
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/category_list.row_image")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//android.widget.LinearLayout[@index = '3']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//android.widget.LinearLayout[@index = '7']")).click();
				Thread.sleep(2000);
				new TouchAction(driver).press(width,start).waitAction(Duration.ofMillis(2000)).moveTo(width,end).release().perform();
				driver.findElement(By.xpath("//android.widget.LinearLayout[@index = '4']")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/product_detail.add")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//android.widget.LinearLayout[@index = '4']")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/size.add")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/toolbar.icon")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/cart.next")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//android.widget.RelativeLayout[@index = '2']")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/my_info.update_primary_address")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/policy_check")).click();
				driver.findElement(By.id("com.inditex.ecommerce.bershka.test:id/order_summary.confirm_button")).click();
				
				System.out.println("HE ACABADO");
				
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 
}