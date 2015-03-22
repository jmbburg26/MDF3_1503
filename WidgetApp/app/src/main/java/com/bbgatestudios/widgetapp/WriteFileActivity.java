package com.bbgatestudios.widgetapp;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

/**
 * Created by john_brandenburg on 3/16/15.
 */
public class WriteFileActivity {

    private static final String FILENAME = "contact_list.txt";
    static File external;

    public static void writeToFile(Context _c, String _filename, String _data) {
        external = _c.getExternalFilesDir(null);
        File file = new File(external, _filename);

        try {
            FileOutputStream fos = new FileOutputStream(file);

            // Wrapping our file stream.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Writing the serializable object to the file
            oos.write(_data.getBytes());

            // Closing our object stream which also closes the wrapped stream.
            oos.close();
            Log.i("WRITE_SUCCESS", "Your data has been stored.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static String readContactsFromFile(String _filename) {
//
//        external = getExternalFilesDir(null);
//        File file = new File(external, _filename);
//
//        try {
//            FileInputStream fin = new FileInputStream(file);
//            InputStreamReader inReader = new InputStreamReader(fin);
//            BufferedReader reader = new BufferedReader(inReader);
//
//            // Reading data from our file using the reader
//            // and storing it our string buffer.
//            StringBuffer buffer = new StringBuffer();
//            String text = null;
//            // Make sure a line of text is available to be read.
//            while((text = reader.readLine()) != null) {
//                buffer.append(text + "\n");
//            }
//            // Close the reader and underlying stream.
//            reader.close();
//            // Convert the buffer to a string.
//            return buffer.toString();
//
//            Log.i("READ_SUCCESS", "Your data has been read.");
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
}
