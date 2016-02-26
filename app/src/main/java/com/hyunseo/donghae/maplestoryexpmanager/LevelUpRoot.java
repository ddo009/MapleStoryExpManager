package com.hyunseo.donghae.maplestoryexpmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.mocoplex.adlib.AdlibActivity;

/**
 * Created by donghaechoi on 2016. 2. 14..
 */
public class LevelUpRoot extends AdlibActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox mCheckLoot1;
    private CheckBox mCheckLoot2;
    private CheckBox mCheckLoot3;
    private CheckBox mCheckLoot4;
    private TextView mVel1_1;
    private TextView mVel1_2;
    private TextView mVel1_3;
    private TextView mVel1_4;

    private TextView mVel2_1;
    private TextView mVel2_2;
    private TextView mVel2_3;

    private TextView mVel3_1;
    private TextView mVel3_2;
    private TextView mVel3_3;
    private TextView mVel3_4;
    private TextView mVel3_5;
    private TextView mVel3_6;

    private TextView mVel4_1;
    private TextView mVel4_2;
    private TextView mVel4_3;
    private Button mBackButton;
    private AdView adView;

//    protected void initAds() {
//        AdlibConfig.getInstance().bindPlatform("SHALLWEAD", "com.hyunseo.donghae.maplestoryexpmanager.SubAdlibAdViewShallWeAd");
//        setAdlibKey("56cfd4430cf27038eecfcb61");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level);
//        initAds();
//        this.setAdsContainer(R.id.ads);


        mBackButton = (Button) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(this);

        mCheckLoot1 = (CheckBox) findViewById(R.id.loot_1);
        mCheckLoot2 = (CheckBox) findViewById(R.id.loot_2);
        mCheckLoot3 = (CheckBox) findViewById(R.id.loot_3);
        mCheckLoot4 = (CheckBox) findViewById(R.id.loot_4);

        mCheckLoot1.setOnCheckedChangeListener(this);
        mCheckLoot2.setOnCheckedChangeListener(this);
        mCheckLoot3.setOnCheckedChangeListener(this);
        mCheckLoot4.setOnCheckedChangeListener(this);

        mVel1_1 = (TextView) findViewById(R.id.vel_1_1);
        mVel1_2 = (TextView) findViewById(R.id.vel_1_2);
        mVel1_3 = (TextView) findViewById(R.id.vel_1_3);
        mVel1_4 = (TextView) findViewById(R.id.vel_1_4);

        mVel2_1 = (TextView) findViewById(R.id.vel_2_1);
        mVel2_2 = (TextView) findViewById(R.id.vel_2_2);
        mVel2_3 = (TextView) findViewById(R.id.vel_2_3);

        mVel3_1 = (TextView) findViewById(R.id.vel_3_1);
        mVel3_2 = (TextView) findViewById(R.id.vel_3_2);
        mVel3_3 = (TextView) findViewById(R.id.vel_3_3);
        mVel3_4 = (TextView) findViewById(R.id.vel_3_4);
        mVel3_5 = (TextView) findViewById(R.id.vel_3_5);
        mVel3_6 = (TextView) findViewById(R.id.vel_3_6);

        mVel4_1 = (TextView) findViewById(R.id.vel_4_1);
        mVel4_2 = (TextView) findViewById(R.id.vel_4_2);
        mVel4_3 = (TextView) findViewById(R.id.vel_4_3);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (buttonView.getId() == mCheckLoot1.getId()) {
            if (isChecked) {
                mVel1_1.setVisibility(View.VISIBLE);
                mVel1_2.setVisibility(View.VISIBLE);
                mVel1_3.setVisibility(View.VISIBLE);
                mVel1_4.setVisibility(View.VISIBLE);
            } else {
                mVel1_1.setVisibility(View.GONE);
                mVel1_2.setVisibility(View.GONE);
                mVel1_3.setVisibility(View.GONE);
                mVel1_4.setVisibility(View.GONE);
            }
        }
        if (buttonView.getId() == mCheckLoot2.getId()) {
            if (isChecked) {
                mVel2_1.setVisibility(View.VISIBLE);
                mVel2_2.setVisibility(View.VISIBLE);
                mVel2_3.setVisibility(View.VISIBLE);
            } else {
                mVel2_1.setVisibility(View.GONE);
                mVel2_2.setVisibility(View.GONE);
                mVel2_3.setVisibility(View.GONE);
            }
        }
        if (buttonView.getId() == mCheckLoot3.getId()) {
            if (isChecked) {
                mVel3_1.setVisibility(View.VISIBLE);
                mVel3_2.setVisibility(View.VISIBLE);
                mVel3_3.setVisibility(View.VISIBLE);
                mVel3_4.setVisibility(View.VISIBLE);
                mVel3_5.setVisibility(View.VISIBLE);
                mVel3_6.setVisibility(View.VISIBLE);
            } else {
                mVel3_1.setVisibility(View.GONE);
                mVel3_2.setVisibility(View.GONE);
                mVel3_3.setVisibility(View.GONE);
                mVel3_4.setVisibility(View.GONE);
                mVel3_5.setVisibility(View.GONE);
                mVel3_6.setVisibility(View.GONE);
            }
        }
        if (buttonView.getId() == mCheckLoot4.getId()) {
            if (isChecked) {
                mVel4_1.setVisibility(View.VISIBLE);
                mVel4_2.setVisibility(View.VISIBLE);
                mVel4_3.setVisibility(View.VISIBLE);
            } else {
                mVel4_1.setVisibility(View.GONE);
                mVel4_2.setVisibility(View.GONE);
                mVel4_3.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
