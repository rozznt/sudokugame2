package com.example.sudokugame;

public class Sudoku {

    Button = this.findViewById(R.id.continue_button);
    View newGameButton = this.findViewById(R.id.new_game_button);
    View aboutButton = this.findViewById(R.id.about_button);
    View exitButton = this.findViewById(R.id.exit_button);
		continueButton.setOnClickListener(this);
		newGameButton.setOnClickListener(this);
		aboutButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
}

    // method implement the OnClickListener interface
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_button:
                break;
            case R.id.new_game_button:
                openNewGameDialog();
                break;
            case R.id.about_button:
                Intent i_about = new Intent(this, About.class);
                startActivity(i_about); //Set activity for class About.java
                break;
            case R.id.exit_button:
                //finish();
                Intent i_exit = new Intent(Intent.ACTION_MAIN);
                i_exit.addCategory(Intent.CATEGORY_HOME);
                i_exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i_exit);
                break;
        }
    }

    /** Ask the user what difficulty level they want */
    private void openNewGameDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)

                //???
                .setItems(R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface, int i){
                                startGame(i);
                            }
                        }
                )
                //---?

                .show();
    }
    /** Start a new game with the given difficulty level */
    private void startGame(int i) {
        //???
        Log.d(TAG, "clicked on " + i);
        //---?
        Intent intent = new Intent(Sudoku.this, Game.class);// Call class Game.java
        intent.putExtra(Game.KEY_DIFFICULTY, i); // Set difficulty
        startActivity(intent);
    }

    // Create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); // Set menu.xml for this activity
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Settings.class)); // Call class Settings.java
                return true;

        }
