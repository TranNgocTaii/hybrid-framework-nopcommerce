package javaTester.javaBasic;

public class Topic_14_StringFormat {
    public static  String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
    public static  String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
    public static  String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
    public static  String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
    public static  String DYNAMIC_SIDEBAR_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']";

    public static  String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";


    public static void main (String[] args){
        clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME,"Reward points");
        clickToLink(DYNAMIC_SIDEBAR_BY_PAGE_NAME,"Customer info");

        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME,"account-navigation","My product reviews");
        clickToLink(DYNAMIC_LINK_BY_PAGE_NAME,"header-upper","My-account");

    }


/*    // 1 tham so dong.
    public static void clickToLink(String dynamicLocator, String pageName){
        String locator = dynamicLocator.format(dynamicLocator, pageName);
        System.out.println("click to " + locator);
    }

    // 2 tham so dong
    public static void clickToLink(String dynamicLocator, String areaName, String pageName){
        String locator = dynamicLocator.format(dynamicLocator, areaName, pageName);
        System.out.println("click to " + locator);
    }*/

    // 3 tham so dong
    public static void clickToLink(String dynamicLocator,String...params){
        String locator = dynamicLocator.format(dynamicLocator, (Object[]) params);
        System.out.println("click to " + locator);
    }
}
