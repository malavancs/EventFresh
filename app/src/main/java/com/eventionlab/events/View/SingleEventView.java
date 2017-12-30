package com.eventionlab.events.View;

import com.eventionlab.events.Model.Event;
import com.eventionlab.events.Presenter.SIngleEventPresenter;
import com.eventionlab.events.View.Activity.SIngleEventActivity;

import java.util.List;

/**
 * Created by malavan on 29/12/17.
 */

public interface SingleEventView extends BaseView<SIngleEventPresenter> {
    void setData(List<Event> events);

    void showNetworkError();
}
