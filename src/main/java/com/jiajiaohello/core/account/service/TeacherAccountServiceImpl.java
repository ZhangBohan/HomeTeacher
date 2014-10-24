package com.jiajiaohello.core.account.service;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;
import com.jiajiaohello.core.account.dao.TeacherAccountDao;
import com.jiajiaohello.core.account.model.TeacherAccount;
import com.jiajiaohello.core.account.model.TeacherInfo;
import com.jiajiaohello.core.teacher.dto.EditForm;
import com.jiajiaohello.support.auth.AuthHelper;
import com.jiajiaohello.support.core.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;

/**
 * Teacher: bohan
 * Date: 9/17/14
 * Time: 4:07 PM
 */
@Service
public class TeacherAccountServiceImpl implements TeacherAccountService {
    @Autowired
    private TeacherAccountDao teacherAccountDao;
    @Autowired
    private OSSClient ossClient;

    @Override
    @Transactional
    public TeacherAccount get(String username) {
        TeacherAccount account = new TeacherAccount(username);
        account = teacherAccountDao.get(account);
        if (account == null) {
            return null;
        }
        account.setUpdatedAt(new Date());
        teacherAccountDao.saveOrUpdate(account);
        return account;
    }

    @Override
    public void update(EditForm editForm) throws IOException {
        TeacherAccount account = get(editForm.getUsername());
        if(account.getInfo() == null) {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.init();
            account.setInfo(teacherInfo);
        }

        account.setName(editForm.getName());
        account.getInfo().setDescription(editForm.getDescription());

        MultipartFile avatarFile = editForm.getAvatarFile();
        if (avatarFile != null && avatarFile.getSize() > 0) {
            // 获取指定文件的输入流

            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();

            // 必须设置ContentLength
            meta.setContentLength(avatarFile.getSize());
            meta.setContentType(avatarFile.getContentType());

            String fileName = avatarFile.getOriginalFilename();
            // 上传Object.
            PutObjectResult result = ossClient.putObject(CommonHelper.OSS_DEFAULT_BUCKET_NAME, fileName,
                    avatarFile.getInputStream(), meta);
            String avatarUrl = String.format("http://%s.oss-cn-beijing.aliyuncs.com/%s",
                    CommonHelper.OSS_DEFAULT_BUCKET_NAME, fileName);
            account.setAvatar(avatarUrl);
        }

        teacherAccountDao.saveOrUpdate(account);
    }
}
