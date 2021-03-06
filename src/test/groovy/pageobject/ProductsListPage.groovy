package pageobject

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import utils.DriverFactory

class ProductsListPage extends DefaultPage {

    @FindBy(xpath = "//*[@li-productid=\"75502290\"]/div/div[1]/a[1]")
    private WebElement firstItemFromProductsList

    @FindBy(xpath = "//*[@li-productid=\"75502291\"]/div/div[1]/a[2]")
    private WebElement secondItemFromProductsList

    public ProductsListPage() {
        driver = new DriverFactory().getDriver()
        PageFactory.initElements(driver, this)
    }

    public ItemPage chooseFirstItem() {
        firstItemFromProductsList.click()
        log.info "-first item page opened"
        new ItemPage()
    }

    public ItemPage chooseSecondItem() {
        secondItemFromProductsList.click()
        log.info "-second item page opened"
        new ItemPage()
    }
}
