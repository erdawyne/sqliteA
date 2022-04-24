package com.example.sqlitea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kelasasqlite.database.AppController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {
    private TextInputEditText tNama, tTelpon;
    private Button simpanBtn;
    String nm, tlp;
    AppController controller = new AppController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = (TextInputEditText) findViewById(R.id.tietNama);
        tTelpon = (TextInputEditText) findViewById(R.id.tietTelpon);
        simpanBtn = (Button) findViewById(R.id.buttonSave);

        simpanBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(tNama.getText().toString().equals("")||tTelpon.getText().equals("")){
                    Toast.makeText(getApplicationContext(), "Data is not completed!", Toast.LENGTH_SHORT).show();
                }
                else{
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("nama",nm);
                    qvalues.put("telpon",tlp);

                    controller.insertData(qvalues);
                    callHome();

                }
            }
        });

    }
    public void callHome(){
        Intent intent = new Intent(TemanBaru.this, com.example.kelasasqlite.MainActivity.class);
        startActivity(intent);
        finish();
    }
}