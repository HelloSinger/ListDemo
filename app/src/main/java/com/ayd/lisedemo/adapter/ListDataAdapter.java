package com.ayd.lisedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.ayd.lisedemo.R;
import com.ayd.lisedemo.bean.ListDataBean;
import com.ayd.lisedemo.utils.AnimationUtils;

import java.util.List;

/**
 * 文件描述
 *
 * @author AYD
 * @date 2019年10月15日10:15
 */

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.MyViewHolder> {

    private Context context;
    public itemOnExpandClickListener itemExpandOnClick;
    public itemPackUpClickListener itemPackUpClickListener;
    private List<ListDataBean.DataBean> dataBeans;
    private AnimationUtils animationUtils;


    public void setJyMoreDataBeans(List<ListDataBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }

    public void setItemPackUpClickListener(ListDataAdapter.itemPackUpClickListener itemPackUpClickListener) {
        this.itemPackUpClickListener = itemPackUpClickListener;
    }

    public void setItemExpandOnClick(itemOnExpandClickListener itemExpandOnClick) {
        this.itemExpandOnClick = itemExpandOnClick;
    }

    public ListDataAdapter(Context context) {
        this.context = context;
        animationUtils = new AnimationUtils();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_jy_more_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        GlideOptions glideOptions = new GlideOptions.Builder()
//                .radius(0)
//
//                .cornerType(GlideOptions.CornerType.TOP)
//                .build();
//        ImageUtil.display(context, jyMoreDataBeans.get(position).getGp_bg_img(), holder.iv_bg, glideOptions);
        holder.tv_chinese_name.setText(dataBeans.get(position).getGp_name());
        holder.tv_eg_name.setText(dataBeans.get(position).getGp_name_en());
        holder.tv_request.setText(dataBeans.get(position).getRisk());
        holder.tv_introduce.setText(dataBeans.get(position).getGp_intro());
        holder.tv_expand_content.setText(dataBeans.get(position).getGp_gene_intro());
        holder.ll_pack_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPackUpClickListener.itemPackUpOnClick(position);
            }
        });

        holder.iv_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemExpandOnClick.itemExpandOnClick(position);
            }
        });

        if (dataBeans.get(position).isExpand()) {//这里是判断是否显示
            holder.iv_expand.setVisibility(View.GONE);
            holder.iv_bg.setClickable(false);
            animationUtils.changeTop(holder.rl_content);
            animationUtils.animateOpen(holder.rl_expand, 450);
        } else {
            holder.iv_bg.setClickable(true);
            holder.iv_expand.setVisibility(View.VISIBLE);
            animationUtils.changeCentent(holder.rl_content);
            animationUtils.animateClose(holder.rl_expand);
        }
    }

    @Override
    public int getItemCount() {
        return dataBeans == null ? 0 : dataBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_bg;
        private TextView tv_chinese_name;
        private TextView tv_eg_name;
        private TextView tv_request;
        private ImageView iv_expand;
        private RelativeLayout rl_expand;
        private LinearLayout ll_pack_up;
        private RelativeLayout rl_content;
        private TextView tv_introduce;
        private TextView tv_expand_content;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_bg = itemView.findViewById(R.id.iv_bg);
            tv_chinese_name = itemView.findViewById(R.id.tv_chinese_name);
            tv_eg_name = itemView.findViewById(R.id.tv_eg_name);
            tv_request = itemView.findViewById(R.id.tv_request);
            iv_expand = itemView.findViewById(R.id.iv_expand);
            rl_expand = itemView.findViewById(R.id.rl_expand);
            ll_pack_up = itemView.findViewById(R.id.ll_pack_up);
            rl_content = itemView.findViewById(R.id.rl_content);
            tv_introduce = itemView.findViewById(R.id.tv_introduce);
            tv_expand_content = itemView.findViewById(R.id.tv_expand_content);
        }
    }


    public interface itemOnExpandClickListener {
        void itemExpandOnClick(int pos);
    }

    public interface itemPackUpClickListener {
        void itemPackUpOnClick(int pos);
    }

}
