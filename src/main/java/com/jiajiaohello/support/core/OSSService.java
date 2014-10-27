package com.jiajiaohello.support.core;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.OSSObjectSummary;
import com.aliyun.openservices.oss.model.ObjectListing;
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

    /**
     * 上传文件
     *
     * @param multipartFile 文件
     * @param ossBucket 目录
     * @param fileName 文件名，无需扩展名
     * @return 线上URL
     * @throws IOException
     */
    public String upload(MultipartFile multipartFile, OSSBucket ossBucket, String fileName) throws IOException {
        if (multipartFile != null && multipartFile.getSize() > 0) {
            fileName += "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();

            // 必须设置ContentLength
            meta.setContentLength(multipartFile.getSize());
            meta.setContentType(multipartFile.getContentType());

            // 上传Object.
            ossClient.putObject(ossBucket.getName(), fileName,
                    multipartFile.getInputStream(), meta);
            return String.format("http://%s.oss-cn-beijing.aliyuncs.com/%s",
                    ossBucket.getName(), fileName);
        }
        return null;
    }

    public String upload(MultipartFile multipartFile, OSSBucket ossBucket) throws IOException {
        String fileName = UUID.randomUUID().toString();
        return upload(multipartFile, ossBucket, fileName);
    }
}
