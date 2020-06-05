import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VideoToMp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int songNumber;
		String[] links;
		Scanner scn = new Scanner(System.in);
		boolean pageTurn = false;
		
		System.out.println("How many songs?");
		songNumber = scn.nextInt();
		links = new String[songNumber];
		
		for (int i = 0; i < songNumber; i++) {
			System.out.println("Paste the link");
			links[i] = scn.next();
		}
		
		for (int i = 0; i < links.length; i++) {
			try {
		         
		    	  System.setProperty("webdriver.chrome.driver", 
							"chromedriver.exe");
					WebDriver driver = new ChromeDriver();;
					try {
						
						driver.get("https://ytmp3.cc/");
						WebElement url = driver.findElement(By.id("input"));
						url.click();
						url.sendKeys(links[i]);
						WebElement convertForm = driver.findElement(By.id("submit"));
						convertForm.submit();
						Thread.sleep(1500);
						//WebElement download = driver.findElement(By.id("download"));
						//download.click();
						
					} catch (Exception e) {
						System.out.println("Thread " +  links[i] + " interrupted.");
					}
					
		    	  
		      } catch (Exception e) {
		         System.out.println("Thread " +  links[i] + " interrupted.");
		      }
		      System.out.println("Thread " +  links[i] + " exiting.");
		}
	}

}
