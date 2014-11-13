package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.dao.UserAccountDao;
import com.jiajiaohello.core.account.model.UserAccount;
import com.jiajiaohello.support.auth.PasswordEncoder;
import com.jiajiaohello.support.auth.RegisterForm;
import com.jiajiaohello.support.core.CommonHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * User: bohan
 * Date: 9/17/14
 * Time: 4:07 PM
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountDao userAccountDao;

    @Override
    @Transactional
    public UserAccount get(String username) {
        UserAccount account = new UserAccount(username);
        account = userAccountDao.get(account);
        if(account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        userAccountDao.saveOrUpdate(account);
        return account;
    }

    @Override
    public void create(RegisterForm form) {
        UserAccount userAccount = new UserAccount();
        try {
            BeanUtils.copyProperties(userAccount, form);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userAccount.setAvatar(CommonHelper.DEFAULT_AVATAR_URL);
        userAccount.setUsername(form.getPhone());
        userAccount.setPassword(new PasswordEncoder().encode(form.getPassword()));   // 加密后保存
        userAccountDao.saveOrUpdate(userAccount);
    }
}
