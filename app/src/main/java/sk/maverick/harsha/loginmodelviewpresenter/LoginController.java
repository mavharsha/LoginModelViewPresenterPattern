package sk.maverick.harsha.loginmodelviewpresenter;

/**
 * Created by Harsha on 6/30/2016.
 */

public class LoginController {

    ITalkToLoginActivity _ITalkToLoginActivity;

    public LoginController(ITalkToLoginActivity talkToLoginActivity) {
        this._ITalkToLoginActivity = talkToLoginActivity;
    }



    public void onLoginClicked(String username, String password){

        int responseStatusCode = LoginService.callToTheServer(username, password);
        String reponseFromLoginPresenter = LoginPresenter.IRespondWithTextCorrespondingToTheStatusCodeSent(responseStatusCode);
        _ITalkToLoginActivity.UpdateText(reponseFromLoginPresenter);
    }





    public interface ITalkToLoginActivity{

        void showError();
        void UpdateText(String text);
    }
}
