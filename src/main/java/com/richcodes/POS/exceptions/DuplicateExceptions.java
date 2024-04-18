package com.richcodes.POS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicateExceptions extends  RuntimeException{
    public DuplicateExceptions( String message) {
        super(message);
    }
}
