package com.rpg.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Google {

    private WebDriver mDriver;

    public Google(WebDriver driver){
        this.mDriver = driver;
        String baseurl = "https://www.google.co.in/?gws_rd=ssl";
        mDriver.get(baseurl);
        System.out.println(mDriver.getTitle());
        if (!mDriver.getTitle().equalsIgnoreCase("google")){
            throw new WrongPageException("Not Google");
        }
    }

    public TemperatureConversion navigateToTemperatureConversionPage(){
        mDriver.findElement(By.id("lst-ib")).clear();
        mDriver.findElement(By.id("lst-ib")).sendKeys("temperature converter fahrenheit to degrees celsius");
        mDriver.findElement(By.name("btnK")).click();
        WebDriverWait wait = new WebDriverWait(mDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        if (mDriver.getTitle().equals("temperature converter fahrenheit to degrees celsius - Google Search"))
            return new TemperatureConversion(mDriver);

        return null;
    }
}
