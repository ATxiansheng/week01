package com.baway.baiweitong.task;
//时间:2019.11.05
//作者:白维童
//功能:异步类
import android.os.AsyncTask;

import com.baway.baiweitong.util.NetUtil;

public class JsonTask extends AsyncTask<String,Void,String> {
    MyCallBack myCallBack;

    public JsonTask(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    @Override
    protected String doInBackground(String... strings) {
        String json = NetUtil.getInstance().getJson(strings[0]);
        return json;
    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);
        if (string.isEmpty()){
            myCallBack.filaed("获取Json错误");
        }else {
            myCallBack.succse(string);
        }
    }
    public interface MyCallBack{
        void succse(String json);
        void filaed(String error);
    }
}
