package com.hyunseo.donghae.maplestoryexpmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by donghaechoi on 2016. 2. 17..
 */
public class StarForce_Calculater extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private CheckBox mCheckBox;
    private TextView mPlusOptionTxt;
    private EditText mAllAtkEdit;
    private EditText mOptionEdit;
    private EditText mStarQuntityEdit;
    private EditText mNowAtkEdit;
    private Button mCalculationBtn;
    private TextView mResultStar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starforce);


        mCheckBox = (CheckBox) findViewById(R.id.cehck_box);
        mCheckBox.setOnCheckedChangeListener(this);

        mPlusOptionTxt = (TextView) findViewById(R.id.plus_option);
        mAllAtkEdit = (EditText) findViewById(R.id.all_atk);
        mOptionEdit = (EditText) findViewById(R.id.option);
        mNowAtkEdit = (EditText) findViewById(R.id.now_atk);
        mStarQuntityEdit = (EditText) findViewById(R.id.star_quantity);

        mCalculationBtn = (Button) findViewById(R.id.calculation_btn);
        mCalculationBtn.setOnClickListener(this);

        mResultStar = (TextView) findViewById(R.id.result_star);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            StringBuffer sb = new StringBuffer();
            sb.append("[전사 무기 추가 옵션]\n- 한손도끼 : 0, 20, 29, 40, 53, 68\n- 한손둔기 : 0, 20, 29, 40, 53, 68\n- 한손검 : 0, 20, 29, 40, 53, 68\n- 두손도끼 : 0, 21, 31, 42, 55, 71\n- 두손둔기 : 0, 21, 31, 42, 55, 71\n- 두손검 : 0, 21, 31, 42, 55, 71\n- 데스페라도 : 0, 21, 31, 42, 55, 71\n- 창 : 0, 21, 31, 42, 55, 71\n- 폴암 : 0, 19, 27, 38, 49, 63\n- 제로무기 : 0, 8, 17, 28, 40, 55\n\n");
            sb.append("[법사 무기 추가 옵션]\n- 완드 : 0, 25, 36, 49, 65, 83\n- 스태프 : 0, 25, 36, 50, 66, 84\n- 샤이닝로드 : 0, 25, 36, 49, 65, 83\n- ESP리미터 : 0, 25, 36, 50, 66, 84\n\n");
            sb.append("[궁수 무기 추가 옵션]\n- 석궁 : 0, 20, 29, 40, 53, 68\n- 활 : 0, 20, 29, 39, 52, 66\n- 듀얼보우건 : 0,20, 29, 39, 52, 66\n\n");
            sb.append("[도적 무기 추가 옵션]\n- 단검 : 0, 20, 29, 39, 52, 66\n- 아대 : 0, 11, 16, 21, 28, 36\n- 에너지소드 : 0, 16, 23, 31, 41, 53\n- 케인 : 0, 20, 29, 40, 53, 68\n\n");
            sb.append("[해적 무기 추가 옵션]\n- 너클 : 0, 16, 23, 31, 41, 53\n- 총 : 0, 15, 22, 31, 40, 52\n- 에너지소드 : 0, 16, 23, 31, 41, 53\n- 소울슈터 : 0, 16, 23, 31, 41, 53\n- 캐논 : 0, 21, 31, 43, 56, 72");
            mPlusOptionTxt.setText(sb);
        } else {
            mPlusOptionTxt.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        int total = Integer.parseInt(mAllAtkEdit.getText().toString());
        int added = Integer.parseInt(mOptionEdit.getText().toString());
        int stan = Integer.parseInt(mNowAtkEdit.getText().toString());
        int star = Integer.parseInt(mStarQuntityEdit.getText().toString());
        int cur = total - added;
        int temp;
        int minus;

        if (v.getId() == mCalculationBtn.getId()) {
            for (int i = 1; i <= star; star--) {
                if (star <= 15) {
                    if (cur < 50 && cur > 1) {
                        minus = 1;
                        cur -= minus;
                    } else if (cur < 100 && cur >= 50) {
                        minus = 2;
                        cur -= minus;
                    } else if (cur < 150 && cur >= 100) {
                        minus = 3;
                        cur -= minus;
                    } else if (cur < 200 && cur >= 150) {
                        minus = 4;
                        cur -= minus;
                    } else if (cur < 250 && cur >= 200) {
                        minus = 5;
                        cur -= minus;
                    } else if (cur < 300 && cur >= 250) {
                        minus = 6;
                        cur -= minus;
                    } else if (cur >= 300) {
                        minus = 7;
                        cur -= minus;
                    }
                }
                if (star > 15) {
                    minus = star - 8;
                    cur -= minus;
                }


            }
        }
        mResultStar.setText(Integer.toString(cur));
    }
}

