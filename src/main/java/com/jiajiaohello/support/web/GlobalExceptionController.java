package com.jiajiaohello.support.web;

import com.jiajiaohello.support.core.CommonHelper;
import com.jiajiaohello.support.exception.JSONCrashException;
import com.jiajiaohello.support.exception.TeacherInfoNotFillException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 11:38 AM
 */
@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        CommonHelper.LOG.error(ex.getMessage(), ex);
        ModelAndView model = new ModelAndView("error");
        model.addObject("ex", ex);

        return model;

    }

    @ExceptionHandler(TeacherInfoNotFillException.class)
    public ModelAndView handleTeacherNotFillException() {
        ModelAndView model = new ModelAndView("redirect:/teacher/edit");
        return model;
    }

    @ExceptionHandler(JSONCrashException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleJSONCrashException(JSONCrashException ex) {
        CommonHelper.LOG.error(ex.getMessage());
        return ex.getMessage();
    }
}
