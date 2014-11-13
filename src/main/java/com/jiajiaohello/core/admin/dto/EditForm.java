package com.jiajiaohello.core.admin.dto;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: wh
 * Date: 10/24/14
 * Time: 3:11 PM
 */
public class EditForm {
    @NotBlank(message = "系统错误")
    private String username;

    @Size(min = 2, max = 10, message = "名字不能太长也不能太短")
    private String name;
    private MultipartFile avatarFile;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getAvatarFile() {
		return avatarFile;
	}
	public void setAvatarFile(MultipartFile avatarFile) {
		this.avatarFile = avatarFile;
	}

}
