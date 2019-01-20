package jinyuanyuan.bw.com.jinyuanyuan0120.model;

import java.util.Map;

import jinyuanyuan.bw.com.jinyuanyuan0120.callback.MyCallBack;

/*
 *Author:Ahri_Love
 *Date:2019/1/20
 */public interface Model {
     void getData(String url, Map<String,Object> map,Class clazz,MyCallBack callBack);
     void postData(String url, Map<String,Object> map,Class clazz,MyCallBack callBack);
}
