package com.cybertek.tests.day19_page_object_model;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {
    @Test
    public void guru99DragAndDropTest(){

        driver.get(ConfigurationReader.getProperty("dragadndrop.url"));
        WebElement bank = driver.findElement(By.linkText("BANK"));
        WebElement accountType = driver.findElement(By.id("bank"));

        actions.dragAndDrop(bank,accountType).perform();

        WebElement fiveK = driver.findElement(By.linkText("5000"));
        BrowserUtils.sleep(2);
        WebElement bankAmount = driver.findElement(By.id("amt7"));
      //  actions.dragAndDropBy(fiveK,768,352).perform();
        actions.dragAndDrop(fiveK,bankAmount).perform();

    }
    @Test
    public void cargurusPriceSliderTest() {
        driver.get(ConfigurationReader.getProperty("cargurus.url")+"/Cars/inventorylisting/viewDetailsFilterViewInventoryListing.action?sourceContext=carGurusHomePageModel&entitySelectingHelper.selectedEntity=d177&zip=22102");

        WebElement priceSlider = driver.findElement(By.xpath("(//div[@class='Qqdum9'])[1]"));
        int x= priceSlider.getLocation().getX();
        int y= priceSlider.getLocation().getY();

        actions.dragAndDropBy(priceSlider,100,0).perform();
    }
}
