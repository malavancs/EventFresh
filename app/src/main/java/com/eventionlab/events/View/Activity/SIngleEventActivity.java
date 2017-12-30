package com.eventionlab.events.View.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.eventionlab.events.Adapter.EventPagerAdapter;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.Presenter.SIngleEventPresenter;
import com.eventionlab.events.R;
import com.eventionlab.events.View.SingleEventView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SIngleEventActivity extends AppCompatActivity implements SingleEventView{


    @BindView(R.id.viewpager_main)
    ViewPager viewpagerMain;
    List<Event> eventList=new ArrayList<>();
    private SIngleEventPresenter sIngleEventPresenter;
    private EventPagerAdapter eventPagerAdapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_event);
        ButterKnife.bind(this);
        eventPagerAdapter = new EventPagerAdapter(getSupportFragmentManager(),eventList);
        position = getIntent().getExtras().getInt("position");



    }

    @Override
    protected void onStart() {
        super.onStart();

        sIngleEventPresenter = new SIngleEventPresenter(this);
      }

    @Override
    public void setData(List<Event> events) {
        this.eventList = events;
        Log.d("TAG", "setData() called with: events = [" + events.size() + "]");
        eventPagerAdapter = new EventPagerAdapter(getSupportFragmentManager(),events);
        eventPagerAdapter.notifyDataSetChanged();
        viewpagerMain = findViewById(R.id.viewpager_main);

        viewpagerMain.setAdapter(eventPagerAdapter);
        viewpagerMain.setCurrentItem(position);
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void setPresenter(SIngleEventPresenter presenter) {
    this.sIngleEventPresenter = presenter;
    }

    protected void onResume() {
        super.onResume();
        sIngleEventPresenter.start();

    }
}
