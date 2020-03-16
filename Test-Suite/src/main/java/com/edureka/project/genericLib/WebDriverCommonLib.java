package com.edureka.project.genericLib;

import java.util.Random;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {

    /**
     * @author Gautham
     */
    public static WebDriver driver;
    public WebDriverWait wait;
    public static final int MAX_NUMBER = 999999;

    /**
     * This Method is used to wait for the button to be clickable in UI and then try to click for evey 500ms until it clicks or less that 20 seconds. Use it
     * when Explcit Wait fails.
     * 
     * @param expElement
     * @throws InterruptedException
     */
    public void waitAndClickElement(WebElement expElement) throws InterruptedException {
        int count = 0;
        while (count <= 20) {
            try {
                expElement.click();
                break;
            } catch (Throwable t) {
                Thread.sleep(500);
            }

        }
    }

    /**
     * This Method is used to wait for the free text to be enabled in UI and then try to enter text for evey 500ms until it clicks or less that 20 seconds. Use
     * it when Explcit Wait fails.
     * 
     * @param expElement
     * @param data
     * @throws Throwable
     */
    public void waitAndTypeElement(WebElement expElement, String data) throws Throwable {
        int count = 0;
        while (count <= 20) {
            try {
                expElement.sendKeys(data);
                break;
            } catch (Throwable t) {

                Thread.sleep(500);

            }
        }
    }

    /**
     * 
     * @param expElement
     * @param data
     * @param tf
     */
    public void typeElement(WebElement expElement, String data, Boolean tf) {
        if (tf) {
            expElement.sendKeys(data);
        } else {
            expElement.getText();
            System.out.println(expElement.getText());
        }
    }
    

    /**
     * Creates a random number which is used to identify your material.
     * 
     * @return
     */
    public int randomNum() {
        Random randomNum = new Random();
        return randomNum.nextInt(MAX_NUMBER);

    }

    /**
     * This Method is used to wait for the free text to be enabled in UI and then try to enter text for evey 500ms until it is filled or less that 20 seconds.
     * Use it when Explcit Wait fails.
     * 
     * @param expElement
     * @param data
     * @throws Throwable
     */
    public void waitAndTypeElementEnter(WebElement expElement, String data) throws Throwable {
        int count = 0;
        while (count <= 20) {
            try {
                expElement.sendKeys(data, Keys.ENTER);
                break;
            } catch (Throwable t) {

                Thread.sleep(500);

            }
        }
    }

    /**
     * This method is used to select value under select dropdown using text value
     * 
     * @param element
     * @param text
     */
    public void select(WebElement element, String text) {
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    /**
     * This method is used to select value under select dropdown using index value
     * 
     * @param element
     * @param index
     */
    public void select(WebElement element, int index) {
        Select selectElement = new Select(element);
        selectElement.getOptions();
    }
}
