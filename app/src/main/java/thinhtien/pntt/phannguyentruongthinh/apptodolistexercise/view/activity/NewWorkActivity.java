package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.R;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.api.modelapi.NewWorkresponse;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.viewmodel.NewWorkViewModel;

public class NewWorkActivity extends AppCompatActivity {

    NewWorkViewModel newWorkViewModel;
    Button btnLuu, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_work);

        AnhXa();
        ButtonLuu();
        ButtonHuy();
    }

    private void AnhXa() {
        btnHuy = findViewById(R.id.btnHuyBo);
        btnLuu = findViewById(R.id.btnLuu);
    }

    private void ButtonHuy() {

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void ButtonLuu() {

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newWorkViewModel = new NewWorkViewModel();
                newWorkViewModel.checkNewWork("Android",20,2).observe(NewWorkActivity.this, new Observer<NewWorkresponse>() {
                    @Override
                    public void onChanged(NewWorkresponse newWorkresponse) {
                        if (newWorkresponse != null){
                            if (newWorkresponse.getSuccess()){
                                Log.d("BBB", newWorkresponse.getMessage());
                            } else {
                                Log.d("BBB",newWorkresponse.getMessage());
                            }
                        }
                    }
                });
            }
        });

    }
}
