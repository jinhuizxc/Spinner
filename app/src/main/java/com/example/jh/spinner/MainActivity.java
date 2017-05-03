package com.example.jh.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * 1.默认状态 操作布局文件里设置添加 android:entries="@array/language";
 * 在values/strings里面添加标签
 * 2.可以设置弹出对话框 在布局里面加上 android:spinnerMode="dialog"即可。下拉菜单均可以添加多项可滑动。
 * 3.spinner+适配器，spinner的监听弹出toast温馨提示
 *  并且列表项多时可以像listview那样拖动。
 *
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<HashMap<String, Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "item = " + i,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // 有图片文字的话选择数组链表 + hashmap存储
        // 图片
        int images[] = { R.drawable.a01, R.drawable.a02, R.drawable.a03,
                R.drawable.a04, R.drawable.a05 };
        // 文字
        String texts[] = { "aa", "bb", "cc", "dd", "ee" };

        // 数据源
        data = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < texts.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("text", texts[i]);
            map.put("image", images[i]);
            data.add(map);

        }
        // 简单适配器
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item,
                new String[] { "image", "text" }, new int[] { R.id.imageView1,
                R.id.textView1});
        //Spinner 菜单的使用类似于listview ，可以加载适配器
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setAdapter(adapter);
        // 设置监听
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, data.get(i).get("text") + " ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
