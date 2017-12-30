package com.eventionlab.events.View.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eventionlab.events.Model.Event;
import com.eventionlab.events.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.iv_main_image)
    ImageView ivMainImage;
    @BindView(R.id.tv_main_name)
    TextView tvMainName;
    @BindView(R.id.tv_main_place)
    TextView tvMainPlace;
    @BindView(R.id.tv_main_start)
    TextView tvMainStart;
    @BindView(R.id.tv_main_end)
    TextView tvMainEnd;
    @BindView(R.id.tv_main_cost)
    TextView tvMainCost;
    @BindView(R.id.tv_main_about)
    TextView tvMainAbout;
    @BindView(R.id.bt_main_tickets)
    Button btMainTickets;
    @BindView(R.id.bt_main_share)
    Button btMainShare;
    @BindView(R.id.bt_main_calender)
    Button btMainCalender;
    @BindView(R.id.tv_main_route)
    Button tvMainRoute;
    @BindView(R.id.bt_main_route)
    Button btMainRoute;
    Unbinder unbinder;

    Event event;

    public EventFragment() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        event = bundle.getParcelable("event");

       // ButterKnife.bind(this, view);

        ivMainImage = view.findViewById(R.id.iv_main_image);
        tvMainRoute = view.findViewById(R.id.tv_main_route);
        tvMainName = view.findViewById(R.id.tv_main_name);
        tvMainPlace = view.findViewById(R.id.tv_main_place);
        tvMainStart = view.findViewById(R.id.tv_main_start);
        tvMainEnd = view.findViewById(R.id.tv_main_end);
        tvMainCost = view.findViewById(R.id.tv_main_cost);
        tvMainAbout = view.findViewById(R.id.tv_main_about);
        btMainTickets = view.findViewById(R.id.bt_main_tickets);
        btMainShare = view.findViewById(R.id.bt_main_share);


        btMainShare.setOnClickListener(this);
        btMainTickets.setOnClickListener(this);

        loaddata();


    }

    private void loaddata() {

        Log.d(TAG, "loaddata: "+event.getAbout_event());
        Glide.with(getActivity()).load(event.getImg_url()).into(ivMainImage);
        tvMainName.setText(event.getEvent_name());
        tvMainPlace.setText(event.getAddress());
        tvMainStart.setText(String.format("%s", event.getStartDate()));
        tvMainEnd.setText(event.getEnd_date());
        tvMainCost.setText(event.getPrice());
        tvMainAbout.setText(event.getAbout_event());
        tvMainRoute.setText(event.getID());


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bt_main_share:

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String sAux = "\nLet me recommend you this application\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=Orion.Soft \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
                break;
            case R.id.bt_main_tickets:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(event.getWebsite()));
                startActivity(intent);
                break;

        }
    }
}
