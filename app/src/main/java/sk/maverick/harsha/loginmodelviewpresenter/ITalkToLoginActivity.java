package sk.maverick.harsha.loginmodelviewpresenter;

interface ITalkToLoginActivity {

        String getUsername();
        String  getPassword();
        void showError(int responsefrompresenter);
        void UpdateText(int responsefrompresenter);

}
