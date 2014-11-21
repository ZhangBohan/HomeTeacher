package com.jiajiaohello.core.recommend;

import com.jiajiaohello.core.account.model.RecommendType;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.service.TeacherAccountService;
import com.jiajiaohello.support.core.CommonDao;
import com.jiajiaohello.support.core.CommonHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * User: bohan
 * Date: 11/21/14
 * Time: 11:00 AM
 */
@Service
public class TeacherRecommendService implements RecommendService<TeacherAccount> {
    @Autowired
    private CommonDao<RecommendItem> recommendItemCommonDao;
    @Autowired
    private TeacherAccountService teacherAccountService;

    @Override
    public List<RecommendItem> getRecommendList(RecommendType recommendType, Integer start, Integer size) {
        return null;
    }

    @Override
    public List<RecommendItem> getRecommendList(RecommendType recommendType) {
        RecommendItem item = new RecommendItem();
        item.setTypeId(recommendType.getId());
        List<RecommendItem> list = recommendItemCommonDao.getList(item);
        for (RecommendItem recommendItem : list) {
            TeacherAccount teacherAccount = teacherAccountService.get(recommendItem.getItemId());
            recommendItem.setEntity(teacherAccount);
        }

        return list;
    }

    @Override
    public RecommendItem save(RecommendType recommendType, RecommendItem item) {
        item.init();
        item.setTypeId(recommendType.getId());
        return saveAndGetEntity(item);
    }

    @Override
    public RecommendItem update(RecommendType recommendType, RecommendItem item) {
        RecommendItem recommendItem = recommendItemCommonDao.get(item.getId(), RecommendItem.class);
        try {
            BeanUtils.copyProperties(recommendItem, item);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        item = recommendItem;
        item.setUpdatedAt(CommonHelper.now());
        return saveAndGetEntity(item);
    }

    private RecommendItem saveAndGetEntity(RecommendItem item) {
        recommendItemCommonDao.saveOrUpdate(item);
        TeacherAccount teacherAccount = teacherAccountService.get(item.getItemId());
        item.setEntity(teacherAccount);
        return item;
    }

    @Override
    public void delete(Integer id) {
        recommendItemCommonDao.delete(id, RecommendItem.class);
    }
}
