package com.administrator.yaya.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.administrator.yaya.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 库存
 */
public class InventoryFragment extends Fragment {

    @BindView(R.id.inventory_money)
    TextView inventoryMoney;
    @BindView(R.id.inventory_tab)
    TabLayout inventory_tab;
    @BindView(R.id.inventory_orderform)
    TextView inventoryOrderform;
    @BindView(R.id.inventory_iv)
    ImageView inventoryIv;
    @BindView(R.id.inventory_gamemoney)
    TextView inventoryGamemoney;
    @BindView(R.id.inventory_price)
    TextView inventoryPrice;
    @BindView(R.id.inventory_nummber)
    TextView inventoryNummber;
    @BindView(R.id.inventory_cancel_btn)
    TextView inventoryCancelBtn;
    @BindView(R.id.inventory_info_btn)
    TextView inventoryInfoBtn;
    @BindView(R.id.inventory_buy_time)
    TextView inventoryBuyTime;
    @BindView(R.id.inventory_pay_money)
    TextView inventoryPayMoney;
    Unbinder unbinder;

    @BindView(R.id.inventory_pay_money2)
    TextView inventoryPayMoney2;
    @BindView(R.id.inventory_up_btn)
    TextView inventoryUpBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initlistener();
        return view;

    }
    private void initView() {
        /**
         * tablayout切换时有显示隐藏效果，在一个界面上
         *
         */
        inventory_tab.addTab(inventory_tab.newTab().setText("待付款"));
        inventory_tab.addTab(inventory_tab.newTab().setText("已收款"));
    }

    private void initlistener() {
        inventory_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0://代付款
                        inventoryPayMoney.setVisibility(View.VISIBLE);
                        inventoryBuyTime.setVisibility(View.VISIBLE);
                        inventoryCancelBtn.setVisibility(View.VISIBLE);
                        inventoryPayMoney.setVisibility(View.VISIBLE);

                        inventoryUpBtn.setVisibility(View.GONE);
                        inventoryPayMoney2.setVisibility(View.GONE);
                        break;
                    case 1://已付款
                        inventoryPayMoney.setVisibility(View.GONE);
                        inventoryBuyTime.setVisibility(View.GONE);
                        inventoryCancelBtn.setVisibility(View.GONE);
                        inventoryPayMoney.setVisibility(View.GONE);
                        inventoryUpBtn.setVisibility(View.VISIBLE);
                        inventoryPayMoney2.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
