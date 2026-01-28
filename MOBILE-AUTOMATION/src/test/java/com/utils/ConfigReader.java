package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties pf;
    private static void loadProp()
    {
        pf = new Properties();
        try {
            FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");

            pf.load(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static String getPropert(String key){
        if(pf==null)
        {
           loadProp();
        }
        return pf.getProperty(key);
    }
}
