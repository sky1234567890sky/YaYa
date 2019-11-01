package com.administrator.yaya.activity.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.administrator.yaya.R;
import com.administrator.yaya.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 游戏币说明
 */
public class GameMoneyExplainActivity extends BaseActivity {
    @BindView(R.id.game_money_explain_iv)

    ImageView systemMsgBackIv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_game_money_explain;
    }
    @OnClick(R.id.game_money_explain_iv)
    public void onViewClicked() {
        GameMoneyExplainActivity.this.finish();
    }
}