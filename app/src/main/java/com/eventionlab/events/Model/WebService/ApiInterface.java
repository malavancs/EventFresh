package com.eventionlab.events.Model.WebService;

import com.eventionlab.events.Model.Event;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by malavan on 14/12/17.
 */

public interface ApiInterface {

    @GET("/Events.json")
    Call<Map<String, Event>> getAllEvent();

    @GET("/addition/?num1=2&num2=2")
    Call<Event> getResult();

}
