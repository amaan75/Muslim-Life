package com.islamlife.andy_dev.muslim_life;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by andy-dev on 24-Sep-16.
 */

public class SalahData {
Context context;
        public SalahData(Context c) throws Exception {
            context = c;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.d("FILEMAIN", "HELLO");
                    Log.d("FILEMAIN", "FOS");
                    String path=getAlbumStorageDir(context,"salahdata")+"/salah.txt";
                    File f = new File(path);
                    FileOutputStream fos;
                    InputStream in;
                    String state = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state)) {
                    try {
                        in = new URL("http://www.salahtimes.com/india/bangalore").openStream();
                        fos =new FileOutputStream(f,false);
                        Log.d("FILE", String.valueOf(in));
                        Log.d("FILE", String.valueOf(fos));
                        InputStreamReader inR = new InputStreamReader(in);
                        BufferedReader buf = new BufferedReader(inR);
                        String line;
                        while ((line = buf.readLine()) != null) {
                            // System.out.println(line);
                            fos.write(line.getBytes());
                            //  Log.d("FOS",line);

                        }
                        in.close();
                        fos.close();
                    } catch (Exception e) {
                        Log.d("FILEMAIN", String.valueOf(e));
                        e.printStackTrace();
                    }}
                }
            });
            thread.start();
        }

        public File getAlbumStorageDir(Context context, String dirName) {
                // Get the directory for the app's private pictures directory.
                File file = new File(context.getExternalFilesDir(null), dirName);
                Log.d("FILEGETASTORAGE", String.valueOf(file));
                if (!file.mkdirs()) {
                        Log.d("FILENETIF", "Directory not created");
                }
                return file;
        }




}
