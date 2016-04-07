package com.iyihua.commerce.web.seller.config.security;

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
		// List<String> roles = roleService.getRoles(user.getId());
		// List<String> resources = resourceService.getResources(user.getId());
		// info.addRoles(roles);
		// info.addStringPermissions(resources);

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
			// 此处传入的第一个参数为user对象，那么我们在页面可以通过这样的方式来获取用户名：<shiro:principal property="username"/>
			// return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			// return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());

			CredentialsInfoHolder cih = new CredentialsInfoHolder(user.getPassword(), user.getSalt());
			return new SimpleAuthenticationInfo(user, cih, getName());
		}

		return null;
	}

}
