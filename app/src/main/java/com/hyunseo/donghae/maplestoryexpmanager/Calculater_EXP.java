package com.hyunseo.donghae.maplestoryexpmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibConfig;

/**
 * Created by donghaechoi on 2016. 2. 11..
 */
public class Calculater_EXP extends AdlibActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    //    private Handler handler = new Handler();
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


    private int moogi = 74577; // 스타포스 정식기사E의 경험치
    private int olgil = 89158; // 기계덩어리 의 경험치 내부 5마리는 포함되어있지않음.
    private int miro = 129324; // 강제네B의 경험치

    private int moraedodeojui = 1145; // 사헬2 모래두더지 경험치
    private int saEti = 1399; // 관출 사이티 경험
    private int darkWivern = 22782; // 검와둥 다크와이번
    private int zombie = 16296; // 폐광 좀비

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

//    private AdView adView;

    private CheckBox mCheckLow;
    private CheckBox mCheckHigh;

    private double remainAimExp;
    private double remainMaxExp = 0;
    private CheckBox mBburigi;
    private CheckBox mDouble;
    private CheckBox mMersedes;
    private CheckBox mZero;
    private TextView mLowMonster;
    private TextView mHighMonster;
    private CheckBox mSimbolBuf;
    private CheckBox mSimbolBishop;
    private CheckBox mExtGold;
    private CheckBox mPotion;
    private CheckBox mCheckBuffTrue;
    private CheckBox mRingbuff;

    protected void initAds() {
        AdlibConfig.getInstance().bindPlatform("SHALLWEAD", "com.hyunseo.donghae.maplestoryexpmanager.SubAdlibAdViewShallWeAd");
        setAdlibKey("56cfd4430cf27038eecfcb61");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculater);
        initAds();
        this.setAdsContainer(R.id.ads);

//        adView = (AdView) findViewById(R.id.ads2);

//        mSpinner = (Spinner)
//        adView.shallweadsdk_v1_20160111.jarSubAdlibAdViewShallWeAd.javasetAdUnitId("ca-app-pub-2825752146789052/1929738325");
//        adView.setAdSize(AdSize.BANNER);
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.second_ads);
//        linearLayout.addView(adView);

