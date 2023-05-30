package com.example.pz11_makarow_pr22_105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
        setContentView(R.layout.layout);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public boolean Started = false;
    public boolean Finished = false;
    public void Start(View view)
    {
        Button button = (Button)findViewById(R.id.btn_start);
        if(!Finished)
        {
            if(!Started) {
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }
            else
            {
                if(Started)
                {
                    button.setBackgroundColor(Color.GREEN);
                    button.setText("Старт");
                    Started = false;
                }

            }
        }
        else
        {
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        }

    }
    public void Drive(View view)
    {
        Button button = (Button)findViewById(R.id.btn_start);
        View car = (View)findViewById(R.id.purple);
        TextView result = (TextView) findViewById(R.id.result);
        if(Started && !Finished)
        {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)car.getLayoutParams();
            margin.leftMargin+=40;
            margin.rightMargin-=40;
            car.requestLayout();
            if(margin.rightMargin <= -100)
            {
                result.setText("Победа первого игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }

        }
    }
    public void Drive2(View view)
    {
        Button button = (Button)findViewById(R.id.btn_start);
        View car = (View)findViewById(R.id.yellow);
        TextView result = (TextView) findViewById(R.id.result);
        if(Started && !Finished)
        {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)car.getLayoutParams();
            margin.leftMargin+=40;
            margin.rightMargin-=40;
            car.requestLayout();
            if(margin.rightMargin <= -100)
            {
                result.setText("Победа второгоигрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }

        }
    }
}