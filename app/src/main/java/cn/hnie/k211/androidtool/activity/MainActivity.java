package cn.hnie.k211.androidtool.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.hnie.k211.androidtool.R;
import cn.hnie.k211.androidtool.fragment.AboutFragment;
import cn.hnie.k211.androidtool.fragment.AccountbookFragment;
import cn.hnie.k211.androidtool.fragment.RetrieveSMSFragment;
import cn.hnie.k211.androidtool.fragment.SerarchFragment;
import cn.hnie.k211.androidtool.fragment.SoftwareHideFragment;


/**
 * 首页
 * create by gl on 2016.12.8
 */
public class MainActivity extends FragmentActivity {
    private FragmentTabHost mTabHost;
    private String[] mTabNameAry;
    private List<Class> mClzList;
    private int[] mTabIconIDAry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabAndFragmentClz();
        initViews();
    }

    private void initTabAndFragmentClz() {
        mTabNameAry = new String[5];
        mTabNameAry[0] = getString(R.string.bottom_tab_name_1);
        mTabNameAry[1] = getString(R.string.bottom_tab_name_2);
        mTabNameAry[2] = getString(R.string.bottom_tab_name_3);
        mTabNameAry[3] = getString(R.string.bottom_tab_name_4);
        mTabNameAry[4] = getString(R.string.bottom_tab_name_5);

        mClzList = new ArrayList<>();
        mClzList.add(SerarchFragment.class);              //全局搜索
        mClzList.add(SoftwareHideFragment.class);         //程序隐藏
        mClzList.add(AccountbookFragment.class);          //记账功能
        mClzList.add(RetrieveSMSFragment.class);          //短信找回
        mClzList.add(AboutFragment.class);                //关于我们

        mTabIconIDAry = new int[5];
        mTabIconIDAry[0] = R.mipmap.ic_launcher;
        mTabIconIDAry[1] = R.mipmap.ic_launcher;
        mTabIconIDAry[2] = R.mipmap.ic_launcher;
        mTabIconIDAry[3] = R.mipmap.ic_launcher;
        mTabIconIDAry[4] = R.mipmap.ic_launcher;
    }

    private void initViews() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.id_fl_activityMain_fragmentContainer);
        for (int i = 0; i < mTabNameAry.length; i++) {
            TabHost.TabSpec spec = mTabHost.newTabSpec(mTabNameAry[i]).setIndicator(getTabContent(i));
            mTabHost.addTab(spec,mClzList.get(i),null);
        }
    }

    /**
     * 获取底部Tab的布局
     * @param index
     * @return  view 底部Tab布局
     */
    private View getTabContent(int index) {
        View view = View.inflate(this, R.layout.tab_content, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.id_iv_tab_tabIcon);
        TextView tabName = (TextView) view.findViewById(R.id.id_iv_tab_tabName);
        tabIcon.setImageResource(mTabIconIDAry[index]);
        tabName.setText(mTabNameAry[index]);
        return view;
    }

}
