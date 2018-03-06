package cricketapplication.com.cricketapp;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.IDN;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Amey on 05-Nov-17.
 */



public class Match_room extends AppCompatActivity {


    private Button Send_Button;
    private Button Run_0_button;
    private Button Run_1_button;
    private Button Run_2_button;
    private Button Run_3_button;
    private Button Run_4_button;
    private Button Run_5_button;
    private Button Run_6_button;
    private Button No_ball_button;
    private Button Wide_ball_button;
    private Button Wicket_button;
    private Button InAir_button;
    private Button RunOut_button;
    private Button BallButton;
    private EditText Text_to_send;
    private TextView sent_text;
   // private DatabaseReference root;
    private String tempKey;

    private String user = "Amey";
    private String latest_msg;
    private String latest_msg_name;
    private Spinner matchSelect;
    public ArrayList<String> Idname;
    public ArrayList<String> t1name;
    public ArrayList<String> t2name;
    public ArrayList<String> teamnames;
    public ArrayList<String> matchnumbers;

    //  String URL="http://cricapi.com/api/matches?apikey=s0JbhGk8mESELjJzZu5E6ginilP2";
    String URL = "https://cricscore-api.appspot.com/csa";
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("ScrollText");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_room_layout3);
        matchSelect = findViewById(R.id.selectMatchSpinner);

        Send_Button = findViewById(R.id.Send_button);
        Run_0_button = findViewById(R.id.Run_0_button);
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
        InAir_button = findViewById(R.id.InAir_button);
        RunOut_button = findViewById(R.id.RunOut_button);
      BallButton = findViewById(R.id.Ball_button);

        Idname = new ArrayList<>();
        t1name = new ArrayList<>();

        t2name = new ArrayList<>();
        teamnames = new ArrayList<>();
        matchnumbers = new ArrayList<>();





        loadSpinnerData(URL);

        matchSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Map<String, Object> map = new HashMap<String, Object>();
                map.put(matchnumbers.get(i),"");

                root = FirebaseDatabase.getInstance().getReference().child(matchnumbers.get(i));
                root.updateChildren(map);



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







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
        Run_0_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Zero");
            }
        });

        Run_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("one");
            }
        });

        Run_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Two");
            }
        });
        Run_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Three");
            }
        });
        Run_4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Four");
            }
        });
        Run_5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Five");
            }
        });
        Run_6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Six");
            }
        });

        No_ball_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("No Ball");
            }
        });

        Wide_ball_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Wide Ball");
            }
        });

        Wicket_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Wicket!");
            }
        });

        InAir_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Ball in Air");
            }
        });

        RunOut_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Run Out");
            }
        });
        BallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_to_send.setText("Ball");
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
    private void loadSpinnerData(String url) {


        matchnumbers.add("Match 1");
        matchnumbers.add("Match 2");


        /*
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{

//for cricappspot

                    JSONArray jsonArray=new JSONArray(response);
                    // JSONArray jsonArray=jsonObject.getJSONArray("");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        String id=jsonObject1.getString("id");
                        Idname.add(id);
                        String t1=jsonObject1.getString("t1");
                        t1name.add(t1);
                        String t2=jsonObject1.getString("t2");
                        t2name.add(t2);
                        // teamnames.add(t1name +t2name);
                        teamnames.add(t1name.get(i)+" vs "+t2name.get(i));

                    }

                    */
                    /*
//for cricapi
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("matches");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jo = jsonArray.getJSONObject(i);

                        String id=jo.getString("unique_id");
                        Idname.add(id);
                        String matchStarted =jo.getString("matchStarted");
                        String t1 = jo.getString("team-1");
                        t1name.add(t1);
                        String t2 = jo.getString("team-2");
                        t2name.add(t2);
                        if(matchStarted.equals("true")) {

                            teamnames.add(t1name.get(i) + " vs " + t2name.get(i));
                        }
                        // teamnames.add(t1name +t2name);


                    }

                  //  System.out.println(teamnames);
                  */
/*
                    matchSelect.setAdapter(new ArrayAdapter<String>(Match_room.this, android.R.layout.simple_spinner_dropdown_item,  teamnames ));
                }catch (JSONException e){e.printStackTrace();}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }
*/

        matchSelect.setAdapter(new ArrayAdapter<String>(Match_room.this, android.R.layout.simple_spinner_dropdown_item,  matchnumbers ));

}}
