package com.example.gulnara.fairsplit.guestchoice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.gulnara.fairsplit.R;
import com.example.gulnara.fairsplit.model.BillModel;

/**
 * Created by Gulnara on 29.05.2016.
 */
public class GuestChoiceFragment extends ListFragment {
    GuestChoiceListAdapter guestAdapter;
    private static final String ARG_SECTION_NUMBER = "section_number";
    int guestNum;

    public GuestChoiceFragment() {
    }

    public static GuestChoiceFragment newInstance(int sectionNumber) {
        GuestChoiceFragment fragment = new GuestChoiceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        guestAdapter = new GuestChoiceListAdapter(getActivity(), getArguments().getInt(ARG_SECTION_NUMBER));
        getListView().setAdapter(guestAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        guestNum = getArguments().getInt(ARG_SECTION_NUMBER);
        View rootView = inflater.inflate(R.layout.fragment_guest_choice, container, false);
        final TextView guestText = (TextView) rootView.findViewById(R.id.section_label);
        guestText.setText(getString(R.string.guest_format, guestNum));

        return rootView;
    }
}
