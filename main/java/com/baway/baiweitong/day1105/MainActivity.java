package com.baway.baiweitong.day1105;
//时间:2019.11.05
//作者:白维童
//功能:V层
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.baway.baiweitong.Ccen;
import com.baway.baiweitong.adapter.GridAdapter;
import com.baway.baiweitong.bean.JDBean;
import com.baway.baiweitong.p.PresenterImp;
import com.baway.baiweitong.util.NetUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Ccen.IView {

    private XBanner X_Banner;
    private GridView Grid_View;
    private String url = "http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
    private Ccen.IPresenter presenter = new PresenterImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if (NetUtil.getInstance().getNet(MainActivity.this)){
            presenter.attch(this);
            presenter.presenter(url);
        }else {
            Log.i("aa","无网络");
        }
    }

    private void initView() {
        X_Banner = (XBanner) findViewById(R.id.X_Banner);
        Grid_View = (GridView) findViewById(R.id.Grid_View);
    }

    @Override
    public void succse(String json) {
        //解析Json
        JDBean jdBean = new Gson().fromJson(json, JDBean.class);
        final List<JDBean.GriddataBean> griddata = jdBean.getGriddata();
        //设置适配器
        Grid_View.setAdapter(new GridAdapter(griddata, MainActivity.this));
        Log.i("aa",""+databaseList());
        final List<JDBean.BannerdataBean> bannerdata = jdBean.getBannerdata();
        //设置轮播图
        X_Banner.setBannerData(bannerdata);
        X_Banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(MainActivity.this).load(bannerdata.get(position).getImageurl()).into((ImageView) view);
            }
        });
    }

    @Override
    public void filaed(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
    }
}
