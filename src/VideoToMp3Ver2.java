import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VideoToMp3Ver2 {
	private static Scanner inFile1;
	private Thread t;
	private String threadName;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int songNumber;
		String skipButton = "Skip this page (no tags)";
		Scanner scn = new Scanner(System.in);
		boolean pageTurn = false;

		String[] links = new String[1000];
		String[] temp = new String[0];

		// delete
		try {
			inFile1 = new Scanner(new File("downloadLink.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		int i = 0;
		while (inFile1.hasNextLine()) {
			links[i] = inFile1.nextLine();
			i++;
		}
		temp = new String[i];
		for (int j = 0; j < i; j++) {
			temp[j] = links[j];
		}

		links = temp;
		inFile1.close();

		for (i = 0; i < links.length; i++) {
			try {

				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				;
				try {

					driver.get("https://ytmp3.cc/");
					WebElement url = driver.findElement(By.id("input"));
					url.click();
					url.sendKeys(links[i]);
					WebElement convertForm = driver.findElement(By.id("submit"));
					convertForm.submit();
					Thread.sleep(1500);
					// WebElement download = driver.findElement(By.id("download"));
					// download.click();

				} catch (Exception e) {
					System.out.println("Thread " + links[i] + " interrupted.");
				}

			} catch (Exception e) {
				System.out.println("Thread " + links[i] + " interrupted.");
			}
			System.out.println("Thread " + links[i] + " exiting.");
		}

	}

}
