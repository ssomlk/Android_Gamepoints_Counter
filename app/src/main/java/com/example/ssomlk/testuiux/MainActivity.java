package com.example.ssomlk.testuiux;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText teamA;
    private EditText teamB;
    private Button buttonStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }

    private void initializeViews(){
        this.teamA = (EditText) findViewById(R.id.name_a);
        this.teamB = (EditText) findViewById(R.id.name_b);
        this.buttonStartGame = (Button) findViewById(R.id.game);

        this.buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateTeams()){
                    Intent intent = new Intent(view.getContext(), GameActivity.class);
                    intent.putExtra("team_a",teamA.getText().toString());
                    intent.putExtra("team_b",teamB.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(view.getContext(), "Team A and Team B must have values.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validateTeams(){
        if(this.teamA.getText().toString().equals("") || this.teamB.getText().toString().equals("") ){
            return false;
        }
        return true;
    }
}
