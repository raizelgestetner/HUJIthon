package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView tv_get_minutes;
    private EditText edt_get_minutes;

    private Button get_time_button;

    ;

    FirebaseDatabase wdatabase;
    DatabaseReference refdatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.SetShowerButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });


        tv_get_minutes = (TextView) findViewById(R.id.textView);

        wdatabase = FirebaseDatabase.getInstance();
        refdatabase = wdatabase.getReference("user2");

//        get_time_button = (Button) findViewById(R.id.GetTimeButton);
//
//        get_time_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                refdatabase.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        List<String> data = new ArrayList<>();
//                        for (DataSnapshot keyNote : snapshot.getChildren()) {
//                            data.add( String.valueOf(keyNote.getValue()) );
//                        }
//
//                        InfoFromApp info = new InfoFromApp();
//                        info.setTarget(data.get(0));
//                        tv_get_minutes.setText(String.format("Currently you have:\n %s\n minutes of hot water.", info.getTarget()));
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//
//                });
//            }
//        });

//        wdatabase = FirebaseDatabase.getInstance();
//        refdatabase = wdatabase.getReference("user2");
        refdatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        List<String> data = new ArrayList<>();
                        for (DataSnapshot keyNote : snapshot.getChildren()) {
                            data.add( String.valueOf(keyNote.getValue()) );
                        }

                        InfoFromApp info = new InfoFromApp();
                        info.setTarget(data.get(0));
                        tv_get_minutes.setText(String.format("Currently you have:\n %s\n minutes of hot water.", info.getTarget()));

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });


//        RefreshTimeButton = (Button) findViewById(R.id.GetTimeButton);


    }


    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

//    public void read_minutes() {
////        String min_input = edt_get_minutes.getText().toString();
//        tv_get_minutes.setText(info.);
//    }
//}


}
