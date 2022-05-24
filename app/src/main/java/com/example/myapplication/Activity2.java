package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity2 extends AppCompatActivity {


    //    private EditText edt_get_minutes;
    private Button button_get_when;

//    private EditText edt_get_when;
//    private TextView tv_get_minutes;

    private NumberPicker shower_picker;
    private NumberPicker when_picker1;
    private NumberPicker when_picker2;


    int fade_count;
    Handler handler;
    TextView m_switcher;

    Animation in;
    Animation out;


    FirebaseDatabase rootNote;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


//        edt_get_minutes = (EditText) findViewById(R.id.edt_input_minutes);
        shower_picker = (NumberPicker) findViewById(R.id.shower_length_picker);
        shower_picker.setMinValue(0);
        shower_picker.setMaxValue(100);

        when_picker1 = (NumberPicker) findViewById(R.id.when_picker1);
        when_picker1.setMinValue(0);
        when_picker1.setMaxValue(24);

        when_picker2 = (NumberPicker) findViewById(R.id.when_picker2);
        when_picker2.setMinValue(0);
        when_picker2.setMaxValue(60);


        button_get_when = (Button) findViewById(R.id.get_when_button);
//        edt_get_when = (EditText) findViewById(R.id.edt_input_when);


        button_get_when.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String target = Integer.toString(shower_picker.getValue());
//                String when1 = Integer.toString(when_picker1.getValue());
//                String when2 = Integer.toString(when_picker2.getValue());

                int target = shower_picker.getValue();
                String when1 = Integer.toString(when_picker1.getValue());
                String when2 = Integer.toString(when_picker2.getValue());
                String connect_when = when1 + ":" + when2 + ":" + "00";




                Helper helper = new Helper(target, connect_when);
                rootNote = FirebaseDatabase.getInstance();
                reference = rootNote.getReference("user1");

                reference.setValue(helper);

                fade_count = 0;
                handler = new Handler();

                m_switcher = (TextView) findViewById(R.id.done_txt);
                m_switcher.setText("Great! Done.");

                in = new AlphaAnimation(0.0f, 1.0f);
                in.setDuration(1000);

                out = new AlphaAnimation(0.0f, 1.0f);
                out.setDuration(1000);
                out.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
//                        if(fade_count == 3){
//                            m_switcher.setText("");
//                        }
//                        else {
//                            fade_count++;
//                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                m_switcher.setText("Great! Done.");
                m_switcher.startAnimation(in);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openActivity1();
                    }
                },1000);




            }

        });


    }
    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    public void read_minutes() {
//        String min_input = edt_get_minutes.getText().toString();
//        tv_get_minutes.setText(min_input);
//    }
}