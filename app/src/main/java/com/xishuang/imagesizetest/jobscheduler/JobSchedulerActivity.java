package com.xishuang.imagesizetest.jobscheduler;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;

import com.xishuang.imagesizetest.R;

/**
 * Created by xishuang on 2018/2/6.
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerActivity extends Activity {
    private JobScheduler mJobScheduler;
    private View viewStub;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_colorfilter);
        mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
    }

    private void startJob(){
        JobInfo.Builder builder = new JobInfo.Builder(1,
                new ComponentName(getPackageName(), JobSchedulerService.class.getName()));

//                builder.setPeriodic(3000);
        builder.setMinimumLatency(3000);

        int result = mJobScheduler.schedule(builder.build());

        Log.d("息霜", "result:" + result);
        if (result == JobScheduler.RESULT_FAILURE) {
            //If something goes wrong
        }
    }
}
