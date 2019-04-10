package com.picardystudios.permisos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndPermission.with(MainActivity.this)
                .runtime()
                .permission(Permission.Group.CAMERA)
                .onGranted(permissions -> {
                    Toast.makeText(MainActivity.this, "Concedenos permiso para utilizar la camara", Toast.LENGTH_LONG).show();
                })
                .onDenied(permissions -> {
                    Log.e("PERMISOS","Concedenos permiso para utilizar la camara");
                    Toast.makeText(MainActivity.this, "Concedenos permiso para utilizar la camara", Toast.LENGTH_LONG).show();
                })
                .start();
    }
}
