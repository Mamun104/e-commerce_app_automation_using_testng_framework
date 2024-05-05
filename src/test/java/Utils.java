import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Utils {
    public static void swipe(AndroidDriver driver, int startX, int startY, int endX, int endY){
        new TouchAction(driver)
                .longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}
