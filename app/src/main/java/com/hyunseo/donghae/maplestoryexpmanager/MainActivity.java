package com.hyunseo.donghae.maplestoryexpmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mStartButton;
    private Button mEndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // R 파일이 없어질경우 Build Clean Project 실행해보자

        // 시작버튼과 종료버튼
        mStartButton = (Button) findViewById(R.id.start_bt);
        mEndButton = (Button) findViewById(R.id.end_bt);
        mStartButton.setOnClickListener(this);
        mEndButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_bt: {
                Intent intent = new Intent(this, Calculater_EXP.class);
                startActivity(intent);
            }
            case R.id.end_bt: {
                finish();
            }
        }
    }
}
