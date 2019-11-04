package com.administrator.yaya.activity.my;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.bean.my.TestNotificationInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SystemMessagesAdapter extends RecyclerView.Adapter<SystemMessagesAdapter.Vh> {
    private final List<TestNotificationInfo.DataBean> list;

    private Context context;

    public SystemMessagesAdapter(List<TestNotificationInfo.DataBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.systemmessagesitem, null);
        return new Vh(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Vh vh, int i) {
        vh.systemMsgContent.setText(list.get(i).getUserName()+":"+list.get(i).getInfoContent());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class Vh extends RecyclerView.ViewHolder {
        @BindView(R.id.system_msg_content)
        TextView systemMsgContent;
        public Vh(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
