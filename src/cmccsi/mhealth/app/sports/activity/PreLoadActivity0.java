package cmccsi.mhealth.app.sports.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import cmccsi.mhealth.app.sports.R;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class PreLoadActivity0 extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		findViewById(R.id.linearLayout_loading_title).setVisibility(View.VISIBLE);
		// 是否是独立版的apk true表示是，false表示是非独立版的
//		RxP rxPermissions =new  RxPermissions(this);
		getPersimmionInfoLOgo();
		findViewById(R.id.linearLayout_loading_title).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					startActivity(new Intent(PreLoadActivity0.this,PreLoadActivity.class));
			}
		});

	}
	//**************授权信息
	private void getPersimmionInfoLOgo() {
		if (Build.VERSION.SDK_INT >= 23) {
			//1. 检测是否添加权限   PERMISSION_GRANTED  表示已经授权并可以使用
			if (ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
				//手机为Android6.0的版本,权限未授权去i请授权
				//2. 申请请求授权权限
				//1. Activity
				// 2. 申请的权限名称
				// 3. 申请权限的 请求码
				ActivityCompat.requestPermissions(this, new String[]
						{WRITE_EXTERNAL_STORAGE//通话记录
						}, 1005);
			} else {//手机为Android6.0的版本,权限已授权可以使用
				// 执行下一步
				startActivity(new Intent(this,PreLoadActivity.class));
			}
		} else {//手机为Android6.0以前的版本，可以使用
			startActivity(new Intent(this,PreLoadActivity.class));
		}

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

}
