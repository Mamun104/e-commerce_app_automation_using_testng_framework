import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GuestInfoScreen {
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etFirstName")
    WebElement txtFirstName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etLastName")
    WebElement txtLastName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etEmail")
    WebElement txtEmail;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/countrySpinner")
    WebElement btnSelectCountry;
    @FindBy(id = "android:id/text1")
    List<WebElement> btnCountryOrState;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/stateSpinner")
    WebElement btnSelectState;

    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")
    WebElement txtCompanyName;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etCity")
    WebElement txtCity;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")
    WebElement txtStreetAddress;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/etZipCode")
    WebElement txtZip;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue")
    WebElement btnContinue;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvShippingMethodDescription")
    List<WebElement> btnShippingMethod;
    @FindBy(id = "com.nopstation.nopcommerce.nopstationcart:id/tvPaymentMethodDetails")
    List<WebElement> btnPaymentMethod;
    //    @FindBy(id="com.nopstation.nopcommerce.nopstationcart:id/checkoutButton")
//    WebElement btnCheckout;
    AndroidDriver driver;

    public GuestInfoScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String guestCheckout() throws InterruptedException {
        txtFirstName.sendKeys("Test");
        txtLastName.sendKeys("User");
        txtEmail.sendKeys("testuser@test.com");
        btnSelectCountry.click();
        btnCountryOrState.get(2).click(); //select country
        btnSelectState.click();
        btnCountryOrState.get(1).click(); //select state
        txtCompanyName.sendKeys("TestCompany");
        txtCity.sendKeys("NY");
        txtStreetAddress.sendKeys("Test Road");

        Utils.swipe(driver, 560, 2024, 560, 726);

        txtZip.sendKeys("1212");
        btnContinue.click();
        btnShippingMethod.get(3).click();
        Utils.swipe(driver, 540, 2020, 540, 530);
        btnContinue.click();

        btnPaymentMethod.get(0).click();

        for (int i = 0; i < 4; i++) {
            Utils.swipe(driver, 560, 2024, 560, 726);
        }
        Thread.sleep(3000);
        driver.findElement(By.className("android.widget.Button")).click();
        btnContinue.click();
        driver.findElement(By.className("android.widget.Button")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Print\"]")).click();
        WebElement txtMessageElement = driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message"));
        return txtMessageElement.getText();

    }

}
