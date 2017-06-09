package com.minscapecomputing.infowindow;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }

    private void init() {

        container = (FrameLayout)findViewById(R.id.container);
    }

    private void setListener() {

        findViewById(R.id.info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                container.setVisibility(View.VISIBLE);
                ArrayList<String> list = new ArrayList<>();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("list", list);
                InfoWindowFragment infoWindowFragment = InfoWindowFragment.newInstance(bundle);
                infoWindowFragment.setOnInfoWindowClosed(new InfoWindowFragment.OnInfoWindowClosed() {
                    @Override
                    public void closed() {
                        container.setVisibility(View.GONE);
                    }
                });
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, infoWindowFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commitAllowingStateLoss();
            }
        });
    }
}
