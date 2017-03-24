package pageobject

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import utils.DriverFactory

import static org.assertj.core.api.Assertions.*;

class CartPage extends DefaultPage{

    @FindBy(xpath = "//*[@id=\"dnn_ctr28633746_ViewBasket_BasketDetails_gvBasketDetails\"]/table/tbody/tr[1]/td[4]/div/a[2]")
    private WebElement firstProductInstanceCount

    @FindBy(xpath = "//*[@id=\"dnn_ctr28633746_ViewBasket_BasketDetails_lbtnUpdateQtyAndVariants\"]")
    private  WebElement updateBagBtn

    @FindBy(xpath = "//*[@id=\"dnn_ctr28633746_ViewBasket_BasketDetails_gvBasketDetails\"]/table/tbody/tr[1]/td[6]/span[2]")
    private static WebElement firstCostHolder
    
    @FindBy(xpath = "//*[@id=\"dnn_ctr28633746_ViewBasket_BasketDetails_gvBasketDetails\"]/table/tbody/tr[2]/td[6]/span[2]")
    private static WebElement secondCostHolder

    @FindBy(id = "BasketSummarySubtotalValue")
    private static WebElement totalCostHolder

    public CartPage() {
        driver = new DriverFactory().getDriver()
        PageFactory.initElements(driver, this)
    }

    public CartPage increaseFirstProductInstance() {
        firstProductInstanceCount.click()
        updateBagBtn.click()
        log.info "-first item count increased, bag updated"
        this
    }

    static double getActualTotalCost() {
        getCostOf(firstCostHolder)+getCostOf(secondCostHolder)
    }

    static void checkIfTotalCostIsCorrect() {
        log.info "-sum of all items: " + getActualTotalCost()
        log.info "-total cost displayed: " + getCalculatedTotalCost()
        assertThat(getActualTotalCost()).isEqualTo(getCalculatedTotalCost())
    }

    private static double getCalculatedTotalCost() {
        new BigDecimal(getCostOf(totalCostHolder))
    }

    private static double getCostOf(WebElement holder) {
        String str = holder.getText().substring(0)
        String replStr = str.replace(",", ".")
        String remStr = replStr.replace("[^0-9.]","")
        remStr as double
    }
}
