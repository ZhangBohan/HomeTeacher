package com.jiajiaohello.core.teacher.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

/**
 * User: bohan
 * Date: 10/24/14
 * Time: 3:11 PM
 */
public class EditForm {
    @NotBlank(message = "系统错误")
    private String username;

    @Size(min = 2, max = 10, message = "名字不能太长也不能太短")
    private String name;

    @NotBlank
    @Size(min = 10, message = "描述长短！")
    private String description;

    private MultipartFile avatarFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getAvatarFile() {
        return avatarFile;
    }

    public void setAvatarFile(MultipartFile avatarFile) {
        this.avatarFile = avatarFile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
