package testing;


import javabean.LoginBean;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class LoginBeanTest {

    private String email;
    private String pwd;

    @Test
    public void validate() throws Exception
    {
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("a");
        loginBean.setPassword("a");

        try {
            int result;
            result = loginBean.validate();

            this.email = "a";
            this.pwd= "a";

            Assert.assertEquals(result, 1);
            Assert.assertEquals(email, loginBean.getEmail());
            Assert.assertEquals(pwd, loginBean.getPassword());
            Assert.assertEquals(1, loginBean.getAccountType());

            result = loginBean.validate();
            //login riuscito

            this.email = "c";
            this.pwd= "";

            Assert.assertEquals(result, 2);
            //form incompleto

            this.email = "c";
            this.pwd= "a";

            Assert.assertEquals(result, 3);
            //utente non esistente

            this.email = "a";
            this.pwd= "c";

            Assert.assertEquals(result, 4);
            //password errata

        } catch (Exception e) {
            e.printStackTrace();
            fail("Errore");
        }
    }

}