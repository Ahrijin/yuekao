package jinyuanyuan.bw.com.jinyuanyuan0120.model;

import com.google.gson.Gson;

import java.util.Map;

import jinyuanyuan.bw.com.jinyuanyuan0120.callback.MyCallBack;
import jinyuanyuan.bw.com.jinyuanyuan0120.utils.RetrofitUtils;

/*
 *Author:Ahri_Love
 *Date:2019/1/20
 */public class ModelImpls implements Model {
    @Override
    public void getData(String url, Map<String, Object> map, final Class clazz, final MyCallBack callBack) {
        RetrofitUtils.getInstance().get(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void getSucees(String jsonStr) {
                Gson gson = new Gson();
                Object o = gson.fromJson(jsonStr, clazz);
                callBack.success(o);
            }

            @Override
            public void getErrors(String errors) {
                callBack.error(errors);
            }
        });
    }

    @Override
    public void postData(String url, Map<String, Object> map, final Class clazz, final MyCallBack callBack) {
        RetrofitUtils.getInstance().post(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void getSucees(String jsonStr) {
                Gson gson = new Gson();
                Object o = gson.fromJson(jsonStr, clazz);
                callBack.success(o);
            }

            @Override
            public void getErrors(String errors) {
                callBack.error(errors);
            }
        });
    }
}
