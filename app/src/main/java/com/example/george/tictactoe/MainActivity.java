package com.example.george.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int player_flag = 1; //Ksekinaei o prwtos paixths
    boolean[] isPressed = {false, false, false, false, false, false, false, false, false};  //an exei paththei (true)
    int[] button_owner = {0, 0, 0, 0, 0, 0, 0, 0, 0};   //krathsh tou paixth pou pataei to kathe tetragwno

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ImageButton button1 = (ImageButton) findViewById(R.id.but1);
        final ImageButton button2 = (ImageButton) findViewById(R.id.but2);
        final ImageButton button3 = (ImageButton) findViewById(R.id.but3);

        final ImageButton button4 = (ImageButton) findViewById(R.id.but4);
        final ImageButton button5 = (ImageButton) findViewById(R.id.but5);
        final ImageButton button6 = (ImageButton) findViewById(R.id.but6);

        final ImageButton button7 = (ImageButton) findViewById(R.id.but7);
        final ImageButton button8 = (ImageButton) findViewById(R.id.but8);
        final ImageButton button9 = (ImageButton) findViewById(R.id.but9);


        final TextView player_turn = (TextView) findViewById(R.id.textView);
        player_turn.setText("Player 1 Turn");

        //time to put some listeners to our imagebuttons :)
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(0) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {

                    isPressed[0] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[0] = 1;
                        button1.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[0] = 2;
                        button1.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(1) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[1] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[1] = 1;
                        button2.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[1] = 2;
                        button2.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(2) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[2] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[2] = 1;
                        button3.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[2] = 2;
                        button3.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(3) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[3] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[3] = 1;
                        button4.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[3] = 2;
                        button4.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(4) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[4] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[4] = 1;
                        button5.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[4] = 2;
                        button5.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(5) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[5] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[5] = 1;
                        button6.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[5] = 2;
                        button6.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(6) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[6] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[6] = 1;
                        button7.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[6] = 2;
                        button7.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(7) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[7] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[7] = 1;
                        button8.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[7] = 2;
                        button8.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (check_blank_square(8) == 1) //elegxos an yparxei kati se auto to tetragwno pou paththike
                {
                    isPressed[8] = true;
                    //eikona O sto imagebutton 1
                    if (player_flag == 1)
                    {
                        button_owner[8] = 1;
                        button9.setImageResource(R.mipmap.x);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player One\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 2; //Seira tou deuterou paixth
                        player_turn.setText("Player 2 Turn");
                    }
                    else if (player_flag == 2)
                    {
                        button_owner[8] = 2;
                        button9.setImageResource(R.mipmap.o);
                        if(check_winner()==true)
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("Winner is Player Two\nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        if((check_draw()==true)&&(check_winner()==false))
                        {
                            //create and show dialogue

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("TicTacToe");
                            builder.setCancelable(false);
                            builder.setMessage("No winner here...It's a TIE ! ;) \nStart new game?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent MainActivity = new Intent(getApplicationContext(), com.example.george.tictactoe.MainActivity.class);
                                            startActivity(MainActivity);
                                        }
                                    })
                                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Intent j=new Intent(Intent.ACTION_MAIN);
                                            j.addCategory(Intent.CATEGORY_HOME);
                                            j.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(j);
                                            finish();
                                            System.exit(0);
                                        }
                                    });
                            AlertDialog dialog=builder.create();
                            dialog.show();
                        }
                        player_flag = 1; //Seira tou deuterou paixth
                        player_turn.setText("Player 1 Turn");
                    }
                }
            }
        });
    }


    int check_blank_square(int i) {
        if (isPressed[i] == true)
            return 0;
        else
            return 1;
    }

    boolean check_winner()
    {
        //checks if winner = Player 1

        if ((button_owner[0] == 1) && (button_owner[1] == 1) && (button_owner[2] == 1))
        {
            return true;
        }
        if ((button_owner[0] == 1) && (button_owner[3] == 1) && (button_owner[6] == 1))
        {
            return true;
        }
        if ((button_owner[0] == 1) && (button_owner[4] == 1) && (button_owner[8] == 1))
        {
            return true;
        }
        if ((button_owner[1] == 1) && (button_owner[4] == 1) && (button_owner[7] == 1))
        {
            return true;
        }
        if ((button_owner[2] == 1) && (button_owner[5] == 1) && (button_owner[8] == 1))
        {
            return true;
        }
        if ((button_owner[3] == 1) && (button_owner[4] == 1) && (button_owner[5] == 1))
        {
            return true;
        }
        if ((button_owner[6] == 1) && (button_owner[7] == 1) && (button_owner[8] == 1))
        {
            return true;
        }
        if((button_owner[2]==1)&&(button_owner[4]==1)&&(button_owner[6]==1))
        {
            return true;
        }


        //checks if winner = Player 2

        if ((button_owner[0] == 2) && (button_owner[1] == 2) && (button_owner[2] == 2))
        {
            return true;
        }
        if ((button_owner[0] == 2) && (button_owner[3] == 2) && (button_owner[6] == 2))
        {
            return true;
        }
        if ((button_owner[0] == 2) && (button_owner[4] == 2) && (button_owner[8] == 2))
        {
            return true;
        }
        if ((button_owner[1]==2)&&(button_owner[4]==2)&&(button_owner[7]==2))
        {
            return true;
        }
        if((button_owner[2]==2)&&(button_owner[5]==2)&&(button_owner[8]==2))
        {
            return true;
        }
        if((button_owner[3]==2)&&(button_owner[4]==2)&&(button_owner[5]==2))
        {
            return true;
        }
        if((button_owner[6]==2)&&(button_owner[7]==2)&&(button_owner[8]==2))
        {
            return true;
        }
        if((button_owner[2]==2)&&(button_owner[4]==2)&&(button_owner[6]==2))
        {
            return true;
        }
        return false;
    }


    boolean check_draw()
    {
       if((isPressed[0]==true)&&(isPressed[1]==true)&&(isPressed[2]==true)&&(isPressed[3]==true)&&(isPressed[4]==true)&&(isPressed[5]==true)&&(isPressed[6]==true)&&(isPressed[7]==true)&&(isPressed[8]==true))
       {
           return true;
       }
       else
       {
           return false;
       }
    }
}