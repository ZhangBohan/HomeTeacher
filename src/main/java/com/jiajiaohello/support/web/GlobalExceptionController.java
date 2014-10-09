package com.jiajiaohello.support.web;

import com.jiajiaohello.support.core.CommonHelper;
import com.jiajiaohello.support.exception.TeacherInfoNotFillException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        CommonHelper.LOG.error(ex);
        ModelAndView model = new ModelAndView("error");
        model.addObject("ex", ex);

        return model;

    }

    @ExceptionHandler(TeacherInfoNotFillException.class)
    public ModelAndView handleTeacherNotFillException() {
        ModelAndView model = new ModelAndView("redirect:/teacher/edit");
        return model;
    }
}
