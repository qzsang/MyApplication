package com.example.administrator.hxtest.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hxtest.R;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    @ViewInject(id = R.id.lv_users)
    ListView lv_users;


    List<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        FinalActivity.initInjectedView(this);
        init();
    }

    public void init () {
        String userName = "test";
        for (int i = 0;i < 10;i++) {
            String t = userName + i;
            list.add(t);
        }
        lv_users.setAdapter(new MyAdapter(this,R.layout.activity_user_list,list));
        lv_users.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(UserListActivity.this, "你点了" + list.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UserListActivity.this,ChatActivity.class);
                intent.putExtra("user",list.get(position) + "");
                UserListActivity.this.startActivity(intent);
            }
        });

    }




    class MyAdapter extends ArrayAdapter<String> {
        List<String> list;
        public MyAdapter(Context context, int resource, List<String> list) {
            super(context, resource, list);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null){
                convertView = View.inflate(UserListActivity.this,R.layout.item_userlist,null);
            }
            TextView txt = (TextView) convertView.findViewById(R.id.txt);
            txt.setText("（name:）" + list.get(position) );

            return convertView;
        }
    }
}
