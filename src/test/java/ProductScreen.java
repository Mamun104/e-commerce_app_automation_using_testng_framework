import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductScreen {
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnAccept")
    WebElement btnAcceptAgreement;
    @FindBy(className = "android.widget.ImageView")
    List<WebElement> btnProductIcon;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/ivProductThumb")
    List<WebElement> btnProductSubItems;
    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart")
    WebElement btnAddtoCart;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/counterIcon")
    WebElement btnCounterIcon;
    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut")
    WebElement btnCheckout;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")
    WebElement btnGuestCheckOut;
    AndroidDriver driver;

    public ProductScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectProduct() throws InterruptedException {
        btnAcceptAgreement.click();
        btnProductIcon.get(1).click();

        Thread.sleep(1000);
        new TouchAction(driver)
                .longPress(PointOption.point(1018, 1006))
                .moveTo(PointOption.point(113, 1006))
                .release()
                .perform();
        Thread.sleep(1000);
        btnProductSubItems.get(3).click(); //click on electronics
        Thread.sleep(2000);
        new TouchAction(driver)
                .longPress(PointOption.point(550, 1920))
                .moveTo(PointOption.point(550, 650))
                .release()
                .perform();

        btnProductSubItems.get(3).click(); // Click on matress
        btnAddtoCart.click();
        btnCounterIcon.click();
        btnCheckout.click();
        btnGuestCheckOut.click();

    }

}
