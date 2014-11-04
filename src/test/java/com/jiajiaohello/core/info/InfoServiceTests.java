package com.jiajiaohello.core.info;

import com.jiajiaohello.BaseTest;
import com.jiajiaohello.core.info.dao.CourseDao;
import com.jiajiaohello.core.info.dao.StageDao;
import com.jiajiaohello.core.info.model.Stage;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;


/**
 * User: bohan
 * Date: 11/4/14
 * Time: 10:52 PM
 */
public class InfoServiceTests extends BaseTest {
    @Autowired private CourseDao courseDao;
    @Autowired private StageDao stageDao;

    @Transactional
    public void testInit() {
        for (String name : new String[]{"小学", "中学", "高中"}) {
            Stage stage = new Stage();
            stage.setName(name);
            stage.init();
            stageDao.saveOrUpdate(stage);
        }

    }
}
