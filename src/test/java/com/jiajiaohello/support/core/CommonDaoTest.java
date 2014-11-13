package com.jiajiaohello.support.core;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.core.info.model.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CommonDaoTest extends BaseTest {
    @Autowired
    private CommonDao<Course> courseCommonDao;

    @Test
    public void testGet() throws Exception {
        Course course = courseCommonDao.get(-1, Course.class);
        assertNull(course);
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        Course course = new Course();
        course.init();
        course.setName("aaa");
        course.setDescription("www");
        courseCommonDao.saveOrUpdate(course);
    }

    @Test
    public void testGetList() throws Exception {
        List<Course> list = courseCommonDao.getList(new Course());
        System.out.println(list);
        assertNotNull(list);
    }
}