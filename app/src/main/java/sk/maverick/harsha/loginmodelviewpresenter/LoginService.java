package sk.maverick.harsha.loginmodelviewpresenter;

/**
 * Created by Harsha on 6/30/2016.
 */

public class LoginService {

    public int callToTheServer(String username, String password){

        if(username.equalsIgnoreCase("mavharsha") && password.equalsIgnoreCase("awesome")){
            return 200;
        }

        return 403;
    }
}
