package com.javaseleniumjunit.bases;

import com.javaseleniumjunit.Parametros;
import com.javaseleniumjunit.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.time.StopWatch;

public class PageBase  {
    protected WebDriverWait wait = null;
    protected WebDriver driver = null;
    protected JavascriptExecutor javaScriptExecutor = null;

    public  PageBase(){
        driver = DriverFactory.Instance;
        wait = new WebDriverWait(DriverFactory.Instance,3);
        javaScriptExecutor =(JavascriptExecutor)driver;
    }
    private void waitUntilPageReady(){
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= Parametros.TIMEOUT_DEFAULT)
        {
            String documentState = javaScriptExecutor.executeScript("return document.readyState").toString();
            if (documentState.equals("complete")){
                timeOut.stop();
                break;
            }
        }
    }

    protected WebElement waitForElement(By locator){
       // waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    protected WebElement waitForElementByTime(By locator, int time){
        waitUntilPageReady();
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        waitTime.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected WebElement waitForElementDisabled(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element;
    }

    protected WebElement expandShadowRootElement(By locator) {
        WebElement shadowRootElement = (WebElement) javaScriptExecutor.executeScript("return arguments[0].shadowRoot", waitForElement(locator));
        return shadowRootElement;
    }

    protected void click(By locator){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= Parametros.TIMEOUT_DEFAULT)
        {
            WebElement element = null;

            try
            {
                element = waitForElement(locator);
                element.click();
                timeOut.stop();
            //    ExtentReportUtils.addTestInfo(3, "");
                return;
            }

            catch (StaleElementReferenceException e)
            {
                continue;
            }

            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click"))
                {
                    continue;
                }

                throw e;
            }
        }

        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void sendKeys(By locator, String text){
        waitForElement(locator).sendKeys(text);
       // ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }



}
