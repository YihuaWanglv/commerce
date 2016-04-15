package com.iyihua.commerce.module.web.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyihua.commerce.model.component.CredentialsInfoHolder;
import com.iyihua.commerce.model.user.User;
import com.iyihua.commerce.remote.user.UserRemote;

//@Component
public class MyRealm extends AuthorizingRealm {

	@Autowired private UserRemote userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> roles = userService.findByUserId(user.getId());
		info.addRoles(roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String username = usernamePasswordToken.getUsername();
		User user = userService.findUserByName(username);
		if (null != user) {
			CredentialsInfoHolder cih = new CredentialsInfoHolder(user.getPassword(), user.getSalt());
			return new SimpleAuthenticationInfo(user, cih, getName());
		}
		return null;
	}

}
