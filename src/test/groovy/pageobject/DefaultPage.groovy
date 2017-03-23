package pageobject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import utils.DriverFactory

class DefaultPage {

    protected static final Logger log = LoggerFactory.getLogger(DefaultPage.class)
    protected static final BASE_URL = "http://www.sportsdirect.com"

    protected WebDriver driver

    public DefaultPage() {
        driver = new DriverFactory().getDriver()
        PageFactory.initElements(driver, this)
    }

    public DefaultPage goToMainPage() {
        driver.get(BASE_URL)
        log.info "-main sportsdirect page opened: " + driver.currentUrl
        this
    }

    public ProductsListPage getProductList() {
        driver.get(BASE_URL + "/accessories/headphones-and-earphones")
        log.info "-get product list : " + driver.currentUrl
        new ProductsListPage()
    }

    public CartPage getCartPage() {
        driver.get(BASE_URL + "/Cart")
        log.info "-get cart view: " + driver.getCurrentUrl()
        new CartPage()
    }

}
