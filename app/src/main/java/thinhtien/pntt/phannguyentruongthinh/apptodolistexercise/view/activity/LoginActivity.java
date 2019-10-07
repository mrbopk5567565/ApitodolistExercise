package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.R;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.Loginresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    LoginViewModel loginViewModel;
    TextInputEditText edtUsername, edtPassword;
    String username, passowrd;
    Button btnDangNhap, btnDangKy;
    int REQUEST_CODE_REGISTER = 111;
    int REQUEST_CODE_WORK = 222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        anhxa();

        RegisterEvent();

        ButtonDangNhap();
    }

    private void ButtonDangNhap() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                username = edtUsername.getText().toString();
//                passowrd = edtUsername.getText().toString();

                loginViewModel = new LoginViewModel();

                loginViewModel.checklogin("phat","123").observe(LoginActivity.this, new Observer<Loginresponse>() {
                    @Override
                    public void onChanged(Loginresponse loginresponse) {
                        if (loginresponse != null){
                            if (loginresponse.getSuccess()){
                                Log.d("BBB", loginresponse.getIduser().toString());

                                ScreenWork();
                            } else {
                                Log.d("BBB", "dang nhap that bai");
                            }
                        }
                    }
                });
            }
        });
    }

    private void ScreenWork() {
        startActivityForResult(new Intent(LoginActivity.this,WorkActivity.class),REQUEST_CODE_WORK);

    }

    private void RegisterEvent() {
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(LoginActivity.this,RegisterActivity.class),REQUEST_CODE_REGISTER);
            }
        });
    }

    private void anhxa() {
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKy = findViewById(R.id.btnDangKy);

    }
}
