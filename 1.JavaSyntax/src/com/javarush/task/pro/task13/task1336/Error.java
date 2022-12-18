package com.javarush.task.pro.task13.task1336;

import java.util.HashMap;
import java.util.Map;

public enum Error {
    NETWORK_ERROR(100), SYSTEM_ERROR(200), COMPILATION_ERROR(300);
    private final static Map<Integer, Error> errorMap = new HashMap<>();

    private final int errorCode;
    //напишите тут ваш код
    static {
        for (Error error:
             Error.values()) {
            errorMap.put(error.errorCode, error);
        }
    }

    Error(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public static Error getErrorByID(Integer errorNumber) {
        return errorMap.get(errorNumber);
    }

    public Map<Integer, Error> getErrorMap() { return errorMap; }

    @Override
    public String toString() {
        return String.format("%s", getErrorMap().get(errorCode).name());
        //String.format("Error{ errorCode = %s }", errorCode);
    }
}
