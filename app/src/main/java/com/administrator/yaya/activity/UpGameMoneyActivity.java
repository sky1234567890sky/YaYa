package com.administrator.yaya.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.administrator.yaya.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//上架游戏币
public class UpGameMoneyActivity extends AppCompatActivity {

    @BindView(R.id.upgame_back_iv)
    ImageView upgameBackIv;
    @BindView(R.id.tv_upgame_money_number2)
    TextView tvUpgameMoneyNumber2;
    @BindView(R.id.et_upgame_money_number2)
    EditText etUpgameMoneyNumber2;
    @BindView(R.id.upgame_money_rb1)
    RadioButton upgameMoneyRb1;
    @BindView(R.id.upgame_money_rb2)
    RadioButton upgameMoneyRb2;
    @BindView(R.id.upgame_money_rg)
    RadioGroup upgameMoneyRg;
    @BindView(R.id.up_btn)
    Button upBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_game_money);
        ButterKnife.bind(this);

        upgameMoneyRb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    upgameMoneyRb1.setBackground(getResources().getDrawable(R.mipmap.icon_shi));

                } else {
                    upgameMoneyRb1.setBackground(getResources().getDrawable(R.mipmap.icon_fou));

                }
            }
        });

        etUpgameMoneyNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    upgameBackIv.setVisibility(View.VISIBLE);
                } else {
                    upgameBackIv.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        upgameBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUpgameMoneyNumber2.clearComposingText();
            }
        });
    }

    @OnClick({R.id.upgame_back_iv, R.id.upgame_money_rb1, R.id.upgame_money_rb2, R.id.upgame_money_rg, R.id.up_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.upgame_back_iv:
                finish();
                break;
            case R.id.upgame_money_rb1:
                break;
            case R.id.upgame_money_rb2:
                break;
            case R.id.upgame_money_rg:
                break;
            case R.id.up_btn:
                break;
        }
    }
}
