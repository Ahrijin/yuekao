package jinyuanyuan.bw.com.jinyuanyuan0120;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jinyuanyuan.bw.com.jinyuanyuan0120.bean.DetailBean;
import jinyuanyuan.bw.com.jinyuanyuan0120.prestener.PrestenerImpls;
import jinyuanyuan.bw.com.jinyuanyuan0120.utils.Contacts;
import jinyuanyuan.bw.com.jinyuanyuan0120.view.IView;

public class DetailActivity extends AppCompatActivity implements IView {


    @BindView(R.id.view_page)
    ViewPager viewPage;
    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.detail_price)
    TextView detailPrice;
    @BindView(R.id.detail_btns)
    Button detailBtns;
    private String pid;
    private MyAdapter adapter;
    private PrestenerImpls prestenerImpls;
    private Map<String, Object> map = new HashMap<>();
    private List<DetailBean> mList = new ArrayList<>();
    private String[] array = {
            "https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg!q70.jpg",
            "https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg",
            "https://m.360buyimg.com/n0/jfs/t5698/110/2617517836/202970/c9388feb/593276b7Nbd94ef1f.jpg!q70.jpg",
            "https://m.360buyimg.com/n0/jfs/t5815/178/2614671118/51656/7f52d137/593276c7N107b725a.jpg!q70.jpg",
            "https://m.360buyimg.com/n0/jfs/t5878/60/2557817477/30873/4502b606/593276caN5a7d6357.jpg!q70.jpg"
    };
    private int index = 0;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            index++;
            viewPage.setCurrentItem(index);
            handler.sendEmptyMessageDelayed(0, 3000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        //适配器刷新数据
        adapter = new MyAdapter();
        viewPage.setAdapter(adapter);
        handler.sendEmptyMessage(0);
        //接收值
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        map.put("pid", pid);
        prestenerImpls = new PrestenerImpls(this);
        prestenerImpls.getRequest(Contacts.GETDETAIL_URL, map, DetailBean.class);
    }


    @Override
    public void su(Object success) {
        DetailBean detailBean = (DetailBean) success;
        String title = detailBean.getData().getTitle();
        detailTitle.setText(title + "");
        double price = detailBean.getData().getPrice();
        detailPrice.setText("￥" + price);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void er(Object errors) {

    }

    @OnClick(R.id.detail_btns)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.detail_btns:

                break;
        }
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imgs = new ImageView(DetailActivity.this);
            Glide.with(DetailActivity.this).load(array[position % array.length]).into(imgs);
            imgs.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imgs);
            return imgs;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
