package com.example.administrator.myapplication;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }



    public void testOKHttp () {


         class GetExample {
            OkHttpClient client = new OkHttpClient();

            String run(String url) throws IOException {
                Request request = new Request.Builder()
                        .url(url)
                        .build();




                Response response = client.newCall(request).execute();

                if (response.isSuccessful())
                    return response.body().string();
                else
                    return "code:" + response.code()+","+response;
            }

        }
        GetExample example = new GetExample();
        String response = null;
        try {
            response = example.run("https://raw.github.com/square/okhttp/master/README.md");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.e("response",","+ response + ",");

    }

    public void testMain() {
        String TAG = "TestMain";

       File dexOutputDir = getContext().getDir("dex", 0);
        ;
        Log.e(TAG,","+ getContext().getApplicationInfo().nativeLibraryDir + ",\n"+dexOutputDir.toString());
    }

}