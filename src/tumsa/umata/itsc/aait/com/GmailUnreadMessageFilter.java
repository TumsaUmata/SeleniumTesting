package tumsa.umata.itsc.aait.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Done By: Tumsa Umeta
 * ID Number: ATR/7397/09
 *
 * ***/

public class GmailUnreadMessageFilter {
    public static void main(String[] args) throws InterruptedException, IOException{

        System.setProperty("webdriver.chrome.driver", "/home/tumsa/Documents/Libraries/chromedriver_linux64/chromedriver");

        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("http://mail.google.com");
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("tumsaumata2020@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
        Thread.sleep(10000);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        pass.click();
        pass.sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();

        Thread.sleep(1000);
        List<WebElement> unread = driver.findElements(By.xpath("//*[@class='zA zE']"));
        System.out.println(unread.size() + " Unread Messages");
        FileWriter fw = new FileWriter("gmail.txt");

        for (WebElement message: unread  ) {
            System.out.println(message.getText());
            fw.write(message.getText()+"\n");

        }
        fw.close();

        System.out.println("You can see your unread gmail in grade.txt");
    }
}
