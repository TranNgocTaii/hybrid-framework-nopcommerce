package actions.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {
    private long longTimeout = 30;

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void openPageURL(WebDriver driver, String pageURL){
        driver.get(pageURL);
    }

    public String getPageTitle (WebDriver driver){
        return driver.getTitle();
    }

    public String getPageUrl (WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSource (WebDriver driver){
        return driver.getPageSource();
    }

    public void backToPage (WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage (WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshCurrentPage (WebDriver driver){
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        Alert alert = waitForAlertPresence(driver);
        alert.accept();
    }

    public void cancelAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }

    public void sendKeysToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    public void switchToWindowById(WebDriver driver, String windowID){
            Set<String> allWindowIDs = driver.getWindowHandles();
            for (String id : allWindowIDs) {
                if (!id.contains(windowID)){
                    driver.switchTo().window(id);
                    sleepInSecond(2);
                }
            }
        }

    public void switchToWindowByPageTitle (WebDriver driver, String expectedPageTitle) {
            Set<String> allWindowIDs = driver.getWindowHandles();
            for (String id : allWindowIDs) {
                driver.switchTo().window(id);
                String actualPageTitle = driver.getTitle();
                if(actualPageTitle.equals(expectedPageTitle)){
                    break;
                }
            }
        }

    public void closeAllTabWithoutParent(WebDriver driver, String parentID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    public By getByXpath(String xpathLocator){
        return By.xpath(xpathLocator);
    }

    public WebElement getWebElement(WebDriver driver, String xpathLocator){
        return driver.findElement(getByXpath(xpathLocator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator){
        return driver.findElements(getByXpath(xpathLocator));
    }

    public void clickToElement(WebDriver driver, String xpathLocator){
        getWebElement(driver, xpathLocator).click();
    }

    public void sendKeysToElement(WebDriver driver, String xpathLocator, String textValue){
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem){
        Select select = new Select(getWebElement(driver,xpathLocator));
        select.selectByValue(textItem);
    }

    public String getFirstSelectedItem(WebDriver driver, String xpathLocator){
        Select select = new Select(getWebElement(driver,xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
        Select select = new Select(getWebElement(driver,xpathLocator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropDown(WebDriver driver, String parentXpath, String childXpath, String allItemCss, String expectedTextItem){
        getWebElement(driver, parentXpath).click();
        sleepInSecond(1);

        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
        for (WebElement item : allItems){
            if (item.getText().trim().equals(expectedTextItem)){
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }
    }

    public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName){
        return getWebElement(driver, xpathLocator).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).getText();
    }

    public String getElementCss(WebDriver driver, String xpathLocator, String propertyName){
        return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(WebDriver driver, String xpathLocator){
        return getListWebElement(driver, xpathLocator).size();
    }

    public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator){
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()){
            element.click();
        }
    }

    public void unCheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator){
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()){
            element.click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).isDisplayed();
    }

    public boolean isElementEnabled(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).isSelected();
    }

    public void switchToFrameIframe(WebDriver driver, String xpathLocator){
        driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }

    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String xpathLocator){
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String xpathLocator){
        Actions action = new Actions(driver);
        action.doubleClick(getWebElement(driver, xpathLocator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String xpathLocator){
        Actions action = new Actions(driver);
        action.contextClick(getWebElement(driver, xpathLocator)).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceXpathLocator, String targetXpathLocator){
        Actions action = new Actions(driver);
        action.dragAndDrop(getWebElement(driver, sourceXpathLocator), getWebElement(driver, targetXpathLocator)).perform();
    }

    public void sendKeysBoardToElement(WebDriver driver, String xpathLocator, Keys key){
        WebElement element = getWebElement(driver, xpathLocator);
        Actions action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
    }

    public void scrollToElement(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(driver, xpathLocator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementsVisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }

    public void waitForElementInvisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementsInvisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
    }

}
