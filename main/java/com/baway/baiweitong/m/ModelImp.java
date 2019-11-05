package com.baway.baiweitong.m;
//时间:2019.11.05
//作者:白维童
//功能:M层
import com.baway.baiweitong.Ccen;
import com.baway.baiweitong.task.JsonTask;

public class ModelImp implements Ccen.IModel {
    @Override
    public void getJson(String url, final Ccen.MyCallBack myCallBack) {
        new JsonTask(new JsonTask.MyCallBack() {
            @Override
            public void succse(String json) {
                myCallBack.succse(json);
            }

            @Override
            public void filaed(String error) {
                myCallBack.filaed(error);
            }
        }).execute(url);
    }
}
