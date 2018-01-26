package com.example.hao.tabnodestroyviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hao.tabnodestroyviewpager.R;
import com.example.hao.tabnodestroyviewpager.adapter.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;


/**
* @作者 hao
* @创建日期 2018/1/26 15:15
* Description: 第三个
*/
public class ThreePagerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecy;
    private SimpleAdapter adapter;
    public static ThreePagerFragment newInstance() {

        Bundle args = new Bundle();

        ThreePagerFragment fragment = new ThreePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        mRecy = view.findViewById(R.id.recy);
        mRefreshLayout = view.findViewById(R.id.refresh_layout);

        mRefreshLayout.setOnRefreshListener(this);
        adapter = new SimpleAdapter(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(manager);
        mRecy.setAdapter(adapter);
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            String item = "three : "+i;
            data.add(item);
        }
        adapter.setDatas(data);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
