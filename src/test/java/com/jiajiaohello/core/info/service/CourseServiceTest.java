package com.jiajiaohello.core.info.service;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.core.info.model.Stage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceTest extends BaseTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void testInit() {
        List<Stage> stages = courseService.getStages();
        System.out.println(stages);
    }
}