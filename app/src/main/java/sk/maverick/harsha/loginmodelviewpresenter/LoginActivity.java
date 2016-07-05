package sk.maverick.harsha.loginmodelviewpresenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements ITalkToLoginActivity{

    private LoginService service = new LoginService();
    private LoginController loginController = new LoginController(this, service);
    private EditText username, password;
    private TextView status;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username_et);
        password = (EditText)findViewById(R.id.password_et);
        status = (TextView)findViewById(R.id.status_tv);
        login = (Button) findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginController.onLoginClicked();
            }
        });
    }


    @Override
    public void showError(int responseFromPresenter) {

        status.setText(responseFromPresenter);
    }

    @Override
    public void UpdateText(int responseFromPresenter) {

        status.setText(responseFromPresenter);
    }

    @Override
    public String getUsername(){

        return username.getText().toString();
    }

    @Override
    public String getPassword() {

        return password.getText().toString();
    }
}
