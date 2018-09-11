package au.edu.curtin.island_builder;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragM = fm.findFragmentById(R.id.map);
        if(fragM == null)
        {
            fragM = new map();
            fm.beginTransaction().add(R.id.map, fragM).commit();
        }

        FragmentManager fm2 = getSupportFragmentManager();
        Fragment fragS = fm2.findFragmentById(R.id.selector);
        if(fragS == null)
        {
            fragS = new selector();
            fm2.beginTransaction().add(R.id.selector, fragS).commit();
        }


    }
}
