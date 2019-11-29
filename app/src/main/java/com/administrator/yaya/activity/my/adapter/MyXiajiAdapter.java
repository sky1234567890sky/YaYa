package com.administrator.yaya.activity.my.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestMyInvite;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyXiajiAdapter extends RecyclerView.Adapter<MyXiajiAdapter.Vh> {
    private final List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> list;


    private Context context;

    public MyXiajiAdapter(List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.xiaji_item, viewGroup, false);
        return new Vh(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {

        TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean paramsBean = list.get(i);
        vh.xiajiId.setText("用户ID:"+paramsBean.getUserId());
        Glide.with(context).load(paramsBean.getUserHeadImg()).placeholder(R.mipmap.icon).into(vh.xiajiHeadleriv);
        vh.xiajiRabaterecordName.setText("用户昵称："+paramsBean.getUserName()+"");

        if (TextUtils.isEmpty(String.valueOf(paramsBean.getUserContributeTotal()))){
            vh.xiajiJilleigongxian.setText("￥0");
        }else{
            vh.xiajiJilleigongxian.setText("￥"+paramsBean.getUserContributeTotal()+"");
        }

        if (TextUtils.isEmpty(paramsBean.getJunior())){
            vh.xiajiJinrigongxian.setText("￥0");
        }else{
            vh.xiajiJinrigongxian.setText("￥"+paramsBean.getJunior()+"");

        }

        int userLevel = paramsBean.getUserLevel();
        String userLevelName = paramsBean.getUserLevelName();
        int [] iv = {R.mipmap.icon_huangjin,R.mipmap.icon_bojin,R.mipmap.icon_zuanshi,R.mipmap.icon_wangzhe,R.mipmap.icon_xingyao};
        if (userLevel == 1){
            Glide.with(context).load(iv[0]).placeholder(R.mipmap.icon).into(vh.dengji_iv1);
        }else  if (userLevel == 2){
            Glide.with(context).load(iv[1]).placeholder(R.mipmap.icon).into(vh.dengji_iv1);
        }else  if (userLevel == 3){
            Glide.with(context).load(iv[2]).placeholder(R.mipmap.icon).into(vh.dengji_iv1);
        }else  if (userLevel == 4){
            Glide.with(context).load(iv[3]).placeholder(R.mipmap.icon).into(vh.dengji_iv1);
        }else  if (userLevel == 5){
            Glide.with(context).load(iv[4]).placeholder(R.mipmap.icon).into(vh.dengji_iv1);
        }
    }
    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.xiaji_headleriv)
        ImageView xiajiHeadleriv;
        @BindView(R.id.xiaji_rabaterecord_name)
        TextView xiajiRabaterecordName;
        @BindView(R.id.xiaji_jinrigongxian)
        TextView xiajiJinrigongxian;
        @BindView(R.id.xiaji_id)
        TextView xiajiId;
        @BindView(R.id.xiaji_jilleigongxian)
        TextView xiajiJilleigongxian;

        @BindView(R.id.dengji_iv1)
        ImageView dengji_iv1;

        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
