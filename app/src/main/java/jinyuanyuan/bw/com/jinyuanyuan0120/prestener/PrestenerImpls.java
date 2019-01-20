package jinyuanyuan.bw.com.jinyuanyuan0120.prestener;

import android.widget.ImageView;

import java.util.Map;

import jinyuanyuan.bw.com.jinyuanyuan0120.callback.MyCallBack;
import jinyuanyuan.bw.com.jinyuanyuan0120.model.ModelImpls;
import jinyuanyuan.bw.com.jinyuanyuan0120.view.IView;

/*
 *Author:Ahri_Love
 *Date:2019/1/20
 */public class PrestenerImpls implements Prestener {
    private IView iView;
    private ModelImpls modelImpls;

    public PrestenerImpls(IView iView) {
        this.iView = iView;
        modelImpls = new ModelImpls();
    }

    @Override
    public void getRequest(String url, Map<String, Object> map, Class clazz) {
        modelImpls.getData(url, map, clazz, new MyCallBack() {
            @Override
            public void success(Object su) {
                iView.su(su);
            }

            @Override
            public void error(Object er) {
                iView.er(er);
            }
        });
    }

    @Override
    public void postRequest(String url, Map<String, Object> map, Class clazz) {
        modelImpls.postData(url, map, clazz, new MyCallBack() {
            @Override
            public void success(Object su) {
                iView.su(su);
            }

            @Override
            public void error(Object er) {
                iView.er(er);
            }
        });
    }

    public void destory() {
        if (iView != null) {
            iView = null;
        }
        if (modelImpls != null) {
            modelImpls = null;
        }
    }
}
