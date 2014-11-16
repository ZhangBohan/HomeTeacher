package com.jiajiaohello.core.teacher.dto;

import org.hibernate.validator.constraints.NotBlank;
/**
 * 
 * @author wh
 *
 */
public class VerifyForm {
    @NotBlank(message = "数据错误")
    private String username;

    @NotBlank(message = "数据错误")
    private boolean audited;// 1 true  0 false;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAudited() {
		return audited;
	}

	public void setAudited(boolean audited) {
		this.audited = audited;
	}





 
}
