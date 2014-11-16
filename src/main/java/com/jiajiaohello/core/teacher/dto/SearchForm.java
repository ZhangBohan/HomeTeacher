package com.jiajiaohello.core.teacher.dto;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 搜索模型
 * @author wh
 *
 */
public class SearchForm {
	@NotBlank(message = "系统错误")
	private String username;

	@Size(min = 2, max = 10, message = "名字不能太长也不能太短")
	private String name;

	@NotBlank
	@Size(min = 10, max = 255, message = "描述长度在10到255字符之间")
	private String description;

	@Size(min = 1, message = "请正确输入教育信息")
	private String school;
	@Size(min = 10, message = "授课时间长度在10到255字符之间")
	private String freeTime;
	@NotNull(message = "请选择您的身份")
	private Integer identity;

	private Boolean sex;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getFreeTime() {
		return freeTime;
	}

	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

}
