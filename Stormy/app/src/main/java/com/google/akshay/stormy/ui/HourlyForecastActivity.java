package com.google.akshay.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.akshay.stormy.MainActivity;
import com.google.akshay.stormy.R;
import com.google.akshay.stormy.adapters.HourAdapter;
import com.google.akshay.stormy.weather.Hour;

import java.lang.reflect.Array;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyForecastActivity extends ActionBarActivity {

    private  Hour[] mHours;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        mHours = Arrays.copyOf(parcelables,parcelables.length,Hour[].class);

        HourAdapter adapter = new HourAdapter(mHours);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
    }

    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        String time = mHours[position].getHour();
        String temperature = mHours[position].getTemperature() +"";
        String summary = mHours[position].getSummary();
        String message = String.format("On %s the temperature will be %s and it will be %s",
                time,
                temperature,
                summary);
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }*/
}
