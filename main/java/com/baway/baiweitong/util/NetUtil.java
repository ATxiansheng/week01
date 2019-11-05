package com.baway.baiweitong.util;
//时间:2019.11.05
//作者:白维童
//功能:网络工具类
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUtil {
    private static NetUtil netUtil;

    public static NetUtil getInstance() {
        if (netUtil==null){
            netUtil = new NetUtil();
        }
        return netUtil;
    }

    private NetUtil() {
    }

    public boolean getNet(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo.isConnected()){
            return true;
        }
        return false;
    }

    public boolean getNetIsWIFI(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo.isConnected()&&activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            return true;
        }
        return false;
    }

    public String getJson(String JsonUrl){
        try {
            URL url = new URL(JsonUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            if (connection.getResponseCode()==200){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String temp = "";
                StringBuilder builder = new StringBuilder();
                while ((temp = bufferedReader.readLine())!=null){
                    builder.append(temp);
                }
                bufferedReader.close();
                return builder.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
