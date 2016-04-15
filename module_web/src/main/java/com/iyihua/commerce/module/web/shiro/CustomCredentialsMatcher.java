package com.iyihua.commerce.module.web.shiro;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.iyihua.commerce.model.component.CredentialsInfoHolder;
import com.iyihua.commerce.module.util.PasswordSecureHash;

//@Component
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		CredentialsInfoHolder accountCredentials = (CredentialsInfoHolder) getCredentials(info);
		String salt = accountCredentials.getSalt();
		String password = accountCredentials.getPassword();
		Object tokenCredentials = superEncrypt(String.valueOf(token.getPassword()), salt);
		// 将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		return equals(tokenCredentials, password);
	}

	private String superEncrypt(String password, String salt) {
		String result = "";
		try {
			result = PasswordSecureHash.hashEncrypt(password, salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Object getCredentials(AuthenticationInfo info) {
		Object credentials = info.getCredentials();
		CredentialsInfoHolder cih = (CredentialsInfoHolder) credentials;
		return cih;
	}

}