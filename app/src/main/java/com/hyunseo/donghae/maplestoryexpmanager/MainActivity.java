package com.hyunseo.donghae.maplestoryexpmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mStartButton;
    private Button mEndButton;
    private Button mStart2Button;
    private Button mStart3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // R 파일이 없어질경우 Build Clean Project 실행해보자

        // 시작버튼과 종료버튼
        mStartButton = (Button) findViewById(R.id.start_bt);
        mStart2Button = (Button) findViewById(R.id.start2_bt);
        mEndButton = (Button) findViewById(R.id.end_bt);
        mStart3Button = (Button) findViewById(R.id.start3_bt);

        mStartButton.setOnClickListener(this);
        mStart2Button.setOnClickListener(this);
        mStart3Button.setOnClickListener(this);
        mEndButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_bt: {
                Intent intent = new Intent(this, Calculater_EXP.class);
                startActivity(intent);
                break;
            }
            case R.id.end_bt: {
                finish();
                break;
            }
            case R.id.start2_bt: {
                Intent intent = new Intent(this, LevelUpRoot.class);
                startActivity(intent);
                break;
            }
            case R.id.start3_bt: {
                Intent intent = new Intent(this, Calculater_Pro.class);
                startActivity(intent);
                break;
            }
        }
    }
}