//        AdRequest adRequest = new AdRequest.Builder().build();
//        .addTestDevice("8054C85383F6061D16FC3F831CCE9A45")
//        adView.loadAd(adRequest);

        // 현재 레벨
        mNowLv = (EditText) findViewById(R.id.now_lv);
        // 현재 경험치
        mNowExp = (EditText) findViewById(R.id.now_exp);
        // 목표 레벨
        mAimLv = (EditText) findViewById(R.id.aim_lv);

        // 프로그레스 바 아래 퍼센트가 출력되는 부분
        mProgressAimText = (TextView) findViewById(R.id.progressbar_aim_text);
        mProgressMaxText = (TextView) findViewById(R.id.progressbar_max_text);

        // 계산 시작 버튼
        mStartBt = (Button) findViewById(R.id.calculation_exp);
        mStartBt.setOnClickListener(this);

        // 최종 남은 경험치량 출력
        mResultText1 = (TextView) findViewById(R.id.result_1);
        mResultText2 = (TextView) findViewById(R.id.result_2);

        // 프로그레스바
        mAimBar = (ProgressBar) findViewById(R.id.how_to_aim_bar);
        mMaxBar = (ProgressBar) findViewById(R.id.how_to_max_bar);

        // low 몬스터
        mLowMonster = (TextView) findViewById(R.id.low_monster);
        // high 몬스터
        mHighMonster = (TextView) findViewById(R.id.high_monster);


        // 체크박스 두개
        mCheckLow = (CheckBox) findViewById(R.id.low_level);
        mCheckLow.setOnCheckedChangeListener(this);
        mCheckHigh = (CheckBox) findViewById(R.id.high_level);
        mCheckHigh.setOnCheckedChangeListener(this);

        // 버프창 보이기 체크박스
        mCheckBuffTrue = (CheckBox) findViewById(R.id.buff_to_checkbox);
        mCheckBuffTrue.setOnCheckedChangeListener(this);


        // 버프 체크박스
        mSimbolBuf = (CheckBox) findViewById(R.id.simbol_buff);
        mSimbolBuf.setOnCheckedChangeListener(this);
        mSimbolBishop = (CheckBox) findViewById(R.id.simbol_bishop);
        mSimbolBishop.setOnCheckedChangeListener(this);
        mBburigi = (CheckBox) findViewById(R.id.burning_check);
        mBburigi.setOnCheckedChangeListener(this);
        mDouble = (CheckBox) findViewById(R.id.double_check);
        mDouble.setOnCheckedChangeListener(this);
        mMersedes = (CheckBox) findViewById(R.id.mersedes_check);
        mMersedes.setOnCheckedChangeListener(this);
        mZero = (CheckBox) findViewById(R.id.zero_check);
        mZero.setOnCheckedChangeListener(this);
        mExtGold = (CheckBox) findViewById(R.id.ext_gold);
        mExtGold.setOnCheckedChangeListener(this);
        mPotion = (CheckBox) findViewById(R.id.exp_potion);
        mPotion.setOnCheckedChangeListener(this);
        mRingbuff = (CheckBox) findViewById(R.id.exp_ring);
        mRingbuff.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        // 빈칸이 없는지 확인함. 하나라도 비어있다면 아래 else문으로 감
        if (mNowLv.getText().length() != 0 && mAimLv.getText().length() != 0 && mNowExp.getText().length() != 0) {
            int nowLevelText = Integer.parseInt(mNowLv.getText().toString());
            int aimLevelText = Integer.parseInt(mAimLv.getText().toString());

            // start 버튼을 클릭시 시작됨.
            if (v.getId() == mStartBt.getId()) {

                // 잘못된 값이 입력 될 경우 Toast 메세지를  출력함
                if (nowLevelText == aimLevelText || nowLevelText <= 0 || aimLevelText < nowLevelText || aimLevelText > 250
                        || nowLevelText > 250 || Double.parseDouble(mNowExp.getText().toString()) < 0 || Double.parseDouble(mNowExp.getText().toString()) > mExpTable[nowLevelText - 1]) {
                    Toast.makeText(Calculater_EXP.this, "잘못된 값을 입력하셨습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    double sumNowExp = 0;
                    double sumAimExp = 0;

                    // 현재 Level 까지의 모든 경험치를 더함
                    for (int i = 0; i < Integer.parseInt(mNowLv.getText().toString()) - 1; i++) {
                        sumNowExp += mExpTable[i];
                    }
                    // 목표 Level 까지의 모든 경험치를 더함
                    for (int i = 0; i < Integer.parseInt(mAimLv.getText().toString()) - 1; i++) {
                        sumAimExp += mExpTable[i];
                    }
                    // 250 level 까지의 모든 경험치를 더함
                    if (remainMaxExp == 0) {
                        for (int i = 0; i < 249; i++) {
                            remainMaxExp += mExpTable[i];
                        }
                    }

                    // 현재 Level까지의 모든 경험치를 더한 값에
                    // 현재 경험치 값을 더함
                    sumNowExp += Double.parseDouble(mNowExp.getText().toString());

                    // 백분율을 구하는 식
                    double calculation1 = (sumNowExp / sumAimExp) * 100;
                    double calculation2 = (sumNowExp / remainMaxExp) * 100;

                    // 소수점 4번쨰 자리에서 반올림 하여 소수점 3자리까지만 나오게함.
                    double bar1 = Double.parseDouble(String.format("%.3f", calculation1));
                    double bar2 = Double.parseDouble(String.format("%.3f", calculation2));

                    double remainMaxDouble = remainMaxExp - sumNowExp; // 250까지 남은 경험치
                    remainAimExp = sumAimExp - sumNowExp; // 목표 까지 남은경험치


                    // 남은 경험치를 표시함.
                    mResultText1.setText(String.format("%,.0f", remainAimExp));
                    mResultText2.setText(String.format("%,.0f", remainMaxDouble));

                    // 남은 경험치의 퍼센트를 표시함.
                    mProgressAimText.setText(bar1 + "%");
                    mProgressMaxText.setText(bar2 + "%");

                    // 프로그레스바 세팅.
                    mAimBar.setProgress((int) bar1);
                    mMaxBar.setProgress((int) bar2);

                    findViewById(R.id.result_linear).setVisibility(View.VISIBLE);

                }
            }
        } else { // 한칸이라도 빈칸이 존재할 경우 들어오는 곳
            Toast.makeText(Calculater_EXP.this, "빈칸 없이 입력해주세요", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        double a = remainAimExp / moogi;
        double b = remainAimExp / olgil;
        double c = remainAimExp / miro;
        double d = remainAimExp / moraedodeojui;
        double e = remainAimExp / saEti;
        double f = remainAimExp / darkWivern;
        double g = remainAimExp / zombie;

        if (buttonView.getId() == mCheckLow.getId()) {
            if (isChecked) {
                StringBuffer sb = new StringBuffer();
                sb.append(String.format("사헬지대2에서 " + "%,.0f", d) + "마리의 몬스터를 잡아야합니다\n")
                        .append(String.format("관계자외 출입금지에서 " + "%,.0f", e) + "마리의 몬스터를 잡아야합니다\n")
                        .append(String.format("검은 와이번의 둥지에서 " + "%,.0f", f) + "마리의 몬스터를 잡아야합니다\n")
                        .append(String.format("폐광에서 " + "%,.0f", g) + "마리의 몬스터를 잡아야합니다");
                mLowMonster.setText(sb);
                mLowMonster.setVisibility(View.VISIBLE);
            } else {
                mLowMonster.setVisibility(View.GONE);
            }
        } else if (buttonView.getId() == mCheckHigh.getId()) {
            if (isChecked) {
                StringBuffer sb2 = new StringBuffer();
                sb2.append(String.format("무기고에서 " + "%,.0f", a) + "마리의 몬스터를 잡아야합니다\n")
                        .append(String.format("스올길에서 " + "%,.0f", b) + "마리의 몬스터를 잡아야합니다\n")
                        .append(String.format("미로5에서 " + "%,.0f", c) + "마리의 몬스터를 잡아야합니다");
                mHighMonster.setText(sb2);
                mHighMonster.setVisibility(View.VISIBLE);
            } else {
                mHighMonster.setVisibility(View.GONE);
            }

//            private int moogi = 74577; // 스타포스 정식기사E의 경험치
//            private int olgil = 89158; // 기계덩어리 의 경험치 내부 5마리는 포함되어있지않음.
//            private int miro = 129324; // 강제네B의 경험치
//            private int moraedodeojui = 1145; // 사헬2 모래두더지 경험치
//            private int saEti = 1399; // 관출 사이티 경험
//            private int darkWivern = 22782; // 검와둥 다크와이번
//            private int zombie = 16296;


        }
        if (buttonView.getId() != mCheckHigh.getId() && buttonView.getId() != mCheckLow.getId()) {

            if (mCheckLow.isChecked() == true) {
                mCheckLow.setChecked(false);
            }
            if (mCheckHigh.isChecked() == true) {
                mCheckHigh.setChecked(false);
            }

            if (buttonView.getId() == mBburigi.getId()) {
                if (isChecked) {
                    // 50퍼
                    moogi += 37288;
                    olgil += 44597;
                    miro += 64662;
                    moraedodeojui += 573;
                    saEti += 700;
                    darkWivern += 11391;
                    zombie += 8148;
                } else {
                    moogi -= 37288;
                    olgil -= 44597;
                    miro -= 64662;
                    moraedodeojui -= 573;
                    saEti -= 700;
                    darkWivern -= 1391;
                    zombie -= 8148;
                }
            } else if (buttonView.getId() == mDouble.getId()) {
                if (isChecked) {
                    // 2배
                    moogi += 74577;
                    olgil += 89158;
                    miro += 129324;
                    moraedodeojui += 1145;
                    saEti += 1399;
                    darkWivern += 22782;
                    zombie += 16296;
                } else {
                    moogi -= 74577;
                    olgil -= 89158;
                    miro -= 129324;
                    moraedodeojui -= 1145;
                    saEti -= 1399;
                    darkWivern -= 22782;
                    zombie -= 16296;
                }
            } else if (buttonView.getId() == mMersedes.getId()) {
                if (isChecked) {
                    // 15퍼센트
                    moogi += 11186;
                    olgil += 13373;
                    miro += 19398;
                    moraedodeojui += 171;
                    saEti += 210;
                    darkWivern += 3417;
                    zombie += 2444;
                } else {
                    moogi -= 11186;
                    olgil -= 13373;
                    miro -= 19398;
                    moraedodeojui -= 171;
                    saEti -= 210;
                    darkWivern -= 3417;
                    zombie -= 2444;
                }
            } else if (buttonView.getId() == mZero.getId()) {
                if (isChecked) {
                    // 10퍼센트
                    moogi += 7458;
                    olgil += 8916;
                    miro += 12932;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    moraedodeojui -= 115;
                    saEti -= 140;
                    darkWivern -= 2287;
                    zombie -= 1630;
                }
            } else if (buttonView.getId() == mSimbolBuf.getId()) {
                if (isChecked) {
                    mSimbolBishop.setEnabled(false);
                    moogi += 37288;
                    olgil += 44597;
                    miro += 64662;
                    moraedodeojui += 573;
                    saEti += 700;
                    darkWivern += 11391;
                    zombie += 8148;
                } else {
                    mSimbolBishop.setEnabled(true);
                    moogi -= 37288;
                    olgil -= 44597;
                    miro -= 64662;
                    moraedodeojui -= 573;
                    saEti -= 700;
                    darkWivern -= 11391;
                    zombie -= 8148;
                }
            } else if (buttonView.getId() == mSimbolBishop.getId()) {
                if (isChecked) {
                    mSimbolBuf.setEnabled(false);
                    moogi += 52204;
                    olgil += 62411;
                    miro += 90527;
                    moraedodeojui += 801;
                    saEti += 979;
                    darkWivern += 15947;
                    zombie += 11407;

                } else {
                    mSimbolBuf.setEnabled(true);
                    moogi -= 52204;
                    olgil -= 62411;
                    miro -= 90527;
                    moraedodeojui -= 801;
                    saEti -= 979;
                    darkWivern -= 15947;
                    zombie -= 11407;
                }
            } else if (buttonView.getId() == mExtGold.getId()) {
                if (isChecked) {
                    // 10퍼센트
                    moogi += 7458;
                    olgil += 8916;
                    miro += 12932;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    moraedodeojui -= 115;
                    saEti -= 140;
                    darkWivern -= 2287;
                    zombie -= 1630;
                }
            } else if (buttonView.getId() == mPotion.getId()) {
                if (isChecked) {
                    // 10퍼센트
                    moogi += 7458;
                    olgil += 8916;
                    miro += 12932;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    moraedodeojui -= 115;
                    saEti -= 140;
                    darkWivern -= 2287;
                    zombie -= 1630;
                }
            } else if (buttonView.getId() == mRingbuff.getId()){
                if (isChecked) {
                    // 10퍼센트
                    moogi += 7458;
                    olgil += 8916;
                    miro += 12932;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    moraedodeojui -= 115;
                    saEti -= 140;
                    darkWivern -= 2287;
                    zombie -= 1630;
                }
            }

        }
        if (buttonView.getId() == mCheckBuffTrue.getId()) {
            if (mCheckBuffTrue.isChecked()) {
                findViewById(R.id.vision_layout).setVisibility(View.VISIBLE);
            } else {
                findViewById(R.id.vision_layout).setVisibility(View.GONE);
            }
        }
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Thread threadSleep = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                    }
//                }
//            }
//        });
//        threadSleep.start();
//    }
}