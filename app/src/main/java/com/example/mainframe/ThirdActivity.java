package com.example.mainframe;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class ThirdActivity extends AppCompatActivity {

    private int selectedButtonNumber = -1; // 선택한 버튼 번호 초기값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // 페이지 번호 표시
        TextView pageNumberTextView = findViewById(R.id.pageNumberTextView);
        pageNumberTextView.setText("3/5");

        // 버튼 클릭 이벤트 및 색상 변경
        for (int i = 1; i <= 15; i++) {
            String buttonId = "button" + i;
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            Button button = findViewById(resId);
            final int buttonNumber = i;

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 선택한 버튼 색상 변경
                    if (selectedButtonNumber != -1) {
                        String selectedButtonId = "button" + selectedButtonNumber;
                        int selectedButtonResId = getResources().getIdentifier(selectedButtonId, "id", getPackageName());
                        Button selectedButton = findViewById(selectedButtonResId);
                        //selectedButton.setBackgroundColor(Color.WHITE);
                        selectedButton.setBackgroundColor(android.R.drawable.btn_default);
                    }
                    view.setBackgroundColor(Color.parseColor("#C0C0C0"));
                    selectedButtonNumber = buttonNumber;
                }
            });
        }

        // 넘어가기 버튼
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 선택한 버튼 번호를 다음 화면으로 전달
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra("selectedButtonNumber", selectedButtonNumber);
                startActivity(intent);
            }
        });
    }
}
