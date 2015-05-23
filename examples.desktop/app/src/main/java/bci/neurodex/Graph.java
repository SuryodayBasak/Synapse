package bci.neurodex;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by suryo on 23/5/15.
 */
public class Graph extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_layout);

        readFile();
    }



    //public void readFile(View v) {

    public void readFile() {
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File (sdCard.getAbsolutePath() + "/synapse/");


        File file = new File(dir,"filename");

        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                int foo = Integer.parseInt(line);
                text.append(line);
                text.append('\n');
                //System.out.println(foo);
                //Toast.makeText(getApplicationContext(), foo, Toast.LENGTH_SHORT).show();

                String string1 = new Integer(foo).toString();
                TextView tv = (TextView)findViewById(R.id.indicator);
                tv.setText(string1);


            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }

//Find the view by its id
        //TextView tv = (TextView)findViewById(R.id.indicator);

//Set the text
        //tv.setText(text);

    }

}
