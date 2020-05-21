package Resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static RequestSpecification req;
    JsonPath js;

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\Resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response, String key){
        String responseString = response.asString();
        js = new JsonPath(responseString);
        return js.get(key).toString();
    }

}
