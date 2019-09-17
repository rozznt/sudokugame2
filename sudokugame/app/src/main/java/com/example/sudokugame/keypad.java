package com.example.sudokugame;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class keypad extends Dialog {
    protected static final String TAG ="SUDOKU";
    private  final View keys[] = new View[9];
    private  View keypad;
    private  final int useds [];
    private final PuzzelView puzzelView;

    public keypad(Context context, int useds[], PuzzelView puzzelView, View keypad){
        super(context);

        this.useds = useds;

        this.puzzelView = puzzelView;

    }

    @Override

    protected  void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keypad);
        findViews();
        for (int element:useds) {
            if (element != 0)
                keys[element - 1].setVisibility(View.INVISIBLE);

        }
        setListeners();

    }

    private void findViews(){
        keypad = findViewById(R.id.keypad);
        keys[0] = findViewById(R.id.btt1);
        keys[1] = findViewById(R.id.btt2);
        keys[2] = findViewById(R.id.btt3);
        keys[3] = findViewById(R.id.btt4);
        keys[4] = findViewById(R.id.btt5);
        keys[5] = findViewById(R.id.btt6);
        keys[6] = findViewById(R.id.btt7);
        keys[7] =findViewById(R.id.btt8);
        keys[8] = findViewById(R.id.btt9);

    }

    private  void setListeners(){
        for(int i= 0;i<keys.length;i++){
            final int t = i+1;
            keys[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    returnResult(t);

                }


            });
        }

    }

    private void returnResult(int tile) {
        puzzelView.setSelectedTile(tile);
        dismiss();
    }

    }




