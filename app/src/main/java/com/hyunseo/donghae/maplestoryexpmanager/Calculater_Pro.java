package com.hyunseo.donghae.maplestoryexpmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by donghaechoi on 2016. 2. 25..
 */
public class Calculater_Pro extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditNowLv;
    private EditText mEditNowExp;
    private EditText mEditAimLv;
    private TextView mTextAimExp;
    private TextView mTextMaxExp;

    // 성향 경험치 테이블
    private final static double PRO_EXP[] = {20, 26, 34, 44, 57, 74, 96, 125, 163, 212, 233, 256, 282, 310, 341, 375, 413, 454, 499, 549, 565, 582, 599,
            617, 636, 655, 675, 695, 716, 737, 748, 759, 770, 782, 794, 806, 818, 830, 842, 855, 868, 881, 894, 907, 921, 935, 949, 963, 977, 992, 1022, 1037, 1053, 1069,
            1085, 1101, 1118, 1135, 1152, 1169, 1187, 1205, 1223, 1241, 1260, 1279, 1298, 1317, 1337, 1341, 1345, 1349, 1353, 1357, 1361, 1365, 1369, 1373, 1377, 1381, 1385,
            1389, 1393, 1397, 1401, 1405, 1409, 1413, 1417, 1421, 1425, 1429, 1433, 1437, 1441, 1445, 1449, 1453, 1457};
    private TextView mResultTxt1;
    private TextView mResultTxt2;
    private ProgressBar mAimBar;
    private ProgressBar mMaxBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.propensity_activity);

        // 현재 성향 레벨
        mEditNowLv = (EditText) findViewById(R.id.now_prolv);
        // 현재 경험치
        mEditNowExp = (EditText) findViewById(R.id.now_proexp);
        // 목표 레벨
        mEditAimLv = (EditText) findViewById(R.id.aim_prolv);

        // 결과 TEXT창

        mTextAimExp = (TextView) findViewById(R.id.aimpro_txt);
        mTextMaxExp = (TextView) findViewById(R.id.max_protxt);

        mResultTxt1 = (TextView) findViewById(R.id.result_pro1);
        mResultTxt2 = (TextView) findViewById(R.id.result_pro2);

        mAimBar = (ProgressBar) findViewById(R.id.aim_probar);
        mMaxBar = (ProgressBar) findViewById(R.id.max_probar);


        findViewById(R.id.calculation_pro_exp).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (mEditNowLv.getText().length() != 0 && mEditAimLv.getText().length() != 0 && mEditNowExp.getText().length() != 0) {

            double nowLevelText = Double.parseDouble(mEditNowLv.getText().toString());
            double aimLevelText = Double.parseDouble(mEditAimLv.getText().toString());

            if (nowLevelText > 100 || nowLevelText <= 0 || aimLevelText > 100 || aimLevelText < nowLevelText ||
                    Integer.parseInt(mEditNowExp.getText().toString()) > PRO_EXP[(int) nowLevelText]) {
                Toast.makeText(Calculater_Pro.this, "잘못된 값을 입력하셨습니다.", Toast.LENGTH_SHORT).show();
            } else {

                double sumNowExp = 0;
                double sumAimExp = 0;
                double remainExp = 0;


                for (int i = 0; i < nowLevelText - 1; i++) {
                    sumNowExp += PRO_EXP[i];
                }
                for (int i = 0; i < aimLevelText - 1; i++) {
                    sumAimExp += PRO_EXP[i];
                }
                for (int i = 0; i < PRO_EXP.length; i++) {
                    remainExp += PRO_EXP[i];
                }

                // 현재 경험치에 현재까지 더해진 경험치를 더함
                sumNowExp += nowLevelText;

                // 백분율 구하는 식
                double calculation1 = (sumNowExp / sumAimExp) * 100;
                double calculation2 = (sumNowExp / remainExp) * 100;

                // 소수점 3자리 까지만 나오게
                double bar1 = Double.parseDouble(String.format("%.3f", calculation1));
                double bar2 = Double.parseDouble(String.format("%.3f", calculation2));

                double remainMaxDouble = remainExp - sumNowExp; // 100까지 남은 경험치
                double remainAimExp = sumAimExp - sumNowExp; // 목표 까지 남은경험치

                // 남은 경험치양 표시
                mResultTxt1.setText(String.format("%,.0f", remainAimExp));
                mResultTxt2.setText(String.format("%,.0f", remainMaxDouble));

                // 남은 경험치의 퍼센트를 표시함.
                mTextAimExp.setText(bar1 + "%");
                mTextMaxExp.setText(bar2 + "%");
            }

        } else {
            Toast.makeText(Calculater_Pro.this, "빈칸 없이 입력해주세요", Toast.LENGTH_SHORT).show();
        }
    }
}
