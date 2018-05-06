package com.eways.etutor.Utils.Handler;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ADMIN on 4/21/2018.
 */

public class ReadTextHandler {
    Activity mActivity;
    public ReadTextHandler(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public String readTxt(String fileName){
        String mystring = null;
        try {
            InputStream in= mActivity.getAssets().open(fileName);
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            mystring = new String(buffer);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mystring;
    }

    public String readPdf(String fileName){
        String parsedText="";
        try {
            Uri path = Uri.parse("file:///android_asset/"+fileName);
            String newPath = path.toString();
            String temp = newPath;

            PdfReader reader = new PdfReader(newPath);
            int n = reader.getNumberOfPages();
            for (int i = 0; i <n ; i++) {
                parsedText   = parsedText+ PdfTextExtractor.getTextFromPage(reader, i+1).trim()+"\n"; //Extracting the content from the different pages
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
            Log.d("readFile", String.valueOf(e));
        }


        return parsedText;
    }
}
