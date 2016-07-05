package sk.maverick.harsha.loginmodelviewpresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @Mock
    private ITalkToLoginActivity _ITalkToLoginActivity;
    private LoginService _loginService;
    private LoginController __LoginController;

    @Before
    public void setUp() throws Exception {

        _loginService = new LoginService();
        __LoginController = new LoginController(_ITalkToLoginActivity, _loginService);
    }

    @After
    public void tearDown() throws Exception {

        _loginService = null;
        __LoginController =null;
    }

    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception {
        when(_ITalkToLoginActivity.getUsername()).thenReturn("");
        when(_ITalkToLoginActivity.getPassword()).thenReturn("password");

        __LoginController.onLoginClicked();
        verify(_ITalkToLoginActivity).showError(R.string.fail);

    }

    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(_ITalkToLoginActivity.getUsername()).thenReturn("mavharsha");
        when(_ITalkToLoginActivity.getPassword()).thenReturn("");

        __LoginController.onLoginClicked();

        verify(_ITalkToLoginActivity).showError(R.string.fail);

    }

    @Test
    public void shouldShowShowSuccess() throws Exception {
        when(_ITalkToLoginActivity.getUsername()).thenReturn("mavharsha");
        when(_ITalkToLoginActivity.getPassword()).thenReturn("awesome");

        __LoginController.onLoginClicked();
        verify(_ITalkToLoginActivity).UpdateText(R.string.success);
    }

}