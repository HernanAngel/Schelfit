package com.zybooks.schelfit;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class activity extends Activity implements SensorEventListener {
    private TextView textViewStepCounter, textViewStepDetector;
    private SensorManager sensorManager;
    private Sensor mStepCounter, mStepDetector;
    private boolean isCounterSensorPresent, isDetectorSensorPresent;
    int stepCount = 0, stepDetector = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[]{
                    Manifest.permission.ACTIVITY_RECOGNITION
            },0);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepCounter = findViewById(R.id.step_counter);
        textViewStepDetector = findViewById(R.id.step_detector);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;

        }else{
            textViewStepCounter.setText("Counter Sensor is not Present");
            isCounterSensorPresent = false;

        }

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null)
        {
            mStepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isDetectorSensorPresent = true;
        }else{
            textViewStepDetector.setText("Detector Sensor is not Present");
            isDetectorSensorPresent = false;

        }


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent){
        if(sensorEvent.sensor == mStepCounter){
            stepCount = (int) sensorEvent.values[0];
            textViewStepCounter.setText(String.valueOf(stepCount));
        }else if(sensorEvent.sensor == mStepDetector){
            stepDetector = (int) (stepDetector + sensorEvent.values[0]);
            textViewStepDetector.setText(String.valueOf(stepDetector));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i){

    }

    @Override
    protected void  onResume(){
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null)
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!= null)
            sensorManager.registerListener(this,mStepDetector, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void  onPause(){
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null)
            sensorManager.unregisterListener(this,mStepCounter);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!= null)
            sensorManager.unregisterListener(this,mStepDetector);
    }
}
