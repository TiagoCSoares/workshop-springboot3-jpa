package com.tiagocsoares.course.services.exceptions;

import javax.xml.crypto.Data;

public class DataBaseException extends RuntimeException{

    public DataBaseException(String msg) {
        super(msg);
    }
}
