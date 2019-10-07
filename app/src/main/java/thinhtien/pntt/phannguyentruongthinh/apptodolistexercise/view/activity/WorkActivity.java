package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.R;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.model.Work;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.view.adapter.Work_Apdater;

public class WorkActivity extends AppCompatActivity {

    Button btnEdit;
    RecyclerView recyclerView;
    Work_Apdater apdater;
    ArrayList<Work> mangCV;
    int REQUEST_CODE_NEWWORK = 333;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        AnhXa();
    }

    private void AnhXa() {
        btnEdit = findViewById(R.id.btnEdit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_newwork,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_newwork:
                startActivityForResult(new Intent(WorkActivity.this,NewWorkActivity.class),REQUEST_CODE_NEWWORK);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
