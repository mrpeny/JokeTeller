package com.udacity.gradle.builditbigger.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);

        if (getActivity() != null && getActivity().getIntent().hasExtra(JokeActivity.JOKE_KEY)) {
            Intent intent = getActivity().getIntent();
            String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);
            ((TextView) root.findViewById(R.id.tv_joke)).setText(joke);
        }

        return root;
    }
}
