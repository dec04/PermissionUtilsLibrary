package com.dec04.permissionutils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int PERMISSION_REQUEST_CODE = 1;
    PermissionUtils permissionUtils;
    Context applicationContext;
    private final String[] permissions = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applicationContext = MainActivity.this;
        permissionUtils = new PermissionUtils(applicationContext);

        if (!permissionUtils.check(permissions)) {
            permissionUtils.requestPermission(permissions);
        } else {
            permissionUtils.requestPermission(permissions);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (permissionUtils.flagPermissionDenied) {
            // Permission was not granted, display error dialog.
            permissionUtils.showMissingPermissionError(permissions);
            permissionUtils.flagPermissionDenied = false;
        }
    }
}
