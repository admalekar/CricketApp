package cricketapplication.com.cricketapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

/**
 * Created by Amey on 05-Nov-17.
 */



class Match_room extends AppCompatActivity{


    private Button Send_Button;
    private Button Run_1_button;
    private Button Run_2_button;
    private Button Run_3_button;
    private Button Run_4_button;
    private Button Run_5_button;
    private Button Run_6_button;
    private Button No_ball_button;
    private Button Wide_ball_button;
    private EditText Text_to_send;
    private TextView sent_text;
    private DatabaseReference root;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_room_layout);

        Send_Button = findViewById(R.id.Send_button);
        Run_1_button = findViewById(R.id.Run_1_button);
        Run_2_button = findViewById(R.id.Run_2_button);
        Run_3_button = findViewById(R.id.Run_3_button);
        Run_4_button = findViewById(R.id.Run_4_button);
        Run_5_button = findViewById(R.id.Run_5_button);
        Run_6_button = findViewById(R.id.Run_6_button);
        No_ball_button = findViewById(R.id.No_ball_button);
        Wide_ball_button = findViewById(R.id.Wide_ball_button);
        Text_to_send = findViewById(R.id.Text_to_Send);
        sent_text = findViewById(R.id.What_was_sent);


        root = FirebaseDatabase.getInstance().getReference()

    }
}
