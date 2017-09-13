package main.java.com.kiraula.tulsi.ShrioProject.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Authentication {

	public static void main(String[] args) {
		
		//set security manager instance
		//get shiro.ini from class path
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager  = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject currentUser = SecurityUtils.getSubject();
		
		Session session = currentUser.getSession();
		session.setAttribute("currentUser", "Tulsi");
		
		UsernamePasswordToken token =  new UsernamePasswordToken("tulsi","tulsi");
		if (!currentUser.isAuthenticated()) {
	            currentUser = new Subject.Builder().buildSubject();
	        }
		try {
			currentUser.login(token);
			System.out.println("login successful");
		}catch(AuthenticationException e){
			e.printStackTrace();
		}
		token.setRememberMe(true);
	}

}
