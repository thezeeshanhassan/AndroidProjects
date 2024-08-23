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
        notificationList.add(new NotificationItem("New Message from Ahmad",
                "5m ago", "You have a new message from Ahmad Hassan Bobak." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("New Message from Hamza",
                "1d ago", "You have a new message from Ahmad Hamza Mehmood ." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("New Message from Barshan",
                "5d ago", "You have a new message from Barshan Hassan." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("New Message from Alia",
                "10d ago", "You have a new message from Alia Barshan." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("New Message from Hamza",
                "1d ago", "You have a new message from Ahmad Hamza Mehmood ." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("New Message from Barshan",
                "5d ago", "You have a new message from Barshan Hassan." +
                " Check it out now!"));
        notificationList.add(new NotificationItem("New Message from Ahmad",
                "5m ago", "You have a new message from Ahmad Hassan Bobak." +
                " Check it out now!"));

        adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
