package com.example.homework611;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtLogout;
    private static String LOG_NAME = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogout = findViewById(R.id.txt_logout);
        String bundleValue = "";
        if (savedInstanceState == null) {
            bundleValue = "- Bundle is null";
        } else {
            bundleValue = "- Bundle: " + savedInstanceState.toString();
        }
        logLifeCycle("onCreate" + bundleValue);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logLifeCycle("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logLifeCycle("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logLifeCycle("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logLifeCycle("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logLifeCycle("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logLifeCycle("onRestart");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        logLifeCycle("onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        logLifeCycle("onPostResume");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        logLifeCycle("onKeyDown " + Integer.toString(keyCode));
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        logLifeCycle("onKeyLongPress");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logLifeCycle("onBackPressed");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String value = txtLogout.getText().toString();
        outState.putString("currentText", value);
        logLifeCycle("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String value = savedInstanceState.getString("currentText");
        txtLogout.setText(value);
        logLifeCycle("onRestoreInstanceState");
    }

    private void logLifeCycle(String name) {
        Log.d(LOG_NAME, name);
        txtLogout.append(name + "\n");
    }
}
