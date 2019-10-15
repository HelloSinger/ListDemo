package com.ayd.lisedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ayd.lisedemo.adapter.ListDataAdapter;
import com.ayd.lisedemo.bean.ListDataBean;
import com.ayd.lisedemo.utils.RecyclerViewSpacesItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author AYD
 * @date 2019年10月15日 10:07
 * <p>
 */
public class MainActivity extends AppCompatActivity implements ListDataAdapter.itemOnExpandClickListener, ListDataAdapter.itemPackUpClickListener {

    private RecyclerView rcy_more_data;
    private ListDataAdapter listDataAdapter;
    private RecyclerViewSpacesItemDecoration itemDecoration;
    private ListDataBean.DataBean listDataBean;
    private List<ListDataBean.DataBean> dataBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        rcy_more_data = findViewById(R.id.rcy_more_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION, 37);
        itemDecoration = new RecyclerViewSpacesItemDecoration(stringIntegerHashMap);
        rcy_more_data.addItemDecoration(itemDecoration);//设置RecycleView 分割线
        rcy_more_data.setLayoutManager(linearLayoutManager);
        listDataAdapter = new ListDataAdapter(this);
        listDataAdapter.setItemExpandOnClick(this);
        listDataAdapter.setItemPackUpClickListener(this);
        dataBeans = new ArrayList<>();

    }

    private void initData() {
        ListDataBean.DataBean listDataBean0 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test0", "测试0", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean1 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test1", "测试1", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean2 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test2", "测试2", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean3 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test3", "测试3", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean4 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test4", "测试4", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean5 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test5", "测试5", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean6 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test6", "测试6", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean7 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test7", "测试7", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean8 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test8", "测试8", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        ListDataBean.DataBean listDataBean9 = new ListDataBean.DataBean(R.drawable.icon_yaotunbi, "test9", "测试9", "这里是测试这里是测试这里是测试这里是测试这里是测试这里是测试", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "正常");
        dataBeans.add(listDataBean0);
        dataBeans.add(listDataBean1);
        dataBeans.add(listDataBean2);
        dataBeans.add(listDataBean3);
        dataBeans.add(listDataBean4);
        dataBeans.add(listDataBean5);
        dataBeans.add(listDataBean6);
        dataBeans.add(listDataBean7);
        dataBeans.add(listDataBean8);
        dataBeans.add(listDataBean9);
        listDataAdapter.setJyMoreDataBeans(dataBeans);
        rcy_more_data.setAdapter(listDataAdapter);
    }

    /**
     * 列表展开点击事件
     *
     * @param pos
     */
    @Override
    public void itemExpandOnClick(int pos) {
        dataBeans.get(pos).setExpand(true);
        listDataAdapter.notifyItemChanged(pos);
    }

    /**
     * 列表收起点击事件
     *
     * @param pos
     */
    @Override
    public void itemPackUpOnClick(int pos) {
        dataBeans.get(pos).setExpand(false);
        listDataAdapter.notifyItemChanged(pos);
    }
}
