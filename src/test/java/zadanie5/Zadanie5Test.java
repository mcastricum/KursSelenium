package zadanie5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

import java.util.List;

public class Zadanie5Test {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
//        driver.manage().window().maximize();
        // Przejdź do Bing
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }
    @Test
    public void testKatalonForm() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.id("first-name"));

        // Wpisz imie
        if(element.isEnabled()) {
            element.sendKeys("Karol");
        }else 	{
            Assert.fail();
        }
        System.out.println(element.getTagName() + " : " + element.getAttribute("value"));

        WebElement element1 = driver.findElement(By.id("last-name"));
        if(element1.isEnabled()) {
            element1.sendKeys("Kowalski");
         }else 	{
            Assert.fail();
        }
        System.out.println(element1.getTagName() + " : " + element1.getAttribute("value"));

//        WebElement radio1 = driver.findElement(By.name("gender"));
//
//        //Zaznacza pierszy radio
//        radio1.click();

//        WebElement genders = (WebElement) driver.findElements(By.name("gender"));
//
//        if(genders.isEnabled()) {
//            genders.click();
//        }else 	{
//            Assert.fail();
//        }
//        System.out.println(genders.getTagName() + " : " + element.getAttribute("value"));
        WebElement gender = driver.findElement(By.name("gender"));
        gender.click();
        System.out.println(gender.getTagName() + " : " + gender.getAttribute("value"));

        WebElement element3 = driver.findElement(By.id("dob"));
        if(element3.isEnabled()) {
            element3.sendKeys("5/22/2010");
        }else 	{
            Assert.fail();
        }
        System.out.println(element3.getTagName() + " : " + element3.getAttribute("value"));

        WebElement element4 = driver.findElement(By.id("address"));
        if(element4.isEnabled()) {
            element4.sendKeys("Prosta 51");
        }else 	{
            Assert.fail();
        }
        System.out.println(element4.getTagName() + " : " + element4.getAttribute("value"));

        WebElement element5 = driver.findElement(By.id("email"));
        if(element5.isEnabled()) {
            element5.sendKeys("karol.kowalski@mailinator.com");
        }else 	{
            Assert.fail();
        }
        System.out.println(element5.getTagName() + " : " + element5.getAttribute("value"));

        WebElement element6 = driver.findElement(By.id("password"));
        if(element6.isEnabled()) {
            element6.sendKeys("Pass123");
        }else 	{
            Assert.fail();
        }
        System.out.println(element6.getTagName() + " : " + element6.getAttribute("value"));

        WebElement element7 = driver.findElement(By.id("company"));
        if(element7.isEnabled()) {
            element7.sendKeys("Coders Lab");
          }else 	{
            Assert.fail();
        }
        System.out.println(element7.getTagName() + " : " + element7.getAttribute("value"));


        WebElement element8 = driver.findElement(By.id("comment"));
        if(element8.isEnabled()) {
            element8.sendKeys("To jest mój pierwszy automat testowy");
        }else 	{
            Assert.fail();
        }
        System.out.println(element8.getTagName() + " : " + element8.getAttribute("value"));


        // Prześlij formularz
        element.submit();
    }
//    @After
//    public void tearDown() throws Exception {
//        // Zamknij przeglądarkę
//       driver.quit();
//    }
}