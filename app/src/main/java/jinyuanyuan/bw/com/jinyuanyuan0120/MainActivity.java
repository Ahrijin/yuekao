package jinyuanyuan.bw.com.jinyuanyuan0120;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jinyuanyuan.bw.com.jinyuanyuan0120.adapter.GoodsAdapter;
import jinyuanyuan.bw.com.jinyuanyuan0120.bean.GoodsBean;
import jinyuanyuan.bw.com.jinyuanyuan0120.bean.GoodsDataBean;
import jinyuanyuan.bw.com.jinyuanyuan0120.greendao.DaoSession;
import jinyuanyuan.bw.com.jinyuanyuan0120.greendao.GoodsDataBeanDao;
import jinyuanyuan.bw.com.jinyuanyuan0120.prestener.PrestenerImpls;
import jinyuanyuan.bw.com.jinyuanyuan0120.utils.Contacts;
import jinyuanyuan.bw.com.jinyuanyuan0120.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.dwei)
    Button dwei;
    @BindView(R.id.recy)
    RecyclerView recy;
    private PrestenerImpls prestenerImpls;
    private Map<String, Object> map = new HashMap<>();
    private GoodsAdapter goodsAdapter;
    private List<GoodsBean.DataBean> mLists = new ArrayList<>();
    private GoodsDataBeanDao goodsDataBeanDao;
    private GoodsDataBean goodsDataBean = new GoodsDataBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recy.setLayoutManager(linearLayoutManager);
        goodsAdapter = new GoodsAdapter(mLists, MainActivity.this);
        recy.setAdapter(goodsAdapter);

        map.put("keywords", "笔记本");
        map.put("page", 1);
        prestenerImpls = new PrestenerImpls(this);
        prestenerImpls.getRequest(Contacts.SEARCHPRODUCTS_URL, map, GoodsBean.class);

        goodsDataBeanDao = MyApp.getDaoSession().getGoodsDataBeanDao();

        long insert = goodsDataBeanDao.insert(goodsDataBean);
        if(insert>1){
            Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.dwei)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.dwei:

                break;
        }
    }

    @Override
    public void su(Object success) {
        GoodsBean goodsBean = (GoodsBean) success;
        mLists.addAll(goodsBean.getData());
        goodsAdapter.notifyDataSetChanged();
    }

    @Override
    public void er(Object errors) {

    }
}
