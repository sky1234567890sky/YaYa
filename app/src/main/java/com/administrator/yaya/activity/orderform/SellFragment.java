package com.administrator.yaya.activity.orderform;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.fragment.OrderFormkFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 售卖中
 */
public class SellFragment extends Fragment {
    private static final String TAG = "Fragment";
    @BindView(R.id.sell_lv)
    RecyclerView sellLv;
    Unbinder unbinder;
    private View view1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        unbinder = ButterKnife.bind(this, view);

        OrderFormkFragment parentFragment = (OrderFormkFragment) getParentFragment();

        view1 = parentFragment.getView();

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            Bundle arguments = getArguments();
            int selly =  arguments.getInt("selly");
            Log.d(TAG, "onCreateView: "+selly);
            TextView mInventory_money = view1.findViewById(R.id.inventory_money);
            mInventory_money.setText("1111111111111");
        }
    }
}
