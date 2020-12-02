package zadanie4;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;

import java.util.List;
import java.util.Random;

public class Zadanie4Test {

    private WebDriver driver;

    private String getRandomFn (){
        String[] firstname = {"Antoni","Jan", "Jakub", "Aleksander", "Franciszek"};
        Random random = new Random();
        int randomInteger = random.nextInt(firstname.length);
        return firstname[randomInteger];

    }
    private String getRandomLn (){
        String[] lastname = {"Kowalski", "Nowak", "Kozlowski", "Kowalczyk", "Lewandowksi"};
        Random random = new Random();
        int randomInteger = random.nextInt(lastname.length);
        return lastname[randomInteger];

    }

    private String getRandomPass (){
        String[] password = {"Password123", "Password223", "Password323", "Password423",};
        Random random = new Random();
        int randomInteger = random.nextInt(password.length);
        return password[randomInteger];

    }
    private String getRandomDob (){
        String[] dob = {"01/01/1991", "02/02/1992", "03/03/1993", "04/04/1994", "05/05/1995","06/06/1996"};
        Random random = new Random();
        int randomInteger = random.nextInt(dob.length);
        return dob[randomInteger];

    }

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
//        driver.manage().window().maximize();
        // Przejdź do Bing
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
    }
    @Test
    public void testPrestaNewUser() {
        //        WebElement radio1 = driver.findElement(By.name("gender"));
//
//        //Zaznacza pierszy radio
//        radio1.click();

        List<WebElement> genders = driver.findElements(By.name("id_gender"));
        genders.get(0).click();

        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement imie = driver.findElement(By.name("firstname"));
        // Wyczyść teskst zapisany w elemencie
        imie.clear();

        // Wpisz imie
        imie.sendKeys(getRandomFn());

        WebElement nazwisko = driver.findElement(By.name("lastname"));
        // Wyczyść teskst zapisany w elemencie
        nazwisko.clear();

        // Wpisz nazwisko
        nazwisko.sendKeys(getRandomLn());


        WebElement email = driver.findElement(By.name("email"));
        // Wyczyść teskst zapisany w elemencie
        email.clear();

        // Wpisz date urodzenia
        email.sendKeys("test"+System.currentTimeMillis()+"@gmail.com");


        WebElement element5 = driver.findElement(By.name("password"));
        // Wyczyść teskst zapisany w elemencie
        element5.clear();

        // Wpisz adres
        element5.sendKeys(getRandomPass());

        WebElement dob = driver.findElement(By.name("birthday"));
        // Wyczyść teskst zapisany w elemencie
        dob.clear();

        // Wpisz adres
        dob.sendKeys(getRandomDob());

        // Prześlij formularz
        imie.submit();
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
       driver.quit();
    }
}