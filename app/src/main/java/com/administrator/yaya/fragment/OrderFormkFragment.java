package com.administrator.yaya.fragment;
import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import com.administrator.yaya.R;
import com.administrator.yaya.activity.orderform.CancelFragment;
import com.administrator.yaya.activity.orderform.FinishFragment;
import com.administrator.yaya.activity.orderform.SellFragment;
import com.administrator.yaya.adapter.home.OrderFormAdapter;
import com.administrator.yaya.base.ApiConfig;
import com.administrator.yaya.base.BaseMvpFragment;
import com.administrator.yaya.base.CommonPresenter;
import com.administrator.yaya.base.ICommonView;
import com.administrator.yaya.bean.orderform.TestAllOrderStock;
import com.administrator.yaya.local_utils.SharedPrefrenceUtils;
import com.administrator.yaya.model.LoginModel;
import com.administrator.yaya.utils.NormalConfig;
import com.flyco.tablayout.SlidingTabLayout;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import butterknife.BindView;
/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFormkFragment extends BaseMvpFragment<LoginModel> implements ICommonView {

    @BindView(R.id.inventory_money)
    TextView mInventoryMoney;
    @BindView(R.id.tab_layout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.orderform_vp)
    ViewPager vp;
    private FragmentManager manager;
    private SellFragment sellFragment;
    private FinishFragment finishFragment;
    private CancelFragment cancelFragment;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private int num =1;
    public OrderFormkFragment() {
        // Required empty public constructor
    }
    @Override
    protected void initData() {
        super.initData();
        String userId = SharedPrefrenceUtils.getString(getContext(), NormalConfig.USER_ID);
        if (userId!=null) {
            mPresenter.getData(ApiConfig.TEST_ALL_ORDERSTOCK, Integer.parseInt(userId), num);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.TEST_ALL_ORDERSTOCK://所有售卖订单
                TestAllOrderStock testAllOrderStock = (TestAllOrderStock) t[0];
                if (testAllOrderStock.getCode() == 0 && testAllOrderStock.getData() != null && testAllOrderStock.getData().getCommodity() != null) {
                    String amount = testAllOrderStock.getData().getAmount();
                    mInventoryMoney.setText("今日收款："+amount);
                }
                break;
        }
     }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_formk;
    }
    @Override
    protected void initView(View view) {
        super.initView(view);
//        StatusBarUtil.setColor(getActivity(),getResources().getColor(R.color.blue));
        fragments = new ArrayList<>();
        titles = new ArrayList<>();

        sellFragment = new SellFragment();
        finishFragment = new FinishFragment();
        cancelFragment = new CancelFragment();

        fragments.add(sellFragment);
        fragments.add(finishFragment);
        fragments.add(cancelFragment);

        titles.add("售卖中");
        titles.add("已完成");
        titles.add("已取消");
//        Bundle bundle = new Bundle();
//        bundle.putInt("selly",1);
//        sellFragment.setArguments(bundle);/
//        Bundle bundle1 = new Bundle();
//        bundle1.putInt("finish",2);
//        finishFragment.setArguments(bundle1);
//        Bundle bundle2 = new Bundle();
//        bundle2.putInt("cancel",3);
//        cancelFragment.setArguments(bundle2);
        OrderFormAdapter orderFormAdapter = new OrderFormAdapter(getChildFragmentManager(),fragments,titles);
        vp.setAdapter(orderFormAdapter);
        tabLayout.setViewPager(vp);
//        tabLayout.setDistributeEvenly(true);
        vp.setCurrentItem(0);
        if (tabLayout.getTabCount()>1)tabLayout.setCurrentTab(0);
        orderFormAdapter.notifyDataSetChanged();
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel();
    }
    @Override
    protected CommonPresenter getPresenter() {
        return new CommonPresenter();
    }

    @Override
    public void onError(int whichApi, Throwable e) {

    }

}
