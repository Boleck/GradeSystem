package utils;

import java.net.URL;

public class Utils {



    public static URL getLayout(String layoutName){
        return Utils.class.getResource("layouts/" + layoutName);
    }

    public static String getLayoutFolder() {
        return "layouts/";
    }
}
