package com.proj.library.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HttpErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {

        String errorResult = "error/error";

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        Integer errorName = Integer.valueOf(status.toString());

        if (errorName != null) {

            if (errorName == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorResult = "error/500";
            } else if (errorName == HttpStatus.NOT_FOUND.value()) {
                errorResult = "error/404";
            } else if (errorName == HttpStatus.FORBIDDEN.value()) {
                errorResult = "error/403";
            } else if (errorName == HttpStatus.BAD_REQUEST.value()) {
                errorResult = "error/400";
                //this will not be used because 400 is not editable
                //i mean it's editable when u add some dependency to pom.xml
                //for now it's irrelevant
                //but it's important to mention
            }
        }
        return errorResult;
    }
}
