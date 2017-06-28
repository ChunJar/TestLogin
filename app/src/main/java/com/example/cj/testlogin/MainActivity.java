package com.example.cj.testlogin;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton nan, nv;
    private RadioGroup sexGroup;
    private CheckBox swim, travel, sleep, dance, music, sing;
    private Button login;
    private CheckBox isShow;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化RadioGroup
        sexGroup = (RadioGroup) findViewById(R.id.sexGroup);
        //初始化单选按钮控件
        nan = (RadioButton) findViewById(R.id.nan);
        nv = (RadioButton) findViewById(R.id.nv);
        //初始化CheckBox
        swim = (CheckBox) findViewById(R.id.swim);
        travel = (CheckBox) findViewById(R.id.travel);
        sleep = (CheckBox) findViewById(R.id.sleep);
        dance = (CheckBox) findViewById(R.id.dance);
        music = (CheckBox) findViewById(R.id.music);
        sing = (CheckBox) findViewById(R.id.sing);
        //初始化登录按钮
        login = (Button) findViewById(R.id.login);
        //初始化明密文切换选项
        isShow = (CheckBox) findViewById(R.id.isShow);
        //初始化密码输入框
        password = (EditText) findViewById(R.id.password);

//        给单选按钮设置监听
//        nan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    Toast.makeText(MainActivity.this, "已选中:" + nan.getText(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        nv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    Toast.makeText(MainActivity.this, "已选中：" + nv.getText(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        //直接给RadioGroup设置监听
        sexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.nan:
                        Toast.makeText(MainActivity.this, "已选中：" + nan.getText(), Toast.LENGTH_SHORT).show();
                    case R.id.nv:
                        Toast.makeText(MainActivity.this, "已选中：" + nv.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        //给登录按钮设置监听
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_SHORT).show();
            }
        });
        //给明密文切换选项设置监听
        isShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                password.setSelection(password.getText().length());
            }
        });
    }
}
