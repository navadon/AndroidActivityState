package com.example.navadroid.androidactivitystate;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Android Activity State";

    // view
    private EditText etString;
    private TextView tvOutput;

    // string to be saved
    private String myString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Always call the superclass first
        setContentView(R.layout.activity_main);
        bindView();

        // No need to use this if we implement onRestoreInstanceState
        // Check whether we're recreating a previously destroyed instance
//        if (savedInstanceState != null) {
//            // Restore value of members from saved state
//            //myString = savedInstanceState.getString("mySavedString");
//            Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
//            Log.d(TAG, "onCreate() called with: myString = [" + myString + "]");
//        }
//       else {
//            // Probably initialize members with default values for a new instance
//            myString = null;
//            Log.d(TAG, "onCreate() called with: myString = [" + myString + "]");
//        }
    }

    private void bindView(){
        etString = (EditText) findViewById(R.id.et_string);
        tvOutput = (TextView) findViewById(R.id.tv_output);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        //Format: outState.putVarType("VarName", "VarValue");
        outState.putString("mySavedString", myString);
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        // Format: VarType varName = savedInstanceState.getVarType("VarName");
        myString = savedInstanceState.getString("mySavedString");
        Log.d(TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]");
        Log.d(TAG, "onRestoreInstanceState() called with: myString = [" + myString + "]");
    }

    public void process(View view){
        switch (view.getId()) {
            case R.id.btn_save:
                myString = etString.getText().toString();
                etString.setText("");
                etString.setHint("Type something here");
                break;
            case R.id.btn_show:
                if (myString != null)
                    tvOutput.setText(myString);
                else
                    tvOutput.setText("No saved string.");
                break;
            case R.id.btn_clear:
                resetView();
                break;
        }
    }

    private void resetView(){
        etString.setText("");
        etString.setHint("Type something here");
        tvOutput.setText("");
    }

    // called when the activity is about to become visible
    @Override
    protected void onStart() {
        super.onStart();
        //Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    // called when the activity has become visible
    @Override
    protected void onResume() {
        super.onResume();
        //resetView();
        Log.d(TAG, "onResume() called");
    }

    // called when another activity is taking focus
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    // called when the activity is no longer visible
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    // called just before the activity is destroyed
    // Configuration changes during runtime (screen orientation, keyboard availability, and language) also call onDestroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
