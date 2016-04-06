package com.iyihua.commerce.web.seller.component.security;

import org.springframework.stereotype.Component;

@Component
public class LoginSessionManager {

//	public UserDTO getSessionUser() {
//		Subject subject = SecurityUtils.getSubject();
//		if (subject != null && subject.getPrincipal() != null && subject.getPrincipal() instanceof UserDTO) {
//			return (UserDTO) subject.getPrincipal();
//		}
//		return null;
//	}
//	
//	public Long getSessionUserId() {
//		Subject subject = SecurityUtils.getSubject();
//		UserDTO user = null;
//		if (subject != null && subject.getPrincipal() != null && subject.getPrincipal() instanceof UserDTO) {
//			user = (UserDTO) subject.getPrincipal();
//			if (user != null) {
//				return user.getId();
//			}
//		}
//		return null;
//	}
}
