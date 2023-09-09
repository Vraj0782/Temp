package DataDriventexting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FeatchUrl {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		List<WebElement> el = driver.findElements(By.xpath("//a"));
		int count = el.size();
		System.out.println(count);
		for (WebElement att : el) {
			String at = att.getAttribute("href");
			FileInputStream fis = new FileInputStream("./excel/Urls.xlsx");  
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh1 = book.getSheet("Sheet2");
		for (int i = 0; i <count; i++) {
			Row r = sh1.createRow(i);
			Cell cl = r.createCell(0);
			cl.setCellValue(at);
		}
		FileOutputStream fot=new FileOutputStream("./excel/Urls.xlsx");
		book.write(fot);
		}
		;
		Thread.sleep(5000);
		driver.quit();
	}

}
                             