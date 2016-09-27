package cn.ibluesea.shiro.shirojdbc.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

import com.alibaba.fastjson.JSON;

public class MapRealm implements Realm {
	protected static final Logger logger = Logger.getLogger(MapRealm.class);

	public String getName() {
		return "mapRealm";
	}

	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());
		logger.debug(username + ":" + password);
		return null;
	}

}
