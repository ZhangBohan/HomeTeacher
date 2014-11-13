package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.RecommendType;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.teacher.dto.EditForm;
import com.jiajiaohello.support.auth.RegisterForm;

import java.io.IOException;
import java.util.List;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:05 PM
 */
public interface TeacherAccountService {
    TeacherAccount get(String username);

    /**
     * 读取用户信息，同时更新最近登录时间
     *
     * @param username 用户名
     * @return
     */
    TeacherAccount loginLoad(String username);

    TeacherAccount get(Integer teacherId);

    void update(EditForm editForm) throws IOException;

    void create(RegisterForm registerForm);

    void updateCourses(Integer[] courseIds);

    List<TeacherAccount> getRecommendTeacherAccounts(RecommendType recommendType, Integer start, Integer size);
}
