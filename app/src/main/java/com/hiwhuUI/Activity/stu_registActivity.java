package com.hiwhuUI.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.hiwhu.hiwhuclient.R;

import java.io.IOException;
import java.net.*;

import HttpConnect.HttpUtil;
import data.staticData;
import okhttp3.Call;
import okhttp3.Response;

public class stu_registActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_regist);

        //更改标题栏
        TextView title = (TextView)findViewById(R.id.text_title) ;
        title.setText("注册");
        Button back = (Button)findViewById(R.id.button_backward);
        back.setText("返回");
        //返回消息主页
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button forward = (Button)findViewById(R.id.button_forward);
        forward.setText(null);
        //隐藏默认标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        final EditText stuIdtext = (EditText) findViewById(R.id.p1_edit_stu_num);
        final EditText userNametext = (EditText) findViewById(R.id.p2_edit_stu_username);
        final EditText passwordText = (EditText) findViewById(R.id.p3_edit_stu_password);
        Button button1 = (Button) findViewById(R.id.btn_stu_regist);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = staticData.getUrl()+"/AddStudentServlet";
                String studentId = stuIdtext.getText().toString();
                String username = userNametext.getText().toString();
                String password = passwordText.getText().toString();
                try{
                    username = java.net.URLEncoder.encode(username,"UTF-8");
                    Log.e("uesrname---",username);
                    url = url+"?studentID="+studentId+"&userName="+ username +"&password="+password;
                    Log.e("url----",url);
                }catch(Exception e){
                    e.printStackTrace();
                }
               HttpUtil.sendOkHttpRequest(url,new okhttp3.Callback(){
                   @Override
                   public void onResponse(Call call, Response response) throws IOException {
                       String s = response.body().string();
                       Log.e("return---",s);
                       if(s.equals("succeed\r\n")){
                           Jump(true);
                       }else{
                           Jump(false);
                       }
                   }

                   @Override
                   public void onFailure(Call call, IOException e) {
                   }
               });

            }
        });
    }

    public void Jump(final boolean flag){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(flag){
                    Toast.makeText(stu_registActivity.this,"您已经成功注册！",Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(stu_registActivity.this,"注册失败！",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
