package ir.setad.banking.app.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CreateLogger {

    public static<T> Logger getLogger(Class<T> className){
        return LoggerFactory.getLogger(className);
    }
}
