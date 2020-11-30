package zadanie2;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class Zadanie2Test {
    private WebDriver driver;

    private String getRandomProduct (){
        String[] products = {"mug", "t-shirt", "notebook", "sweater", "poster","cushion", "vector", "graphics", "pack"};
        Random random = new Random();
        //losuje liczby z przedziału 0 - 49
        int randomInteger = random.nextInt(products.length);
        return products[randomInteger];

    }

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
//        driver.manage().window().maximize();
        // Przejdź do PrestaShop
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }
    @Test
    public void testPrestaSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("s"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(getRandomProduct());

        // Prześlij formularz
        element.submit();
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
//        driver.quit();
    }
}
