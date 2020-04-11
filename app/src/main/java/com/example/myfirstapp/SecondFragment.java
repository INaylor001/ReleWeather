package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    private Button button;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
 ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //onclick for continue guest button
        view.findViewById(R.id.continue_guest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              openLocationMap();
            }

        });

        //onclick listener for weather button

        view.findViewById(R.id.weather_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeatherScreen();
            }
        });



        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    //public methods to open certain screens

    public void openLocationMap(){
        Intent intent = new Intent(this.getActivity(), LocationMap.class);
        startActivity(intent);
    }

    public void openWeatherScreen(){
        Intent intent = new Intent(this.getActivity(), WeatherScreen.class);
        startActivity(intent);
    }

}
