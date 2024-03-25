package com.tmane.springbootmvcdemo.handler;

import com.tmane.springbootmvcdemo.exception.CompanyNoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(CompanyNoSuchElementException.class)
    public String handleCompanyNoSuchElementException(CompanyNoSuchElementException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", e.getMessage());
        return "redirect:/companies";
    }
}
