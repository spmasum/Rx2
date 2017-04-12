package com.example.rx.rx;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Prescription extends AppCompatActivity {

    private ImageView pImageIV;
    private Button takePhotoBtn;
    private Bitmap bitmap;
    private int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        pImageIV= (ImageView) findViewById(R.id.prescriptionImage);
        takePhotoBtn= (Button) findViewById(R.id.takePhoto);
    }

    public void takePhoto(View view) {
        //--taking photo--
        if (flag==0){
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,5);
        }
        //--saving photo
        else if (flag==1){
            SavePhotoSDCard.savePhotoToSdCard(bitmap);
            flag=0;
            takePhotoBtn.setText("Take Photo");
            Toast.makeText(getApplicationContext(),"Save photo into SD card",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==5 && resultCode==RESULT_OK && data!=null){
            bitmap= (Bitmap) data.getExtras().get("data");
            pImageIV.setImageBitmap(bitmap);

            flag=1;
            takePhotoBtn.setText("Save Photo");
        }


    }


}
