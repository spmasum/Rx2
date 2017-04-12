package com.example.rx.rx;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Masum on 09-Apr-17.
 */

public class SavePhotoSDCard {
    public static void savePhotoToSdCard(Bitmap bitmap1) {
        Log.d("Masum","asdf");
        //--create photo name--
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        Log.d("Masum","ere");
        String pName=""+sdf.format(new Date(System.currentTimeMillis()));



        Log.d("Masum", pName);
        // String pName="a";


        //--get sdcard path directory--
        String root= Environment.getExternalStorageDirectory().toString();

        //--create a file  for saving photo into sd card--
        File folder=new File(root+"/MedipastCM");
        folder.mkdirs();

        //--create another file for saving photo into creating folder file
        File myImageFile=new File(folder,pName+".png");
        try{
            FileOutputStream stream=new FileOutputStream(myImageFile);
            bitmap1.compress(Bitmap.CompressFormat.PNG,80,stream);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
