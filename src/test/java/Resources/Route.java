package Resources;
import java.io.IOException;

import static Resources.Utils.getGlobalValue;
public class Route {


    private static final String LATESTRATES = "/latest";
    private static String SPECIFICDATERATES = null;
    static {
        try {
            SPECIFICDATERATES = getGlobalValue("date");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static final String INVALIDRATEURL = "/";

    public static String rates(){
        return LATESTRATES;
    }

    public static String specificDaterates(){
        return SPECIFICDATERATES;
    }

    public static String getInvalidrateurl(){
        return INVALIDRATEURL;
    }
}
