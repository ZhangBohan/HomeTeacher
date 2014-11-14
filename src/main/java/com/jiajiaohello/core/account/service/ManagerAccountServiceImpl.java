package com.jiajiaohello.core.account.service;

import com.jiajiaohello.core.account.model.ManagerAccount;
import com.jiajiaohello.core.admin.dto.EditForm;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.auth.ManagerUserDetailService;
import com.jiajiaohello.support.auth.PasswordEncoder;
import com.jiajiaohello.support.auth.RegisterForm;
import com.jiajiaohello.support.core.CommonDao;
import com.jiajiaohello.support.core.OSSBucket;
import com.jiajiaohello.support.core.OSSService;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.io.IOException;
import java.util.Date;

/**
 * Manager: bohan
 * Date: 9/17/14
 * Time: 4:07 PM
 */
@Service
public class ManagerAccountServiceImpl implements ManagerAccountService {
    @Autowired
    private CommonDao<ManagerAccount> managerAccountCommonDao;
    @Autowired
    private OSSService ossService;
    @Override
    @Transactional
    public ManagerAccount get(String username) {
        ManagerAccount account = new ManagerAccount(username);
        account = managerAccountCommonDao.get(account);
        if(account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        managerAccountCommonDao.saveOrUpdate(account);
        return account;
    }

	@Override
	public void create(RegisterForm registerForm) {
		   ManagerAccount managerAccount = new ManagerAccount();
	        try {
	            BeanUtils.copyProperties(managerAccount, registerForm);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        managerAccount.setUsername(registerForm.getPhone());
	        managerAccount.setPassword(new PasswordEncoder().encode(registerForm.getPassword()));   // 加密后保存
	        managerAccountCommonDao.saveOrUpdate(managerAccount);
	}
	
	 @Override
	    public void update(EditForm editForm) throws IOException {
	        ManagerAccount account = get(editForm.getUsername());

	        account.setName(editForm.getName());

	        String avatar = ossService.upload(editForm.getAvatarFile(), OSSBucket.avatar, Integer.toString(account.getId()));
	        if(StringUtils.isNotBlank(avatar)) {
	            account.setAvatar(avatar);
	        }
	        AuthHelper.reloadAccount(account, ManagerUserDetailService.authorities);
	        managerAccountCommonDao.saveOrUpdate(account);
	    }
}
