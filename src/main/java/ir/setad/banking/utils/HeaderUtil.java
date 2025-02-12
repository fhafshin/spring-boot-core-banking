package ir.setad.banking.utils;

import org.springframework.http.HttpHeaders;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class HeaderUtil {


    public static HttpHeaders createEntityCreationAlert(String applicationName, boolean enableTranslation, String entityName, String param) {

        String message = enableTranslation ? applicationName + "." + entityName + ".created" : " a new " + entityName + " is created with identifier" + param;


        return createHeader(applicationName,enableTranslation,message,param);
    }


    public static HttpHeaders createHeader(String applicationName, boolean enableTranslation,String message, String param){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + applicationName + "-alert",URLEncoder.encode( message,StandardCharsets.UTF_8));

        headers.add("X-" + applicationName + "-params", URLEncoder.encode(param, StandardCharsets.UTF_8));

        return headers;
    }

    public static HttpHeaders createEntityUpdateAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message = enableTranslation ? applicationName + "." + entityName + ".updated" : " a new " + entityName + " is updated with identifier" + param;


        return createHeader(applicationName,enableTranslation,message,param);

    }


    public static HttpHeaders createEntityDeletaionAlert(String applicationName, boolean enableTranslation, String entityName, String param) {

        String message = enableTranslation ? applicationName + "." + entityName + ".deleted" : " a new " + entityName + " is deleted with identifier" + param;


        return createHeader(applicationName,enableTranslation,message,param);

    }
}
