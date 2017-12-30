package com.eventionlab.events.Presenter;

import com.eventionlab.events.Adapter.EventAdapter;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.Model.WebService.ApiClient;
import com.eventionlab.events.Model.WebService.ApiInterface;
import com.eventionlab.events.View.SingleEventView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by malavan on 29/12/17.
 */

public class SIngleEventPresenter implements ISIngleEventPresenter {

    private SingleEventView singleEventView;
    private List<Event> eventList = new ArrayList<>();
    private Map<String, Event> eventMap;

    public SIngleEventPresenter(SingleEventView singleEventView) {
        this.singleEventView = singleEventView;
        singleEventView.setPresenter(this);
    }

    @Override
    public void loaddata() {
        ApiInterface apiService =
                ApiClient.getRetrofit().create(ApiInterface.class);

        Call<Map<String,Event>> call = apiService.getAllEvent();
        call.enqueue(new Callback<Map<String, Event>>() {
            @Override
            public void onResponse(Call<Map<String, Event>> call, Response<Map<String, Event>> response) {
                eventMap = response.body();
                singleEventView.setData(getListFromMap(eventMap));
                //  eventView.setAdapter(new EventAdapter(eventMap,context));

            }

            @Override
            public void onFailure(Call<Map<String, Event>> call, Throwable t) {
                singleEventView.showNetworkError();

            }
        });
    }

    private List<Event> getListFromMap(Map<String, Event> eventMap) {

        for (Map.Entry<String, Event> entry : eventMap.entrySet())
        {
            eventList.add(entry.getValue());
            //   holder.loaddata(entry.getValue(),context);
        }
        return eventList;
    }

    @Override
    public void start() {
loaddata();
    }
}
