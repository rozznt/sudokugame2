package com.example.sudokugame;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class Game extends Activity {
    private static final String TAG = "Sudoku";
    public static final String Key_Difficulty = "org.example.sudoku.difficulty";
    public static final int Difficulty_easy = 0;
    public static final  int Difficulty_medium = 1;
    public static final int Difficulty_hard =2 ;
    private int puzzle[] = new int [9*9];
    private  PuzzelView puzzelView;

    private final String easyPuzzle =
            "450000000032498000000007800"+
                    "06050001230000075900011030"+
                    "00200000000603230000000078";
            private final  String medidumPuzzle =
                    "15000005000060500002600006"+
                            "008009000006433500000300700"+
                            "400000130000101000040000025";
            private  final String hardPuzzle =
                    "0090000000030102060402038000"+
                            "000000800805030204007000000"+
                            "000610102030402060000000700";
            @Override
    protected void onCreate(Bundle savedInstanceState){
                super.onCreate((savedInstanceState));
                Log.d(TAG,"onCreate");
                int diff = getIntent().getIntExtra(Key_Difficulty,Difficulty_easy);
                puzzle = getPuzzle(diff);
                calculateUsedTiles();
                puzzelView = new PuzzelView(this);
                setContentView(puzzelView);
                puzzelView.requestFocus();

            }
            protected void showKeypadOrError(int x, int y){
                int tiles[] = getUsedTiles(x,y);
                if (tiles.length ==9){
                    Toast toast = Toast.makeText(this,R.string.no_moves_lable,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }
else{
    Log.d(TAG,"showKeypad: used=" +toPuzzelString(tiles));
                    Dialog v = new keypad(this, tiles, puzzelView);
                    v.show();

                }

            }
protected boolean setTileIfValid(int x, int y, int value){
                int tiles[] = getUsedTiles(x,y);
                if(value != 0) {
                    for (int tile: tiles){
                        if(tile ==value)
                            return false ;
                        }
                    }
                setTile(x,y,value);
                calculateUsedTiles();
                return  true;

}
private final int used[][][] = new int [9][9][];
  protected int[] getUsedTiles (int x, int y){
      return used[x][y];


  }

    private void calculateUsedTiles() {
        for (int x =0; x<9;x++){
            for (int y=0 ; y<9 ; y++){
                used[x][y] = calculateUsedTiles(x,y);


            }

        }
  }
private  int[] calculateUsedTiles (int x, int y){
      int c[] = new int [9];
      for (int i =0; i <9; i ++){
          if (i ==y)
              continue;
          int t = getTile(x,i);
          if (t != 0)
              c [t-1]= t;
      }
      for (int i =0; i<9; i++){
          if( i ==x)
              continue;
              int t = getTile(i,y);
              if (t !=0)
                  c [t-1] = t;
      }
      int startx = (x/3) *3;
      int starty = (y/3) *3;
      for  (int i  = startx; i < startx +3 ; i++){
          for ( int j = starty ; j <starty +3; j++){
              if (i ==x && j==y)
                  continue;
              int t = getTile(i, j);
              if (t!= 0)
                  c[t-1] = t;


          }
      }
      int nused = 0;
      for (int t:c){
          if(t!=0)
              nused ++;

      }
      int c1[] = new int [nused];
            nused = 0;
            for (int t:c){
                if (t!=0)
                    c1 [nused++] =t;
            }
            return c1;

}
private  int[] getPuzzle(int diff){
      String puz;
       switch (diff){
           case Difficulty_hard : puz = hardPuzzle;
           break;
           case Difficulty_medium: puz = medidumPuzzle;
           break;
           case Difficulty_easy: default: : puz = easyPuzzle;
           break;

       }
       return fromPuzzleString(puz);

}
static private  String toPuzzelString(int [] puz){

      StringBuilder buf = new StringBuilder();
      for (int element  : puz){
          buf.append(element);

      }
      return  buf.toString();
}

static protected  int[] fromPuzzleString(String string){
      int[] puz = new int [string.length()];
      for (int i  = 0 ; i < puz.length; i++){
          puz[i] = string.charAt(i)-'0';

      }
      return  puz;
}
private int getTile(int x, int y){
      return puzzle[y*9+x];
}
private void setTile(int x, int y , int value){
      puzzle [y*9 +x] = value;

}
protected  String getTileString(int x, int y){
      int v = getTile(x, y);
      if (v==0)
          return "";
      else
          return  String.valueOf(v);
}


}
