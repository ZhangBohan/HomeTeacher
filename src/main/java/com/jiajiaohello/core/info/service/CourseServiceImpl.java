package com.jiajiaohello.core.info.service;

import com.jiajiaohello.core.info.dao.CourseDao;
import com.jiajiaohello.core.info.dao.StageDao;
import com.jiajiaohello.core.info.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: bohan
 * Date: 11/4/14
 * Time: 11:16 PM
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StageDao stageDao;

    @Override
    public List<Stage> getStages() {
        return stageDao.getList(new Stage());
    }
}
