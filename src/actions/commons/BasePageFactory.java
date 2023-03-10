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

public class BasePageFactory {
    private long longTimeout = 30;

    public static BasePageFactory getBasePageOject(){
        return new BasePageFactory();
    }

    protected void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void openPageURL(WebDriver driver, String pageURL){
        driver.get(pageURL);
    }

    protected String getPageTitle (WebDriver driver){
        return driver.getTitle();
    }

    protected String getPageUrl (WebDriver driver){
        return driver.getCurrentUrl();
    }

    protected String getPageSource (WebDriver driver){
        return driver.getPageSource();
    }

    protected void backToPage (WebDriver driver){
        driver.navigate().back();
    }

    protected void forwardToPage (WebDriver driver){
        driver.navigate().forward();
    }

    protected void refreshCurrentPage (WebDriver driver){
        driver.navigate().refresh();
    }

    protected Alert waitForAlertPresence(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver){
        Alert alert = waitForAlertPresence(driver);
        alert.accept();
    }

    protected void cancelAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }

    protected String getAlertText(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }

    protected void sendKeysToAlert(WebDriver driver, String textValue) {
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    protected void switchToWindowById(WebDriver driver, String windowID){
            Set<String> allWindowIDs = driver.getWindowHandles();
            for (String id : allWindowIDs) {
                if (!id.contains(windowID)){
                    driver.switchTo().window(id);
                    sleepInSecond(2);
                }
            }
        }

    protected void switchToWindowByPageTitle (WebDriver driver, String expectedPageTitle) {
            Set<String> allWindowIDs = driver.getWindowHandles();
            for (String id : allWindowIDs) {
                driver.switchTo().window(id);
                String actualPageTitle = driver.getTitle();
                if(actualPageTitle.equals(expectedPageTitle)){
                    break;
                }
            }
        }

    protected void closeAllTabWithoutParent(WebDriver driver, String parentID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs){
            if (!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    private By getByXpath(String xpathLocator){
        return By.xpath(xpathLocator);
    }

    private WebElement getWebElement(WebDriver driver, String xpathLocator){
        return driver.findElement(getByXpath(xpathLocator));
    }

    private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator){
        return driver.findElements(getByXpath(xpathLocator));
    }

    protected void clickToElement(WebDriver driver, String xpathLocator){
        getWebElement(driver, xpathLocator).click();
    }

    protected void sendKeysToElement(WebDriver driver, String xpathLocator, String textValue){
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem){
        Select select = new Select(getWebElement(driver,xpathLocator));
        select.selectByValue(textItem);
    }

    protected String getFirstSelectedItem(WebDriver driver, String xpathLocator){
        Select select = new Select(getWebElement(driver,xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
        Select select = new Select(getWebElement(driver,xpathLocator));
        return select.isMultiple();
    }

    protected void selectItemInCustomDropDown(WebDriver driver, String parentXpath, String childXpath, String allItemCss, String expectedTextItem){
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

    protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName){
        return getWebElement(driver, xpathLocator).getAttribute(attributeName);
    }

    protected String getElementText(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).getText();
    }

    protected String getElementCss(WebDriver driver, String xpathLocator, String propertyName){
        return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }

    protected String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex();
    }

    protected int getElementSize(WebDriver driver, String xpathLocator){
        return getListWebElement(driver, xpathLocator).size();
    }

    protected void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator){
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()){
            element.click();
        }
    }

    protected void unCheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator){
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()){
            element.click();
        }
    }

    protected boolean isElementDisplayed(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).isDisplayed();
    }

    protected boolean isElementEnabled(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).isSelected();
    }

    protected void switchToFrameIframe(WebDriver driver, String xpathLocator){
        driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }

    protected void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    protected void hoverMouseToElement(WebDriver driver, String xpathLocator){
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    protected void doubleClickToElement(WebDriver driver, String xpathLocator){
        Actions action = new Actions(driver);
        action.doubleClick(getWebElement(driver, xpathLocator)).perform();
    }

    protected void rightClickToElement(WebDriver driver, String xpathLocator){
        Actions action = new Actions(driver);
        action.contextClick(getWebElement(driver, xpathLocator)).perform();
    }

    protected void dragAndDrop(WebDriver driver, String sourceXpathLocator, String targetXpathLocator){
        Actions action = new Actions(driver);
        action.dragAndDrop(getWebElement(driver, sourceXpathLocator), getWebElement(driver, targetXpathLocator)).perform();
    }

    protected void sendKeysBoardToElement(WebDriver driver, String xpathLocator, Keys key){
        WebElement element = getWebElement(driver, xpathLocator);
        Actions action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }

    protected void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    protected void highlightElement(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
    }

    protected void scrollToElement(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
    }

    protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
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

    protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(driver, xpathLocator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    protected void waitForElementVisible(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForAllElementsVisible(WebDriver driver, List<WebElement> elements){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected void waitForElementInvisible(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForAllElementsInvisible(WebDriver driver, List<WebElement> elements){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    protected void waitForElementClickable(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickToElement(WebDriver driver, WebElement element){
        element.click();
    }

    protected void sendKeysToElement(WebDriver driver, WebElement element, String textValue){
        element.clear();
        element.sendKeys(textValue);
    }

    protected String getElementText(WebDriver driver, WebElement element){
        return element.getText();
    }

    protected boolean isElementDisplayed(WebDriver driver, WebElement element){
        return element.isDisplayed();
    }

    protected boolean isElementEnabled(WebDriver driver, WebElement element){
        return element.isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, WebElement element){
        return element.isSelected();
    }

}
