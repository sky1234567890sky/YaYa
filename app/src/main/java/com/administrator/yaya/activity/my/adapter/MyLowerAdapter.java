package com.administrator.yaya.activity.my.adapter;

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
import com.administrator.yaya.bean.my.TestMyInvite;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
//我的下级
public class MyLowerAdapter extends RecyclerView.Adapter<MyLowerAdapter.Vh> {
    private final List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> list;
    private Context context;
    public MyLowerAdapter(List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> juniorUsers) {
        this.list = juniorUsers;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        //我的下級佈局
        View inflate = LayoutInflater.from(context).inflate(R.layout.mylower_item, null);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
        TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean juniorUsersBean = list.get(i);
//        Object userHeadImg = juniorUsersBean.getUserHeadImg();  null
//        Object userNickName = juniorUsersBean.getUserNickName(); null
        int userId = juniorUsersBean.getUserId();
        vh.mId.setText("用户ID："+userId);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.name_headler)
        ImageView mHeadlerIv;
        @BindView(R.id.myincome_rabaterecord_name)
        TextView mName;
        @BindView(R.id.myincome_putaway_number_tv)
        TextView mId;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
