package com.richcodes.POS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends  RuntimeException{
    public ResourceNotFoundExceptions(String message) {
        super(message);
    }
}
