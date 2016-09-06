package com.leonguevara.fadeingimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // this method shows how to fade in and fade out
    public void fade(View view) {
        ImageView freddie = (ImageView) findViewById(R.id.freddie);
        ImageView beatles = (ImageView) findViewById(R.id.theBeatles);
        Button firstButton = (Button) findViewById(R.id.firstButton);
        Button secondButton = (Button) findViewById(R.id.secondButton);

        // Change alpha property of Freddie and The Beatles, so Freddie disappears (alpha = 0)
        // and The Beatles appear (alpha = 1).  Each transformation (animation) lasts 2 seconds.
        freddie.animate().alpha(0f).setDuration(2000);
        beatles.animate().alpha(1f).setDuration(2000);

        // We hide and disable the first button so it won't trouble us further
        firstButton.setEnabled(false);
        firstButton.setVisibility(View.INVISIBLE);

        // We show and enable the second button so we can go to the second animation
        secondButton.setEnabled(true);
        secondButton.setVisibility(View.VISIBLE);
    }

    // this method shows how to move an image programmatically; called by fade function
    public void moveFlanders(View view) {
        ImageView flanders = (ImageView) findViewById(R.id.flanders);
        ImageView beatles = (ImageView) findViewById(R.id.theBeatles);
        Button secondButton = (Button) findViewById(R.id.secondButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);

        // Swipe The Beatles to the right and show Flanders falling from the top of the screen
        beatles.animate().translationXBy(1000f).setDuration(2000);
        flanders.setVisibility(View.VISIBLE);
        flanders.animate().translationYBy(3000f).setDuration(2000);

        // We hide and disable the second button so it won't trouble us further
        secondButton.setEnabled(false);
        secondButton.setVisibility(View.INVISIBLE);

        // We show and enable the reset button so we can restart out animations
        resetButton.setEnabled(true);
        resetButton.setVisibility(View.VISIBLE);
    }

    public void resetImages(View view) {
        Button firstButton = (Button) findViewById(R.id.firstButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        ImageView freddie = (ImageView) findViewById(R.id.freddie);
        ImageView beatles = (ImageView) findViewById(R.id.theBeatles);
        ImageView flanders = (ImageView) findViewById(R.id.flanders);

        flanders.setVisibility(View.INVISIBLE);
        flanders.setTranslationY(-3000);
        beatles.setAlpha(0f);
        beatles.animate().translationX(0f).setDuration(0);
        freddie.setAlpha(1f);

        // We hide and disable the reset button so it won't troubles us further
        resetButton.setEnabled(false);
        resetButton.setVisibility(View.INVISIBLE);

        // We show and enable the first button so we can run our animations again
        firstButton.setEnabled(true);
        firstButton.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide flanders before it all starts!
        ImageView flanders = (ImageView) findViewById(R.id.flanders);
        flanders.setTranslationY(-3000);
    }
}
