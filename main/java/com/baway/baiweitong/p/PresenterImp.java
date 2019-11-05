package com.baway.baiweitong.p;
//时间:2019.11.05
//作者:白维童
//功能:P层
import com.baway.baiweitong.Ccen;
import com.baway.baiweitong.m.ModelImp;

public class PresenterImp implements Ccen.IPresenter {
    Ccen.IModel mModel;
    Ccen.IView mView;
    @Override
    public void attch(Ccen.IView iView) {
        mModel = new ModelImp();
        mView = iView;
    }

    @Override
    public void presenter(String url) {
        mModel.getJson(url, new Ccen.MyCallBack() {
            @Override
            public void succse(String json) {
                mView.succse(json);
            }

            @Override
            public void filaed(String error) {
                mView.filaed(error);
            }
        });
    }

    @Override
    public void deattch() {
        if (mView!=null){
            mView=null;
        }
        if (mModel!=null){
            mModel=null;
        }
    }
}
