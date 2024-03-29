package tumsa.umata.itsc.aait.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;

/**
 * Done By: Tumsa Umeta
 * ID Number: ATR/7397/09
 *
 * ***/

public class PortalGradeFilter {
    public static void main(String[] args)  {

        String id = "myPortalUsername";
        String password ="myPortalPassword";
        System.setProperty("webdriver.chrome.driver", "/home/tumsa/Documents/Libraries/chromedriver_linux64/chromedriver");

        WebDriver driver;
        driver = new ChromeDriver();

        driver.get("http://portal.aait.edu.et");
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys(id);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div[2]/form/div[4]/div/button\n")).submit();
        driver.get("https://portal.aait.edu.et/Grade/GradeReport\n");

        String grade = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div")).getText();

        try{
            FileWriter fw=new FileWriter("grade.txt");
            fw.write(grade);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("You can see your grades in grade.txt");
    }
}
