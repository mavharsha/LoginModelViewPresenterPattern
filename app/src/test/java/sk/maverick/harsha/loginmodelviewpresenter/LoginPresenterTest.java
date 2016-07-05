package sk.maverick.harsha.loginmodelviewpresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class LoginPresenterTest {

    LoginPresenter _loginPresenter;
    @Before
    public void setUp() throws Exception {
        _loginPresenter = new LoginPresenter();
    }

    @After
    public void tearDown() throws Exception {
        _loginPresenter = null;
    }

    @Test
    public void testShouldReturnSuccessWhenTheResponseCodeIs200(){

        assertEquals("Expects success when response code is 200",R.string.success, _loginPresenter.IRespondWithTextCorrespondingToTheStatusCodeSent(200));
    }

    @Test
    public void testShouldReturnFailWhenTheResponseCodeIsNotEqualTo200(){

        assertEquals("Expects fail when response code is 200",R.string.fail, _loginPresenter.IRespondWithTextCorrespondingToTheStatusCodeSent(500));
        assertEquals("Expects fail when response code is 200",R.string.fail, _loginPresenter.IRespondWithTextCorrespondingToTheStatusCodeSent(404));
    }
}