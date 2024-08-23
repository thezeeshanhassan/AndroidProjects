package com.example.twitter;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class Notification extends Fragment {

    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<NotificationItem> notificationList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = view.findViewById(R.id.notification_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        notificationList = new ArrayList<>();
        // Add some dummy data
        notificationList.add(new NotificationItem("Ahmad has posted a Vido",
                "5m ago", "Click to see the Ahmad's Post" +
                " Check it out now!"));
        notificationList.add(new NotificationItem("Hamza Started Folllowing You",
                "1d ago", "" +
                " Follow back to Hamza"));
        notificationList.add(new NotificationItem("Barshan Hassan started Following You",
                "5d ago", " " +
                " Follow back to Barshan"));
        notificationList.add(new NotificationItem("Alia has postd her Job",
                "10d ago", "Explore more about Alia." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("Hamza Started Folllowing",
                "1d ago", "" +
                " Follow back to Hamza"));
        notificationList.add(new NotificationItem("New Message from Barshan",
                "5d ago", "You have a new message from Barshan Hassan." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("Barshan Hassan started Following You",
                "5d ago", " " +
                " Follow back to Barshan"));

        adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
