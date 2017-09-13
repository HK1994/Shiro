package main.java.com.kiraula.tulsi.ShrioProject.shiro;

import com.jolbox.bonecp.BoneCPDataSource;

public class CoonectionDataSource extends BoneCPDataSource {
	
	private static final long serialVersionUID = 1L;

	public CoonectionDataSource(final String dbUrl, final String dbUser, final String dbPwd, final String driver)
	    {
	        super();
	        this.setDriverClass(driver);
	        this.setJdbcUrl(dbUrl);
	        this.setUsername(dbUser);
	        this.setPassword(dbPwd);
	    }

	public CoonectionDataSource() {
		this("jdbc:oracle:thin:@10.151.57.58:1521:orcl", "kiraula1", "kiraula1","oracle.jdbc.driver.OracleDriver" );
	}
	
}


	
