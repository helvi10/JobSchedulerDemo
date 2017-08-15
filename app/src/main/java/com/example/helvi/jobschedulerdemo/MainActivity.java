package com.example.helvi.jobschedulerdemo;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn_start, btn_stop;
    JobScheduler jobScheduler;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button) findViewById(R.id.button1);
        btn_stop = (Button) findViewById(R.id.button2);

        jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(getPackageName(),
                        MyExampleJob.class.getName()));


                //run job service after every 5 seconds
                builder.setPeriodic(5000);
                jobScheduler.schedule(builder.build());

            }
        });
        /*@Override
        protected void onPause() {
            		super.onPause();
             		jobScheduler.cancelAll(); //remove job service onPause
             	}*/

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                jobScheduler.cancelAll();
                Toast.makeText(MainActivity.this, "cancel job", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
