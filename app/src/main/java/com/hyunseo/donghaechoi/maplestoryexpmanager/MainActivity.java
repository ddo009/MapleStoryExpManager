package com.hyunseo.donghaechoi.maplestoryexpmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private AdView adView;
    private Button mStartButton;
    private Button mEndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = (AdView) findViewById(R.id.ads1);

        AdRequest adRequest = new AdRequest.Builder().build();
//        .addTestDevice("8054C85383F6061D16FC3F831CCE9A45")
        adView.loadAd(adRequest);


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
