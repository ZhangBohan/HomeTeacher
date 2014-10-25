package com.jiajiaohello.support.core;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * User: bohan
 * Date: 10/24/14
 * Time: 4:56 PM
 */
@Service
public class OSSService {
    @Autowired
    private OSSClient ossClient;

    public String upload(MultipartFile multipartFile, String fileName) throws IOException {
        if (multipartFile != null && multipartFile.getSize() > 0) {

            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();

            // 必须设置ContentLength
            meta.setContentLength(multipartFile.getSize());
            meta.setContentType(multipartFile.getContentType());

            // 上传Object.
            ossClient.putObject(CommonHelper.OSS_DEFAULT_BUCKET_NAME, fileName,
                    multipartFile.getInputStream(), meta);
            return String.format("http://%s.oss-cn-beijing.aliyuncs.com/%s",
                    CommonHelper.OSS_DEFAULT_BUCKET_NAME, fileName);
        }
        return null;
    }

    public String upload(MultipartFile multipartFile) throws IOException {
        String fileName = UUID.randomUUID().toString() + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        return upload(multipartFile, fileName);
    }
}
