package com.eventionlab.events.Adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.eventionlab.events.Model.Event;
import com.eventionlab.events.View.Fragment.EventFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malavan on 29/12/17.
 */

public class EventPagerAdapter extends FragmentStatePagerAdapter{
    private List<Event> eventList = new ArrayList<>();
    private EventFragment eventFragment;
    public EventPagerAdapter(FragmentManager fm,List<Event> events) {
        super(fm);
        this.eventList = events;
    }

    @Override
    public Fragment getItem(int position) {
        eventFragment = new EventFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("event",(Event) eventList.get(position));
        eventFragment.setArguments(bundle);
        return eventFragment;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }
}
