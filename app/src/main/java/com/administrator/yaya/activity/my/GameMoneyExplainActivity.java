package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.administrator.yaya.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 游戏币说明
 */
public class GameMoneyExplainActivity extends AppCompatActivity {
    @BindView(R.id.system_msg_back_iv)
    ImageView systemMsgBackIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO:游戏币说明界面
        setContentView(R.layout.activity_game_money_explain);
        overridePendingTransition(R.anim.from_right, R.anim.no_slide);//划入
        ButterKnife.bind(this);
    }

    @OnClick(R.id.system_msg_back_iv)
    public void onViewClicked() {
        finish();
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_slide, R.anim.out_right);//划出
    }
}
