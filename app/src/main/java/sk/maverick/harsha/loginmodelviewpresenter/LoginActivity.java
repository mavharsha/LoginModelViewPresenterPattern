package sk.maverick.harsha.loginmodelviewpresenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements LoginController.ITalkToLoginActivity{

    LoginController loginController = new LoginController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginController.onLoginClicked(((EditText)findViewById(R.id.username_et)).getText().toString(), ((EditText)findViewById(R.id.password_et)).getText().toString());
            }
        });
    }


    @Override
    public void showError() {

    }

    @Override
    public void UpdateText(String responsefrompresenter) {

        ((TextView)findViewById(R.id.status_tv)).setText(responsefrompresenter);

    }
}
