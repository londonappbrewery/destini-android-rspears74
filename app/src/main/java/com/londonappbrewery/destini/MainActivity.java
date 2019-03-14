package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonBottom;
    private Button mButtonTop;
    private int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mButtonTop = findViewById(R.id.buttonTop);
        mStoryIndex = 1;

        if (savedInstanceState != null) {
            mStoryTextView.setText(savedInstanceState.getCharSequence("StoryText"));
            mButtonTop.setText(savedInstanceState.getCharSequence("TopButtonText"));
            mButtonBottom.setText(savedInstanceState.getCharSequence("BottomButtonText"));
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    mStoryTextView.setText(R.string.T6_End);
                    mButtonTop.setText(R.string.close_app);
                    mButtonBottom.setText(R.string.restart);
                    mStoryIndex = 6;
                } else {
                    finish();
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryTextView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    mStoryTextView.setText(R.string.T4_End);
                    mButtonTop.setText(R.string.close_app);
                    mButtonBottom.setText(R.string.restart);
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                    mStoryTextView.setText(R.string.T5_End);
                    mButtonTop.setText(R.string.close_app);
                    mButtonBottom.setText(R.string.restart);
                    mStoryIndex = 5;
                } else {
                    reset();
                }

            }
        });

    }

    private void reset() {
        mStoryTextView.setText(R.string.T1_Story);
        mButtonTop.setText(R.string.T1_Ans1);
        mButtonBottom.setText(R.string.T1_Ans2);
        mStoryIndex = 1;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putCharSequence("StoryText", mStoryTextView.getText());
        outState.putCharSequence("TopButtonText", mButtonTop.getText());
        outState.putCharSequence("BottomButtonText", mButtonBottom.getText());
        outState.putInt("StoryIndex", mStoryIndex);
    }
}
