package sk.maverick.harsha.loginmodelviewpresenter;

/**
 * Created by Harsha on 6/30/2016.
 */

public class LoginPresenter {

    public static int IRespondWithTextCorrespondingToTheStatusCodeSent(int statuscode){
        if(statuscode == 200){
            return R.string.success;
        }
        return R.string.fail;
    }
}
