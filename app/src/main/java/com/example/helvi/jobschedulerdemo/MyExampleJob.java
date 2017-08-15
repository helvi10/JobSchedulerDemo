package com.example.helvi.jobschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

/**
 * Created by Helvi on 8/15/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyExampleJob extends JobService
{
    private JobParameters params;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        this.params = params;
          		Toast.makeText(getApplicationContext(), "starting job service...", Toast.LENGTH_SHORT).show();
         		new MyExampleTask().execute();
        	return true;

    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    private class MyExampleTask extends AsyncTask<Void, Void, Void> {


       		@Override
 		protected void onPostExecute(Void aVoid) {
           			super.onPostExecute(aVoid);
             			jobFinished(params, false);
            			Toast.makeText(getApplicationContext(), "Finish job", Toast.LENGTH_SHORT).show();
            		}


        		@Override
		protected Void doInBackground(Void... params) {
            			try {
                				Thread.sleep(2000);
                			} catch (InterruptedException e) {
               				e.printStackTrace();
               			}return null;
            	}
	}
 }


