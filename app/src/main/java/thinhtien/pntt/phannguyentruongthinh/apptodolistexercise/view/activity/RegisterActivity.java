package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.R;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Registerresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

    RegisterViewModel registerViewModel;
    String registerUsername, registerPassword;

    Button btnRegister;
    EditText edtRegisterUsername, edtRegisterPassword, edtAgainPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Anhxa();
        Events();
    }

    private void Anhxa() {
        btnRegister = findViewById(R.id.btnRegister);
        edtRegisterUsername = findViewById(R.id.edtRegisterUsername);
        edtRegisterPassword = findViewById(R.id.edtRegisterPassword);
        edtAgainPassword    = findViewById(R.id.edtAgainPassword);
    }

    private void Events() {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerViewModel = new RegisterViewModel();
                registerViewModel.checkRegister("thong","123").observe(RegisterActivity.this, new Observer<Registerresponse>() {
                    @Override
                    public void onChanged(Registerresponse registerresponse) {
                        if (registerresponse != null){
                            if (registerresponse.getSuccess()){
                                Log.d("BBB",registerresponse.getSuccess() + "");
                            } else {
                                Log.d("BBB",registerresponse.getSuccess() + "");
                            }
                        }

                    }
                });

                finish();
            }
        });
    }
}
