package cricketapplication.com.cricketapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button live_match;
    private Button Other_button;
    private ImageButton image_button;

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().getRoot();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        live_match = (Button) findViewById(R.id.Live_Button);
        image_button = (ImageButton) findViewById(R.id.imageButton);


        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Match_room.class);
                startActivity(intent);
            }
        });

        live_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(),Match_room.class);
                startActivity(intent);



                }

        });
    }
}
