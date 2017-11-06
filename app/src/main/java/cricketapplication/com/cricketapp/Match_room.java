package cricketapplication.com.cricketapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Amey on 05-Nov-17.
 */



class Match_room extends AppCompatActivity {


    private Button Send_Button;
    private Button Run_1_button;
    private Button Run_2_button;
    private Button Run_3_button;
    private Button Run_4_button;
    private Button Run_5_button;
    private Button Run_6_button;
    private Button No_ball_button;
    private Button Wide_ball_button;
    private Button Wicket_button;
    private EditText Text_to_send;
    private TextView sent_text;
    private DatabaseReference root;
    private String tempKey;
    private String user = "Amey";
    private String latest_msg;
    private String latest_msg_name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_room_layout3);

        Send_Button = findViewById(R.id.Send_button);
        Run_1_button = findViewById(R.id.Run_1_button);
        Run_2_button = findViewById(R.id.Run_2_button);
        Run_3_button = findViewById(R.id.Run_3_button);
        Run_4_button = findViewById(R.id.Run_4_button);
        Run_5_button = findViewById(R.id.Run_5_button);
        Run_6_button = findViewById(R.id.Run_6_button);
        No_ball_button = findViewById(R.id.No_ball_button);
        Wide_ball_button = findViewById(R.id.Wide_ball_button);
        Wicket_button = findViewById(R.id.Wicket_button);
        Text_to_send = findViewById(R.id.Text_to_Send);
        sent_text = findViewById(R.id.What_was_sent);


        root = FirebaseDatabase.getInstance().getReference().child("ScrollText");

        sent_text.setKeyListener(null);
        Send_Button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Map<String, Object> map = new HashMap<String, Object>();

                tempKey = root.push().getKey();
                root.updateChildren(map);

                DatabaseReference message_root = root.child(tempKey);
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("msg", Text_to_send.getText().toString());
                map2.put("name", user);


                message_root.updateChildren(map2);


            }
        });

        Run_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("1 run");
            }
        });

        Run_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("2 runs");
            }
        });
        Run_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("3 runs");
            }
        });
        Run_4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("4 runs");
            }
        });
        Run_5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("5 runs");
            }
        });
        Run_6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("6 runs");
            }
        });

        No_ball_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("No Ball");
            }
        });

        Wicket_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Wicket!");
            }
        });



        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                change_child_convo(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }



    private void change_child_convo(DataSnapshot dataSnapshot) {

        Iterator i = dataSnapshot.getChildren().iterator();
        while (i.hasNext()) {

            latest_msg = (String)((DataSnapshot) i.next()).getValue();
            latest_msg_name = (String)((DataSnapshot) i.next()).getValue();
            sent_text.setText(latest_msg);

        }

    }


}
