package newtestcases;

import java.io.IOException;
import org.testng.annotations.Test;

import newtestbase.Baseclass;
import newpageobjects.Dashboardpage;
import newpageobjects.Homepage;
import newpageobjects.Loginpage;
import  newtestbase.Baseclass;
import newutilities.Utils;

public class TC_002_Login extends Baseclass{

	@Test
	public void account_Login() throws IOException, InterruptedException {
		Homepage hp=new Homepage(driver);
		Loginpage lp=new Loginpage(driver);
		Dashboardpage dp=new Dashboardpage(driver);
		hp.clcik_Login();
		hp.click_Login_Student();
		String file=System.getProperty("user.dir")+"/testdata/LoginData.xlsx";
		logger.info("****Goto Excel Sheet***");
		int rows=Utils.getRowCount(file, "Sheet1");
		logger.info("****Read number of rows***");
		for(int r=1;r<=rows;r++) {
			String mail=Utils.getCellData(file, "Sheet1", r, 0);
			String pwd=Utils.getCellData(file, "Sheet1", r, 1);
			lp.set_Email(mail);
			logger.info("****Entered Email address***");
			lp.set_Password(pwd);
			logger.info("****Entered Password***");
			lp.click_Login();
			logger.info("****Login Successfull***");
			dp.click_Mylearning();
			logger.info("****Clicked on My Learning***");
			dp.click_Course();
			logger.info("****Clicked on Course***");
			dp.click_Loginvdc();
			logger.info("****Clicked on loginvdc***");
			dp.click_sso();
			logger.info("****Clicked on sso***");
			lp.click_logout();
			logger.info("****Logout Successfull***");
			hp.clcik_Login();
			hp.click_Login_Student();
		}
	}
}