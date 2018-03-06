package cricketapplication.com.cricketapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button live_match;
    private Button Other_button;
    private ImageButton image_button;
    private ImageView cricView;
    private ImageView tennisView;


    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //live_match = (Button) findViewById(R.id.Live_Button);
        //image_button = (ImageButton) findViewById(R.id.imageButton);
        cricView = findViewById(R.id.cric_image);
        tennisView = findViewById(R.id.Ten_image);


        cricView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Match_room.class);
                startActivity(intent);
            }
        });



        
    }
}
