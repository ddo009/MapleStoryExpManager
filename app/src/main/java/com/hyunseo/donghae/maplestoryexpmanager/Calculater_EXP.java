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

/**
 * Created by donghaechoi on 2016. 2. 11..
 */
public class Calculater_EXP extends AdlibActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private final double[] mExpTable = {15, 34, 57, 92, 135, 372, 560, 840,
            1242, 1242, 1241, 1241, 1241, 1241, 1490, 1788, 2145, 2574, 3088,
            3705, 4446, 5335, 6402, 7682, 9218, 11061, 13273, 15927, 19112, 19112,
            19112, 19112, 19112, 19112, 22934, 27520, 33024, 39628, 47553, 51357,
            55465, 59902, 64694, 69869, 75458, 81494, 88013, 95054, 102658, 110870, 119739,
            129318, 139663, 150836, 162902, 175934, 190008, 205208, 221624, 221624, 221624, 221624, 221624,
            221624, 238245, 256113, 275321, 295970, 318167, 342029, 367681, 395257, 424901, 456768,
            488741, 522952, 559558, 598727, 640637, 685481, 733464, 784806, 839742, 898523, 961419,
            1028718, 1100728, 1177778, 1260222, 1342136, 1429374, 1522283, 1621231, 1726611, 1838840,
            1958364, 2085657, 2221224, 2365603, 2365603, 2365603, 2365603, 2365603, 2365603, 2519367,
            2683125, 2857528, 3043267, 3241079, 3451749, 3676112, 3915059, 4169537, 4440556, 4729192,
            5036589, 5363967, 5712624, 6083944, 6479400, 6900561, 7349097, 7826788, 8335529, 8877338,
            9454364, 10068897, 10723375, 11420394, 12162719, 12953295, 13795259, 14691950, 15646926, 16663976,
            17747134, 18900697, 20129242, 21437642, 22777494, 24201087, 25713654, 27320757, 29028304, 30842573,
            32770233, 34818372, 36994520, 39306677, 41763344, 44373553, 47146900, 50093581, 53224429, 56550955,
            60085389, 63840725, 67830770, 72070193, 76574580, 81360491, 86445521, 91848366, 97588888,
            103688193, 110168705, 117054249, 124370139, 132143272, 140402226, 149177365, 158500950, 168407259,
            178932712, 190116006, 201998256, 214623147, 228037093, 242289411, 256826775, 272236381, 288570563,
            305884796, 324237883, 343692155, 364313684, 386172505, 409342855, 433903426, 459937631, 487533888,
            516785921, 547793076, 580660660, 615500299, 652430316, 691576134, 733070702, 777054944, 2207026470L,
            2648431764L, 3178118116L, 3813741739L, 4576490086L, 5491788103L, 6590145723L, 7908174867L, 9489809840L,
            11387771808L, 24142076232L, 25590600805L, 27126036853L, 28753599064L, 30478815007L, 32307543907L, 34245996541L,
            36300756333L, 38478801712L, 40787529814L, 84838062013L, 88231584493L, 91760847872L, 95431281786L, 99248533057L,
            103218474379L, 107347213354L, 111641101888L, 116106745963L, 120751015801L, 246332072234L, 251258713678L, 256283887951L,
            261409565710l, 266637757024l, 271970512164l, 277409922407l, 282958120855l, 288617283272l, 294389628937l, 594667050452l,
            600613720956l, 606619858165l, 612686056746l, 618812917313l, 625001046486l, 631251056950l, 637563567519l, 643939203194l,
            650378595225l};//1~249EXPTABLE};//1~249 EXP TABLE


    private int moogi = 74577; // 스타포스 정식기사E의 경험치
    private int olgil = 89158; // 기계덩어리 의 경험치 내부 5마리는 포함되어있지않음.
    private int miro = 129324; // 강제네B의 경험치
    private int ohwen = 129324; // 상왼줄
    private int ohjul = 124604; // 상오줄

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
    private CheckBox mReadyPendent;

    protected void initAds() {
        setAdlibKey("56cfd4430cf27038eecfcb61");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculater);
        initAds();
        this.setAdsContainer(R.id.ads);

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
        mReadyPendent = (CheckBox) findViewById(R.id.ready_pendent);
        mReadyPendent.setOnCheckedChangeListener(this);


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
//                        sumNowExp += mExpTable[i];
                        sumNowExp += mExpTable[i];
                    }
                    // 목표 Level 까지의 모든 경험치를 더함
                    for (int i = 0; i < Integer.parseInt(mAimLv.getText().toString()) - 1; i++) {
//                        sumAimExp += mExpTable[i];
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
        double ohwens = remainAimExp / ohwen;
        double ohjuls = remainAimExp / ohjul;
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
                        .append(String.format("상왼줄에서 " + "%,.0f", ohwens) + "마리의 몬스터를 잡아야합니다\n")
                        .append(String.format("상오줄에서 " + "%,.0f", ohjuls) + "마리의 몬스터를 잡아야합니다\n")
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
//            private int ohjul = 124604; // 상오줄


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
                    ohwen += 64662;
                    ohjul += 62302;
                    moraedodeojui += 573;
                    saEti += 700;
                    darkWivern += 11391;
                    zombie += 8148;
                } else {
                    moogi -= 37288;
                    olgil -= 44597;
                    miro -= 64662;
                    ohwen -= 64662;
                    ohjul -= 62302;
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
                    ohwen += 129324;
                    ohjul += 124604;
                    moraedodeojui += 1145;
                    saEti += 1399;
                    darkWivern += 22782;
                    zombie += 16296;
                } else {
                    moogi -= 74577;
                    olgil -= 89158;
                    miro -= 129324;
                    ohwen -= 129324;
                    ohjul -= 124604;
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
                    ohwen += 19398;
                    ohjul += 18690;
                    moraedodeojui += 171;
                    saEti += 210;
                    darkWivern += 3417;
                    zombie += 2444;
                } else {
                    moogi -= 11186;
                    olgil -= 13373;
                    miro -= 19398;
                    ohwen -= 19398;
                    ohjul -= 18690;
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
                    ohwen += 12932;
                    ohjul += 12460;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    ohwen -= 12932;
                    ohjul -= 12460;
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
                    ohwen += 64662;
                    ohjul += 62302;
                    moraedodeojui += 573;
                    saEti += 700;
                    darkWivern += 11391;
                    zombie += 8148;
                } else {
                    mSimbolBishop.setEnabled(true);
                    moogi -= 37288;
                    olgil -= 44597;
                    miro -= 64662;
                    ohjul -= 62302;
                    ohwen -= 64662;
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
                    ohwen += 90527;
                    ohjul += 87223;
                    moraedodeojui += 801;
                    saEti += 979;
                    darkWivern += 15947;
                    zombie += 11407;

                } else {
                    mSimbolBuf.setEnabled(true);
                    moogi -= 52204;
                    olgil -= 62411;
                    miro -= 90527;
                    ohwen -= 90527;
                    ohjul -= 87223;
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
                    ohwen += 12932;
                    ohjul += 12406;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    ohwen -= 12932;
                    ohjul -= 12406;
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
                    ohwen += 12932;
                    ohjul += 12406;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    ohwen -= 12932;
                    ohjul -= 12406;
                    moraedodeojui -= 115;
                    saEti -= 140;
                    darkWivern -= 2287;
                    zombie -= 1630;
                }
            } else if (buttonView.getId() == mRingbuff.getId()) {
                if (isChecked) {
                    // 10퍼센트
                    moogi += 7458;
                    olgil += 8916;
                    miro += 12932;
                    ohwen += 12932;
                    ohjul += 12406;
                    moraedodeojui += 115;
                    saEti += 140;
                    darkWivern += 2287;
                    zombie += 1630;
                } else {
                    moogi -= 7458;
                    olgil -= 8916;
                    miro -= 12932;
                    ohwen -= 12932;
                    ohjul -= 12406;
                    moraedodeojui -= 115;
                    saEti -= 140;
                    darkWivern -= 2287;
                    zombie -= 1630;
                }
            } else if (buttonView.getId() == mReadyPendent.getId()) {
                if (isChecked) {
                    moogi += 22373;
                    olgil += 26747;
                    miro += 38797;
                    ohwen += 38797;
                    ohjul += 37381;
                    moraedodeojui += 343;
                    saEti += 420;
                    darkWivern += 6834;
                    zombie += 4889;
                } else {
                    moogi -= 22373;
                    olgil -= 26747;
                    miro -= 38797;
                    ohwen -= 38797;
                    ohjul -= 37381;
                    moraedodeojui -= 343;
                    saEti -= 420;
                    darkWivern -= 6834;
                    zombie -= 4889;
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
}