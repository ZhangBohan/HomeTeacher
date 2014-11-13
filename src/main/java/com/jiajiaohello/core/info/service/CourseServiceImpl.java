package com.jiajiaohello.core.info.service;

import com.jiajiaohello.core.info.model.Stage;
import com.jiajiaohello.support.core.CommonDao;
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
    private CommonDao<Stage> stageCommonDao;

    @Override
    public List<Stage> getStages() {
        return stageCommonDao.getList(new Stage());
    }
}
