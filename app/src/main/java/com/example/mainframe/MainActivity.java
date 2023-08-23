package com.example.mainframe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

//import android.widget.TextView;

//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//    }
//}

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText, birthdayEditText, schoolEditText, majorEditText, homeEditText;
    // 다른 입력 필드 변수도 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰 요소 초기화
        nameEditText = findViewById(R.id.nameEditText);
        birthdayEditText = findViewById(R.id.birthdayEditText);
        schoolEditText = findViewById(R.id.schoolEditText);
        majorEditText = findViewById(R.id.majorEditText);
        homeEditText = findViewById(R.id.homeEditText);
        // 다른 입력 필드 초기화

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력된 정보 저장
                String name = nameEditText.getText().toString();
                String birthday = birthdayEditText.getText().toString();
                String school = schoolEditText.getText().toString();
                String major = majorEditText.getText().toString();
                String home = homeEditText.getText().toString();
                //다음 화면으로 이동
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("birthday", birthday);
                intent.putExtra("school", school);
                intent.putExtra("major", major);
                intent.putExtra("home", home);
                startActivity(intent);
            }
        });
    }
}

