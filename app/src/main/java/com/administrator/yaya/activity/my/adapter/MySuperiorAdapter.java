package com.administrator.yaya.activity.my.adapter;

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
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MySuperiorAdapter extends RecyclerView.Adapter<MySuperiorAdapter.Vh> {
    private final List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> myLowerList;
    private Context context;

    public MySuperiorAdapter(List<TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean> myLowerList) {

        this.myLowerList = myLowerList;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        //我的下級佈局
        View inflate = LayoutInflater.from(context).inflate(R.layout.mysuperior_item, null);
        return new Vh(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
        TestMyInvite.DataBean.UserInfoBean.JuniorUsersBean parentUserBean = myLowerList.get(i);
        vh.mMysuperiorJunior.setText(parentUserBean.getJunior()+"");
        vh.mMysuperiorRabaterecordName.setText(parentUserBean.getUserName()+"");
        vh.mMysuperiorPutawayNumberTv.setText("用户ID:"+parentUserBean.getUserId()+"");
        vh.mMysuperiorUserContributeTotal.setText("积累贡献："+parentUserBean.getUserContributeTotal()+"");
        RequestOptions requestOptions = new RequestOptions().centerCrop();
        Glide.with(context).load(parentUserBean.getUserHeadImg()).apply(requestOptions).placeholder(R.mipmap.icon).into(vh.mMysuperiorHeadleriv);

    }
    @Override
    public int getItemCount() {
        return myLowerList.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.mysuperior_headleriv)
        ImageView mMysuperiorHeadleriv;
        @BindView(R.id.mysuperior_rabaterecord_name)
        TextView mMysuperiorRabaterecordName;
        @BindView(R.id.mysuperior_junior)
        TextView mMysuperiorJunior;
        @BindView(R.id.mysuperior_putaway_number_tv)
        TextView mMysuperiorPutawayNumberTv;
        @BindView(R.id.mysuperior_userContributeTotal)
        TextView mMysuperiorUserContributeTotal;
        @BindView(R.id.mysuperior_add_number)
        TextView mMysuperiorAddNumber;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
