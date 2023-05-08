package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	ChromeOptions opt = new ChromeOptions();
	public static WebDriver driver;
	
	public void launchBrowser(String browser) 
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		if (browser.equals("chrome")) 
		{
			//opt.addArguments("--remote-allow-origins=*");
			opt.addArguments("incognito");
			driver = new ChromeDriver(opt);
		}
		else if (browser.equals("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public static String[][] readData() throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Amazon\\configuration.xlsx");
		Sheet dataSheet = WorkbookFactory.create(file).getSheet("ConfigData");
		int rowCount = dataSheet.getLastRowNum();
		short totalCell = dataSheet.getRow(rowCount).getLastCellNum();
		int cellCount = totalCell-1;
		
		String cellValue [][] = new String[rowCount+1][cellCount+1];
		
		for (int i = 0; i <= rowCount; i++) 
		{
			for (int j = 0; j <= cellCount; j++) 
			{
				cellValue[i][j] = dataSheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return cellValue;
	}
}
