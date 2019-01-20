package jinyuanyuan.bw.com.jinyuanyuan0120.utils;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/*
 *Author:Ahri_Love
 *Date:2019/1/20
 */public interface MyApiService {
    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String, Object> map);

    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap Map<String, Object> map);

}
