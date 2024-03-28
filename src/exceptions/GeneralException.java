package exceptions;

import enums.ErrorEnum;

public class GeneralException extends RuntimeException {
    public GeneralException(ErrorEnum errorEnum) {
        super(errorEnum.getInfo());
    }
}