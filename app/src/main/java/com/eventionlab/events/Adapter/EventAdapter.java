package com.eventionlab.events.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eventionlab.events.Adapter.Viewholder.EventViewHolder;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.R;
import com.eventionlab.events.View.Activity.SIngleEventActivity;
import com.eventionlab.events.View.SingleEventView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by malavan on 22/12/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder>{


    Map<String ,Event> eventMap;
    Context context;
    List<Event> eventList = new ArrayList<>();
    public EventAdapter(Map<String, Event> eventMap,Context context) {
        this.eventMap = eventMap;
        this.context = context;
        for (Map.Entry<String, Event> entry : eventMap.entrySet())
        {
            eventList.add(entry.getValue());
         //   holder.loaddata(entry.getValue(),context);
        }


    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_event_single,parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SIngleEventActivity.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
        holder.loaddata(eventList.get(position),context);

    }

    @Override
    public int getItemCount() {
        return eventMap.size();
    }
}
