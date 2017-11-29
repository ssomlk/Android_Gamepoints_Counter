package com.example.ssomlk.testuiux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView team_a;
    private TextView team_b;
    private TextView team_a_totalView;
    private TextView team_b_totalView;

    private Button team_a_3;
    private Button team_a_2;
    private Button team_a_1;
    private Button team_b_3;
    private Button team_b_2;
    private Button team_b_1;

    private Button reset_score;

    private int team_a_total = 0;
    private int team_b_total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent  = getIntent();

        initializeViews();
        this.team_a.setText(intent.getStringExtra("team_a"));
        this.team_b.setText(intent.getStringExtra("team_b"));

        setButtonEvents();

    }

    private void setButtonEvents(){
        this.team_a_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoints(view);
            }
        });

        this.team_a_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoints(view);
            }
        });

        this.team_a_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoints(view);
            }
        });

        this.team_b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoints(view);
            }
        });

        this.team_b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoints(view);
            }
        });

        this.team_b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoints(view);
            }
        });

        this.reset_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team_a_total = 0;
                team_b_total = 0;
                resetScore();
            }
        });
    }

    private void initializeViews() {
        this.team_a = (TextView) findViewById(R.id.team_a_game);
        this.team_b = (TextView) findViewById(R.id.team_b_game);

        this.team_a_totalView = (TextView) findViewById(R.id.team_a_game_points);
        this.team_b_totalView = (TextView) findViewById(R.id.team_b_game_points);

        this.team_a_3 = (Button) findViewById(R.id.team_a_game_3);
        this.team_a_2 = (Button) findViewById(R.id.team_a_game_2);
        this.team_a_1 = (Button) findViewById(R.id.team_a_game_1);

        this.team_b_3 = (Button) findViewById(R.id.team_b_game_3);
        this.team_b_2 = (Button) findViewById(R.id.team_b_game_2);
        this.team_b_1 = (Button) findViewById(R.id.team_b_game_1);

        this.reset_score = (Button) findViewById(R.id.reset_score);
    }

    private void resetScore(){
        this.team_a_totalView.setText("0");
        this.team_b_totalView.setText("0");
    }

    private void addPoints(View view){
        if(view.getId() == R.id.team_a_game_3){
            this.team_a_total += 3;
        }else if(view.getId() == R.id.team_a_game_2){
            this.team_a_total += 2;
        }else if(view.getId() == R.id.team_a_game_1){
            this.team_a_total += 1;
        }else if(view.getId() == R.id.team_b_game_3){
            this.team_b_total += 3;
        }else if(view.getId() == R.id.team_b_game_2){
            this.team_b_total += 2;
        }else{
            this.team_b_total += 1;
        }
        changeScoreView(view);
    }

    private void changeScoreView(View view){
        if(view.getId() == R.id.team_a_game_3){
            this.team_a_totalView.setText(String.valueOf(this.team_a_total));
        }else if(view.getId() == R.id.team_a_game_2){
            this.team_a_totalView.setText(String.valueOf(this.team_a_total));
        }else if(view.getId() == R.id.team_a_game_1){
            this.team_a_totalView.setText(String.valueOf(this.team_a_total));
        }else if(view.getId() == R.id.team_b_game_3){
            this.team_b_totalView.setText(String.valueOf(this.team_b_total));
        }else if(view.getId() == R.id.team_b_game_2){
            this.team_b_totalView.setText(String.valueOf(this.team_b_total));
        }else{
            this.team_b_totalView.setText(String.valueOf(this.team_b_total));
        }
    }
}
