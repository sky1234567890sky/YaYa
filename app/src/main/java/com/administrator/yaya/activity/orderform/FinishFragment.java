package com.administrator.yaya.activity.orderform;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.administrator.yaya.R;
import com.administrator.yaya.fragment.OrderFormkFragment;

import static fm.jiecao.jcvideoplayer_lib.JCMediaManager.TAG;

/**
 * A simple {@link Fragment} subclass.
 * 已完成
 */
public class FinishFragment extends Fragment {
    private static final String TAG = "Fragment";
    private OrderFormkFragment parentFragment;

    public FinishFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_finish, container, false);
        parentFragment = (OrderFormkFragment) getParentFragment();




        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){


            View view = parentFragment.getView();
          TextView  mInventory_money = view.findViewById(R.id.inventory_money);

            mInventory_money.setText("weerrrtt");



            Bundle arguments = getArguments();
            int finish =arguments.getInt("finish");
            Log.d(TAG, "onCreateView: "+finish);
        }

    }

}
