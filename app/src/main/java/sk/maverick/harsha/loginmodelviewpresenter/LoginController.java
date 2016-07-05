package sk.maverick.harsha.loginmodelviewpresenter;


class LoginController {

    private ITalkToLoginActivity _ITalkToLoginActivity;
    private LoginService _service;

    LoginController(ITalkToLoginActivity talkToLoginActivity, LoginService service) {

        this._ITalkToLoginActivity = talkToLoginActivity;
        this._service = service;
    }

    void onLoginClicked() {

        int responseStatusCode = _service.callToTheServer(_ITalkToLoginActivity.getUsername(), _ITalkToLoginActivity.getPassword());
        int responseFromLoginPresenter;
        if (responseStatusCode == 200) {
            responseFromLoginPresenter = LoginPresenter.IRespondWithTextCorrespondingToTheStatusCodeSent(responseStatusCode);
            _ITalkToLoginActivity.UpdateText(responseFromLoginPresenter);
            return;
        }
        responseFromLoginPresenter = LoginPresenter.IRespondWithTextCorrespondingToTheStatusCodeSent(responseStatusCode);
        _ITalkToLoginActivity.showError(responseFromLoginPresenter);
        return;
    }
}
