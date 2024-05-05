import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRunner extends Setup {

    @Test(priority = 1, description = "Select Product")
    public void searchProduct() throws InterruptedException {
        ProductScreen productScreen=new ProductScreen(driver);
        productScreen.selectProduct();
    }
    @Test(priority = 2, description = "Checkout product")
    public void checkoutProduct() throws InterruptedException {
        GuestInfoScreen guestInfoScreen=new GuestInfoScreen(driver);
        String actualMessage= guestInfoScreen.guestCheckout();
        String expectedMessage="Your order has been successfully processed!";
        Assert.assertTrue(expectedMessage.contains(actualMessage));
    }
}
