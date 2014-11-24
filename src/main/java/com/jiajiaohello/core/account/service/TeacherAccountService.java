package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.RecommendType;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.teacher.dto.TeacherEditForm;
import com.jiajiaohello.core.teacher.dto.SearchForm;
import com.jiajiaohello.core.teacher.dto.VerifyForm;
import com.jiajiaohello.support.auth.RegisterForm;
import com.jiajiaohello.support.exception.UserLogicException;
import com.jiajiaohello.support.web.Pager;

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

    void update(TeacherEditForm teacherEditForm) throws IOException;
    
    void updateTeacher(TeacherEditForm teacherEditForm) throws IOException;
     
    void create(RegisterForm registerForm) throws UserLogicException;

    void updateCourses(Integer[] courseIds);

    List<TeacherAccount> getRecommendTeacherAccounts(RecommendType recommendType, Integer start, Integer size);
    
    List<TeacherAccount> getTeacherAccounts(TeacherAccount entity,Integer firstResult, Integer maxResult) ;
    
    List<TeacherAccount> getTeacherAccountsByCondition(SearchForm searchform,Pager page);
    
    int getCount();
    
     void verityTeacher(VerifyForm verifyform) ;
}
