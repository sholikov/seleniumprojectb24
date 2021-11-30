package com.cybertek.practiceassignments;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarsDotComUserCarSearchTest {

    String url = "https://www.cars.com";
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

  //  @AfterMethod
  //  public void tearDown() {
   //     driver.close();
  //  }

    @Test(priority = 1)
    public void defaultValuesTest() {
        //assert title equals “New Cars, Used Cars, Car Dealers, Prices & Reviews | cars.com"
        String expectedTitle = "New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        //assert cars.com icon is displayed
        WebElement icon = driver.findElement(By.xpath("//img[@alt='Cars.com Homepage']"));
        Assert.assertEquals(true, icon.isDisplayed());

//e and assert selected values of all 5 drop downs (can use
//getFirstSelectedOption().getText()):
        Select usedCar = new Select(driver.findElement(By.id("make-model-search-stocktype")));
        String firstSelected = usedCar.getFirstSelectedOption().getText();
        Assert.assertEquals(firstSelected, "New & used cars");

        Select make = new Select(driver.findElement(By.id("makes")));
        String secondSelected = make.getFirstSelectedOption().getText();
        Assert.assertEquals(secondSelected, "Mitsubishi");

        Select model = new Select(driver.findElement(By.name("models[]")));
        String thirdSelected = model.getFirstSelectedOption().getText();
        Assert.assertEquals(thirdSelected, "Outlander");

        Select price = new Select(driver.findElement(By.id("make-model-max-price")));
        String fourthSelected = price.getFirstSelectedOption().getText();
        Assert.assertEquals(fourthSelected, "No max price");

        Select distance = new Select(driver.findElement(By.id("make-model-maximum-distance")));
        String fifthSelected = distance.getFirstSelectedOption().getText();
        Assert.assertEquals(fifthSelected, "20 miles");

        //t value in zip code field equals 22039 (please change zip code according to what
        //shows up for you)
        WebElement zipCode = driver.findElement(By.id("make-model-zip"));
        zipCode.clear();
        String zip = "22039";
        zipCode.sendKeys(zip);
        Assert.assertEquals(22039, Integer.parseInt(zip));

    }

    @Test(priority = 2)
    public void usedTeslaSearchTest() throws InterruptedException {
        Select usedCar = new Select(driver.findElement(By.id("make-model-search-stocktype")));
        usedCar.selectByVisibleText("Used cars");

        Select make = new Select(driver.findElement(By.id("makes")));
        make.selectByValue("tesla");

        Select model = new Select(driver.findElement(By.name("models[]")));
        model.selectByVisibleText("Model 3");

        Select price = new Select(driver.findElement(By.id("make-model-max-price")));
        price.selectByValue("50000");

        Select distance = new Select(driver.findElement(By.id("make-model-maximum-distance")));
        distance.selectByVisibleText("200 miles");

        WebElement zipCode = driver.findElement(By.id("make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("22102");

        Thread.sleep(1234);

        driver.findElement(By.xpath("//button[.='Search']")).click();
        //t the main page header contains “Tesla Model 3”
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']")).getText().contains("Tesla Model 3"));
        //assert results count is more than 200 and less than 500 matches
        WebElement count = driver.findElement(By.xpath("(//span[@class='total-filter-count'])[2]"));
        String resultCount = count.getText();
        resultCount = resultCount.substring(0, 3);
        int numberCount = Integer.parseInt(resultCount);
        Assert.assertTrue(numberCount > 200 && numberCount < 500);
        //rt that Model 3 checkbox is checked (isSelected() )
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='model_tesla-model_3']")).isSelected());
        // that Model S checkbox is available and Not checked
        WebElement modelS = driver.findElement(By.xpath("//label[@for='model_tesla-model_s']"));
        Assert.assertTrue(modelS.isDisplayed());
        Assert.assertTrue(!modelS.isSelected());

    }

    @Test(priority = 3)
    public void usedTeslaAdvancedSearchTest() throws InterruptedException {

        driver.findElement(By.linkText("Advanced search")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Advanced search");
        driver.findElement(By.xpath("//div[@id='active_filter_tags']//span[contains(text(),'Clear all')]")).click();
        WebElement newSearch = driver.findElement(By.name("maximum_distance"));
        Select advanced = new Select(newSearch);
        advanced.selectByValue("500");

        WebElement zip=driver.findElement(By.name("zip"));
        zip.clear();
        zip.sendKeys("22102");


        Select used = new Select(driver.findElement(By.id("desktop-stock-type-select")));
        used.selectByVisibleText("Used");

        Select make = new Select(driver.findElement(By.id("desktop-make_select")));
        make.selectByValue("tesla");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        List<WebElement> models = driver.findElements(By.xpath("//div[@id='input-wrapper-desktop-models']//div//label"));
        for (WebElement eachModel : models) {
                eachModel.click();
           }
        driver.findElement(By.xpath("//button[@class='sds-button desktop-form-button']")).click();
        //assert that current Url contains “zip=22102”
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("zip=22102"));

        //assert that default selected Sort by value is “Best match"
        Select bestMatch = new Select(driver.findElement(By.id("sort-dropdown")));
        Assert.assertEquals(bestMatch.getFirstSelectedOption().getText(),"Best match");

        //assert “Lowest price” option
        bestMatch.selectByValue("list_price");

      //  String currentTitle = driver.findElement(By.tagName("h2")).getText();
       // System.out.println(currentTitle);
        driver.findElement(By.xpath("//div[@id='96bc27bb-e28e-4d89-b46b-119fbe04601b']//a[@class='vehicle-card-link js-gallery-click-link']")).click();
        String currentTitle = driver.findElement(By.xpath("//div[@class='title-section']//h1[@class='listing-title']")).getText();
        System.out.println("Current car Title = " + currentTitle);
        String carMlg = driver.findElement(By.xpath("//div[@class='title-section']//div[@class='listing-mileage']")).getText();
        System.out.println("Current car mileage = " + carMlg);
        String price = driver.findElement(By.xpath("//header[@role='presentation']//div[contains(@class,'price-section')]")).getText();
        System.out.println("price = " + price);




        }



    }
