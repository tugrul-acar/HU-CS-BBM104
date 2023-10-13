import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static int maxerror;
    private static String title;
    private static String discountpercentage;
    private static int blocktime;
    public static void propertyreader() throws IOException {
        String path = "assets\\data\\properties.dat";
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
        maxerror = Integer.parseInt(properties.getProperty("maximum-error-without-getting-blocked"));
        title = properties.getProperty("title");
        discountpercentage = properties.getProperty("discount-percentage");
        blocktime = Integer.parseInt(properties.getProperty("block-time"));


    }

    public static int getBlocktime() {
        return blocktime;
    }

    public static int getMaxerror() {
        return maxerror;
    }

    public static String getDiscountpercentage() {
        return discountpercentage;
    }

    public static String getTitle() {
        return title;
    }
}
