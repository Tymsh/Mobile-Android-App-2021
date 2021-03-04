package umn.ac.id.week04_31135;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorialActivity extends AppCompatActivity {
    private Button btnHal1, btnHal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        btnHal1 = findViewById(R.id.main_button_change_1);
        btnHal2 = findViewById(R.id.main_button_change_2);

        btnHal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHal1 = new Intent(TutorialActivity.this, SecondActivity.class);
                startActivity(intentHal1);
            }
        });

        btnHal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHal2 = new Intent(TutorialActivity.this, ThirdActivity.class);
                startActivity(intentHal2);
            }
        });
    }
}