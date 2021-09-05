package cn.whu.dhji.config.shiro;

import cn.whu.dhji.entity.User;
import cn.whu.dhji.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// import r


/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	public UserRealm() {
		setName("UserRealm");
		// 采用MD5加密
		// setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
	}

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//add Permission Resources
		info.setStringPermissions(userService.findPermissions(username));
		//add Roles String[Set<String> roles]
		//info.setRoles(roles);
		return info;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userName = upt.getUsername();
		User user = userService.getByUsername(userName);

		if (user == null) {
			throw new UnknownAccountException();
		}
		return new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
	}
}