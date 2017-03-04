package hillnerds.me.mysaber;

import android.graphics.Color;
import android.media.Image;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.Calendar;
import java.io.IOException;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final ImageView imBlade1 = (ImageView) findViewById(R.id.imageView);
        final ImageView imBlade2 = (ImageView) findViewById(R.id.imageView);

        final Button btnRec1 = (Button) findViewById(R.id.btnRec1);

        final boolean[] recording = {true};
        btnRec1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onRecord(recording[0],btnRec1);
                recording[0] = !recording[0];
            }
        });

        ImageButton  imbtnHilt = (ImageButton) findViewById(R.id.imageButton3);

        imbtnHilt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                imBlade1.setVisibility(VISIBLE);
                imBlade2.setVisibility(VISIBLE);
            }
        });

    }

    private void onRecord(Boolean start, Button btn){
        if(start){
            startRecording();
            btn.setBackgroundColor(Color.RED);
        }
        else{
            stopRecording();
            btn.setBackgroundColor(Color.GRAY);
        }
    }

    private MediaRecorder mRecorder = null;
    private void startRecording() {
        mRecorder = new MediaRecorder();
        String filename = "";

        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(filename);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e("HNtest", "prepare() failed");
        }

        mRecorder.start();
    }

    private String filenameCreate(){

        String filename = "";

        filename =  getExternalCacheDir().getAbsolutePath();
        filename += "/Recordings";
        Calendar c = Calendar.getInstance();
        int seconds = c.get(Calendar.SECOND);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int mins = c.get(Calendar.DAY_OF_MONTH);
        filename += (seconds + "_" + "_" + hour + "_" + mins);
        filename += ".3gp";
        return filename;


    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (super.onOptionsItemSelected(item)) return true;
        else return false;
    }



}
