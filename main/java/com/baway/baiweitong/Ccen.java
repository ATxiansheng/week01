package com.baway.baiweitong;
//时间:2019.11.05
//作者:白维童
//功能:契约类
public interface Ccen {
    interface IModel{
        void getJson(String url,MyCallBack myCallBack);
    }
    interface IView{
        void succse(String json);
        void filaed(String error);
    }
    interface IPresenter{
        void attch(IView iView);
        void presenter(String url);
        void deattch();
    }
    interface MyCallBack{
        void succse(String json);
        void filaed(String error);
    }
}
