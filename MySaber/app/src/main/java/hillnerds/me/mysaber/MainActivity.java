package hillnerds.me.mysaber;

import android.media.Image;
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

        Button btnRec1 = (Button) findViewById(R.id.btnRec1);

        btnRec1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("Test","record");
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
