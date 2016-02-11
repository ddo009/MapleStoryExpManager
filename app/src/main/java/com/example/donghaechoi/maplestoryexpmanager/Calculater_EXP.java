package com.example.donghaechoi.maplestoryexpmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by donghaechoi on 2016. 2. 11..
 */
public class Calculater_EXP extends AppCompatActivity implements View.OnClickListener {

    private final double[] mExpTable = {15, 34, 57, 92, 135, 372, 560, 840,
            1242, 1242, 1241, 1241, 1241, 1241, 1490, 1788, 2146, 2575, 3090,
            3708, 4450, 5340, 6408, 7690, 9228, 11074, 13289, 15947, 19136, 19136,
            19136, 19136, 19136, 19136, 22963, 27556, 33067, 39680, 47616, 51425,
            55539, 59982, 64781, 69963, 75560, 81605, 88133, 95184, 102799, 111023, 119905, 129497,
            139857, 151046, 163130, 176180, 190274, 205496, 221936, 239691, 258866, 279575, 301941,
            326096, 352184, 380359, 410788, 433651, 479143, 479143, 479143, 479143, 479143, 479143,
            512683, 548571, 586971, 629059, 672023, 719065, 769400, 823258, 880886, 943548, 1008526,
            1079123, 1154662, 1235448, 1321372, 1414510, 1513516, 1619473, 1732836, 1854135, 1983924,
            2122799, 2271395, 2430393, 2600521, 2782557, 2997336, 3185750, 3408758, 3647336, 3902682,
            4175870, 4468181, 4780954, 5115621, 5473714, 5856874, 6266855, 6705545, 7174922, 7677167,
            8214569, 8789589, 9404860, 10063200, 10063200, 10063200, 10063200, 10063200, 10063200, 10767624,
            11521358, 12357853, 13190803, 14114759, 15102150, 16159301, 17290452, 18500784, 19795839, 21281548,
            22664256, 24250754, 25948307, 27764188, 29708216, 31787791, 34102936, 36393842, 38941411, 41667310,
            44584022, 47704904, 51044247, 54617344, 58440558, 62531937, 66908595, 71592197, 76603651, 81965907,
            87703520, 93842766, 100411760, 107440583, 113887018, 120722023, 127963453, 135641260, 143779736,
            152406520, 161550911, 171243966, 181518604, 192409720, 203954303, 216191561, 229163055, 242912838,
            257478608, 272836864, 289313076, 306671861, 325072173, 344576503, 344576503, 378166159, 410396129,
            435019857, 461121091, 488788356, 518115657, 549202596, 582154752, 617084037, 654109079, 693355624,
            734956961, 779054379, 825797642, 875345501, 927866241, 983583205, 1042550497, 1105103527, 2207026470l,
            2648431764l, 3178118116l, 3813741739l, 4576490086l, 5491788103l, 6590145723l, 7908174867l, 9489809840l,
            11387771808l, 24142076232l, 25590600805l, 27126036853l, 28753599064l, 30478815007l, 32307543907l, 34245996541l,
            36300756333l, 38478801712l, 40787529814l, 84838062013l, 88231584493l, 91760847872l, 95431281786l, 99248533057l,
            103218474379l, 107347213354l, 111641101888l, 116106745963l, 120751015801l, 246332072234l, 251258713678l, 256283887951l,
            261409565710l, 266637757024l, 271970512164l, 277409922407l, 282958120855l, 288617283272l, 294389628937l, 594667050452l,
            600613720956l, 606619858165l, 612686056746l, 618812917313l, 625001046486l, 631251056950l, 637563567519l, 643939203194l,
            650378595225l};//1~249 EXP TABLE

    private Button mStartBt;
    private EditText mNowLv;
    private EditText mNowExp;
    private EditText mAimLv;
    private ProgressBar mAimBar;
    private ProgressBar mMaxBar;
    private TextView mResultText1;
    private TextView mResultText2;
    private TextView mProgressAimText;
    private TextView mProgressMaxText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculater);

        mNowLv = (EditText) findViewById(R.id.now_lv);
        mNowExp = (EditText) findViewById(R.id.now_exp);
        mAimLv = (EditText) findViewById(R.id.aim_lv);

        mProgressAimText = (TextView) findViewById(R.id.progressbar_aim_text);
        mProgressMaxText = (TextView) findViewById(R.id.progressbar_max_text);

        mStartBt = (Button) findViewById(R.id.calculation_exp);
        mStartBt.setOnClickListener(this);

        mResultText1 = (TextView) findViewById(R.id.result_1);
        mResultText2 = (TextView) findViewById(R.id.result_2);

        mAimBar = (ProgressBar) findViewById(R.id.how_to_aim_bar);
        mMaxBar = (ProgressBar) findViewById(R.id.how_to_max_bar);

    }

    @Override
    public void onClick(View v) {
        if (mNowLv.getText().length() != 0 && mAimLv.getText().length() != 0 && mNowExp.getText().length() != 0) {
            int nowLevelText = Integer.parseInt(mNowLv.getText().toString());
            int aimLevelText = Integer.parseInt(mAimLv.getText().toString());

            if (v.getId() == mStartBt.getId()) {
                if (mNowLv == null || mAimLv == null || nowLevelText <= 0 || aimLevelText < nowLevelText || aimLevelText > 250 ||
                        nowLevelText > 250 || Integer.parseInt(mNowExp.getText().toString()) < 0 || Integer.parseInt(mNowExp.getText().toString()) > mExpTable[nowLevelText]) {
                    Toast.makeText(Calculater_EXP.this, "잘못된 값을 입력하셨습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    double sumNowExp = 0;
                    double sumAimExp = 0;
                    double sumAim_Now_Exp;
                    double minusMax_Now_Exp = 0;
                    for (int i = 0; i < Integer.parseInt(mNowLv.getText().toString()) - 1; i++) {
                        sumNowExp += mExpTable[i];
                    }
                    for (int i = 0; i < Integer.parseInt(mAimLv.getText().toString()) - 1; i++) {
                        sumAimExp += mExpTable[i];
                    }
                    for (int i = 0; i < 249; i++) {
                        minusMax_Now_Exp += mExpTable[i];
                    }
                    if (mNowExp.getText().toString() != null) {
                        sumNowExp += Integer.parseInt(mNowExp.getText().toString());
                    }
                    double calculation1 = (sumNowExp / sumAimExp) * 100;
                    double calculation2 = (sumNowExp / minusMax_Now_Exp) * 100;

                    double bar1 = Double.parseDouble(String.format("%.3f", calculation1));
                    double bar2 = Double.parseDouble(String.format("%.3f", calculation2));

                    sumAim_Now_Exp = sumAimExp - sumNowExp; // 목표 까지 남은경험치
                    minusMax_Now_Exp -= sumNowExp; // 250까지 남은 경험치

                    mResultText1.setText("" + (long) sumAim_Now_Exp);
                    mResultText2.setText("" + (long) minusMax_Now_Exp);

                    mProgressAimText.setText(bar1 + "%");
                    mProgressMaxText.setText(bar2 + "%");

                    mAimBar.setVisibility(ProgressBar.VISIBLE);
                    mAimBar.incrementProgressBy((int) bar1);
                    mAimBar.setIndeterminate(true);
                    mMaxBar.setVisibility(ProgressBar.VISIBLE);
                    mMaxBar.incrementProgressBy((int) bar2);
                    mMaxBar.setIndeterminate(true);
                }
            }
        } else {
            Toast.makeText(Calculater_EXP.this, "빈칸 없이 입력해주세요", Toast.LENGTH_SHORT).show();
        }
    }
}
