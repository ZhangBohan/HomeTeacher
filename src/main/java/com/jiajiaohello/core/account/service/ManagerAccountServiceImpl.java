package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.dao.ManagerAccountDao;
import com.jiajiaohello.core.account.model.ManagerAccount;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.support.auth.PasswordEncoder;
import com.jiajiaohello.support.auth.RegisterForm;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Manager: bohan
 * Date: 9/17/14
 * Time: 4:07 PM
 */
@Service
public class ManagerAccountServiceImpl implements ManagerAccountService {
    @Autowired
    private ManagerAccountDao managerAccountDao;

    @Override
    @Transactional
    public ManagerAccount get(String username) {
        ManagerAccount account = new ManagerAccount(username);
        account = managerAccountDao.get(account);
        if(account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        managerAccountDao.saveOrUpdate(account);
        return account;
    }

	@Override
	public void create(RegisterForm registerForm) {
		   ManagerAccount mannagerAccount = new ManagerAccount();
	        try {
	            BeanUtils.copyProperties(mannagerAccount, registerForm);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        mannagerAccount.setUsername(registerForm.getPhone());
	        mannagerAccount.setPassword(new PasswordEncoder().encode(registerForm.getPassword()));   // 加密后保存
	        managerAccountDao.saveOrUpdate(mannagerAccount);
	}
}
