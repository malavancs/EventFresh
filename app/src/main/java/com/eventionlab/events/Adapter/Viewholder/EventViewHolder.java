package com.eventionlab.events.Adapter.Viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by malavan on 22/12/17.
 */

public class EventViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.imageview_event)
    ImageView imageviewEvent;
    @BindView(R.id.textview_event_name)
    TextView textviewEventName;
    @BindView(R.id.textview_event_location)
    TextView textviewEventLocation;
    @BindView(R.id.textview_event_timing)
    TextView textview_event_timing;


    public EventViewHolder(View itemView) {
        super(itemView);
        textviewEventName = itemView.findViewById(R.id.textview_event_name);
        textview_event_timing  = itemView.findViewById(R.id.textview_event_timing);
        textviewEventLocation = itemView.findViewById(R.id.textview_event_location);
        imageviewEvent = itemView.findViewById(R.id.imageview_event);
    }

   public void loaddata(Event event, Context context)
   {
       Glide.with(context).load(event.getImg_url()).into(imageviewEvent);
       textviewEventLocation.setText(event.getAddress());
       textview_event_timing.setText(event.getStartDate());
       textviewEventName.setText(event.getEvent_name());
   }
}
