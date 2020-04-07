package m.com.service.Page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import m.com.service.R;

public class FourthActivity extends Activity {
    private String[] strs = new String[]{"More1","More2","More3","修改个人信息","关于"};
    private ListView list = null;
    private TextView mName;
    private ImageView mIcon;
    private Button unlogin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置当前Activity界面布局
        setContentView(R.layout.fourth_activity);
        // 通过findViewById方法实例化组件
        mName = (TextView) this.findViewById(R.id.username);
        mIcon = (ImageView) this.findViewById(R.id.more_icon);
        list = (ListView) this.findViewById(R.id.more_list);
        mIcon.setImageResource(R.drawable.icon);
        mIcon.setEnabled(true);
        unlogin = (Button) this.findViewById(R.id.more_unlogin);
        unlogin.setVisibility(View.GONE);
//        Declare declare = (Declare) FourthActivity.this.getApplication();
//        mName.setText(declare.getUserName());
        mName.setText("TestName");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                if(arg2 == 0){
                    Intent intent  = new Intent(FourthActivity.this, MoreList1Activity.class);
                    startActivity(intent);
                }
                if(arg2 == 1){
                    Intent intent  = new Intent(FourthActivity.this, MoreList2Activity.class);
                    startActivity(intent);
                }
                if(arg2 == 2){
                    Intent intent  = new Intent(FourthActivity.this, MoreList3Activity.class);
                    startActivity(intent);
                }
                if(arg2 == 3){
                    Intent intent  = new Intent(FourthActivity.this, ChangeMessagesActivity.class);
                    startActivity(intent);
                }
                if(arg2 == 4){
                    Intent intent  = new Intent(FourthActivity.this, AboutActivity.class);
                    startActivity(intent);
                }


            }
        });
        list.setAdapter(new BaseAdapter() {

            @Override
            public View getView(int arg0, View arg1, ViewGroup arg2) {
                // TODO Auto-generated method stub
                ListViewItem item = new ListViewItem(FourthActivity.this, strs[arg0]);
                return item;
            }

            @Override
            public long getItemId(int arg0) {
                // TODO Auto-generated method stub
                return arg0;
            }

            @Override
            public Object getItem(int arg0) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return strs.length;
            }
        });


        mIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(FourthActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    public class ListViewItem extends RelativeLayout{
        private TextView mTvColumnName;//栏目名称
        private ImageView mIvColumnImg;//栏目logo
        public ListViewItem(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }
        public ListViewItem(Context context,String columnInfo) {
            super(context,null);
            View view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            mTvColumnName = (TextView) view.findViewById(R.id.column_name);
            mIvColumnImg = (ImageView) view.findViewById(R.id.column_img);
            mTvColumnName.setText(columnInfo);
            addView(view);
        }
    }
}
