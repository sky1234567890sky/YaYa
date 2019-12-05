package com.administrator.yaya.activity.my.rankinga_dapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.ranking.TestTodayRanking;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//今日排行适配器
public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.Vh> {
    private final ArrayList<TestTodayRanking.DataBean.ListBean> list;
    private Context context;
    private TestTodayRanking.DataBean.UserInfoTopBean userInfoTop;

    public TodayAdapter(ArrayList<TestTodayRanking.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(context).inflate(R.layout.today_item, viewGroup, false);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {

        TestTodayRanking.DataBean.ListBean listBean = list.get(i);
//        userInfoTop  当前用户信息
        int id1 = userInfoTop.getId();
//        id   排名
        String uname1 = userInfoTop.getUname();
//        uname  名称
        int ucount1 = userInfoTop.getUcount();
//        ucount  成交单数

//        list:   排行榜信息集合
//        id   排名
        int id = listBean.getId();
//        uname  名称
        String uname = listBean.getUname();
//        ucount  成交单数
        int ucount = listBean.getUcount();

        vh.mChengjiaoDan.setText("成交"+ucount+"单");
        vh.mName.setText(uname);

        if (id==1){
            //显示
            vh.mTvDengji.setVisibility(View.GONE);
            vh.mImgDengji.setVisibility(View.VISIBLE);
            Glide.with(context).load(R.mipmap.icon_no1).into(vh.mImgDengji);
        }else if (id==2){
            //显示
            vh.mTvDengji.setVisibility(View.GONE);
            vh.mImgDengji.setVisibility(View.VISIBLE);
            Glide.with(context).load(R.mipmap.icon_no2).into(vh.mImgDengji);
        }else if (id==3){
            //显示
            vh.mTvDengji.setVisibility(View.GONE);
            vh.mImgDengji.setVisibility(View.VISIBLE);
            Glide.with(context).load(R.mipmap.icon_no3).into(vh.mImgDengji);
        }else if (id==4){
            vh.mName.setText(uname);
        } else{
            vh.mTvDengji.setText(id+"");
        }
    }
    @Override
    public int getItemCount() {
        return list!=null ? list.size() : 0;
    }

    public void setData(TestTodayRanking.DataBean.UserInfoTopBean userInfoTop) {

        this.userInfoTop = userInfoTop;
        notifyDataSetChanged();
    }

    class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.today_img_dengji)//排名 图片
        ImageView mImgDengji;
        @BindView(R.id.today_tv_dengji)//排名 字体
        TextView mTvDengji;
        @BindView(R.id.taday_name)// 姓名
        TextView mName;
        @BindView(R.id.today_chengjiao_dan)//成绩单
        TextView mChengjiaoDan;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
