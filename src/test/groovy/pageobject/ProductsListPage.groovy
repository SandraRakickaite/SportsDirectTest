package pageobject

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import utils.DriverFactory

class ProductsListPage extends DefaultPage {

    @FindBy(xpath = "//*[@id=\"dnn_ctr51055_BrowseV3View_lstProducts_liItem_0\"]/div/div[1]/a[1]")
    private WebElement firstItemFromProductsList

    @FindBy(xpath = "//*[@id=\"dnn_ctr51055_BrowseV3View_lstProducts_liItem_1\"]/div/div[1]/a[2]")
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
