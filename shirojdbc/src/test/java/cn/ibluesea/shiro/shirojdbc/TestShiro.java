package cn.ibluesea.shiro.shirojdbc;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestShiro {

	protected static final Logger logger = Logger.getLogger(TestShiro.class);

	@Test
	public void test1() {

		SecurityManager manager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin1", "123");

		try {
			subject.login(token);
			logger.debug(JSON.toJSONString(subject.getPrincipal()));
		} catch (UnknownAccountException uae) {
			logger.debug("用户名不存在");
		} catch (IncorrectCredentialsException uae) {
			logger.debug("密码错误");
		}
	}
}
