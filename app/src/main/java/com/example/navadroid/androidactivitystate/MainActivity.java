package com.example.navadroid.androidactivitystate;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Source: https://developer.android.com/guide/components/activities/activity-lifecycle.html
// Source: https://stackoverflow.com/questions/151777/saving-android-activity-state-using-save-instance-state

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Always call the superclass first
        setContentView(R.layout.activity_main);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
        } else {
            // Probably initialize members with default values for a new instance
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState, outPersistentState);

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        //outState.putVarType("VarName", "VarValue");

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        //VarType varName = savedInstanceState.getVarType("VarName");
    }
}
