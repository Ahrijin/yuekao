package jinyuanyuan.bw.com.jinyuanyuan0120.prestener;

import java.util.Map;

/*
 *Author:Ahri_Love
 *Date:2019/1/20
 */public interface Prestener {
    void getRequest(String url, Map<String, Object> map, Class clazz);

    void postRequest(String url, Map<String, Object> map, Class clazz);
}
