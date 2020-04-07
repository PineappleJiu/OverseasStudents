package m.com.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import m.com.service.Fragment.SplashFragment;
import m.com.service.global.AppContants;
import m.com.service.utils.SpUtils;
import m.com.service.view.transformer.ScaleTransformer;


/*@Describe: 第一次启动显示页 */

public class SplashActivity extends AppCompatActivity {

    private ViewPager mVpMain;
    //显示的图片资源
    public int[] mResIds = new int[]{
            R.drawable.start1,
            R.drawable.start2,
            R.drawable.start3,
    };


    public Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVpMain = findViewById(R.id.vp_main);
        mVpMain.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return SplashFragment.newInstance(mResIds[i]);
            }
            @Override
            public int getCount() {
                return mResIds.length;
            }
        });


        mVpMain.setPageTransformer(true,new ScaleTransformer());

        btnStart = findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //this前面为当前activty名称，class前面为要跳转到得activity名称
                intent.setClass(SplashActivity.this, JudgeActivity.class);
                startActivity(intent);
                SpUtils.putBoolean(SplashActivity.this, AppContants.FIRST_OPEN, true);
                finish();
            }
        });

    }
}
