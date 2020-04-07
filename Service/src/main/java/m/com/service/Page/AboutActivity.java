package m.com.service.Page;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import m.com.service.R;

public class AboutActivity extends Activity{
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.about_activity);

        TextView mName = findViewById(R.id.About_Name);
        mName.setText("开发者：PineappleJiu");
        mName.setTextColor(Color.BLUE);
        mName.setGravity(Gravity.CENTER);
        TextView mAbout_Number = findViewById(R.id.About_Number);
        mAbout_Number.setText("学号：1160299298");
        mAbout_Number.setTextColor(Color.BLUE);

        TextView mAbout_Class = findViewById(R.id.About_Class);
        mAbout_Class.setText("班级：计算机162");
        mAbout_Class.setTextColor(Color.BLUE);

        TextView mAbout_Build = findViewById(R.id.About_Build);
        mAbout_Build.setText("版本号：1.0.0");
        mAbout_Build.setTextColor(Color.BLUE);


    }
}
