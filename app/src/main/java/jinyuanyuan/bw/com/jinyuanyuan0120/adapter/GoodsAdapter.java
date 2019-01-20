package jinyuanyuan.bw.com.jinyuanyuan0120.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import jinyuanyuan.bw.com.jinyuanyuan0120.DetailActivity;
import jinyuanyuan.bw.com.jinyuanyuan0120.R;
import jinyuanyuan.bw.com.jinyuanyuan0120.bean.GoodsBean;

/*
 *Author:Ahri_Love
 *Date:2019/1/20
 */public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {
    private List<GoodsBean.DataBean> mLists;
    private Context context;

    public GoodsAdapter(List<GoodsBean.DataBean> mLists, Context context) {
        this.mLists = mLists;
        this.context = context;
    }

    @NonNull
    @Override
    public GoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.goods_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final GoodsAdapter.ViewHolder viewHolder, final int i) {
        String images = mLists.get(i).getImages();
        String replace = images.replace("https", "http");
        String[] split = replace.split("\\|");
        Uri uri = Uri.parse(split[0]);
        viewHolder.img.setImageURI(uri);
        viewHolder.titls.setText("" + mLists.get(i).getTitle());
        viewHolder.price.setText("￥" + mLists.get(i).getPrice());

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mLists.remove(viewHolder.getAdapterPosition());
                notifyDataSetChanged();
                notifyItemRemoved(viewHolder.getAdapterPosition());
                Toast.makeText(context, "已删除", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("pid", mLists.get(i).getPid() + "");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img;
        private TextView titls;
        private TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.goods_imgs);
            titls = itemView.findViewById(R.id.goods_titls);
            price = itemView.findViewById(R.id.goods_price);
        }
    }
}
