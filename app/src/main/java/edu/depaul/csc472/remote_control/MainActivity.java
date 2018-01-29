package edu.depaul.csc472.remote_control;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {

    static private final String TAG = "MainActivity";
    String channelNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isSwitchedOff = true;
        EnableDisableControl(isSwitchedOff);

        final TextView tv_tvpower = findViewById(R.id.tv_power);
        final TextView tv_speakervolumn = findViewById(R.id.speaker_volumn);
        final TextView tv_currentChannel = findViewById(R.id.current_channel);
        final SeekBar seekbar_volumn = findViewById(R.id.seekbar2);

        final Button b_zero = findViewById(R.id.zero);
        final Button b_one = findViewById(R.id.one);
        final Button b_two = findViewById(R.id.two);
        final Button b_three = findViewById(R.id.three);
        final Button b_four = findViewById(R.id.four);
        final Button b_five = findViewById(R.id.five);
        final Button b_six = findViewById(R.id.six);
        final Button b_seven = findViewById(R.id.seven);
        final Button b_eight = findViewById(R.id.eight);
        final Button b_nine = findViewById(R.id.nine);
        final Button b_channel_inc = findViewById(R.id.channel_inc);
        final Button b_channel_dec = findViewById(R.id.channel_dec);
        final Button b_abc = findViewById(R.id.abc);
        final Button b_nbc = findViewById(R.id.nbc);
        final Button b_cbs = findViewById(R.id.cbs);


        b_zero.setEnabled(false);
        b_one.setEnabled(false);
        b_two.setEnabled(false);
        b_three.setEnabled(false);
        b_four.setEnabled(false);
        b_five.setEnabled(false);
        b_six.setEnabled(false);
        b_seven.setEnabled(false);
        b_eight.setEnabled(false);
        b_nine.setEnabled(false);
        b_channel_inc.setEnabled(false);
        b_channel_dec.setEnabled(false);
        b_abc.setEnabled(false);
        b_nbc.setEnabled(false);
        b_cbs.setEnabled(false);
        seekbar_volumn.setEnabled(false);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                int val = Integer.parseInt(btn.getText().toString());
                TextView tv_currentChannel = findViewById(R.id.current_channel);
                int num = Integer.parseInt(tv_currentChannel.getText().toString());

                if (channelNumber.length() == 2) {
                    channelNumber += val;
                    tv_currentChannel.setText(channelNumber);
                }
                else {
                    channelNumber += val;

                }
                if (channelNumber.length() == 3) {
                    channelNumber = "";
                }

            }
        };


            b_zero.setOnClickListener(listener);
            b_one.setOnClickListener(listener);
            b_two.setOnClickListener(listener);
            b_three.setOnClickListener(listener);
            b_four.setOnClickListener(listener);
            b_five.setOnClickListener(listener);
            b_six.setOnClickListener(listener);
            b_seven.setOnClickListener(listener);
            b_eight.setOnClickListener(listener);
            b_nine.setOnClickListener(listener);


        //CH+ button
        b_channel_inc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    int num = Integer.parseInt(tv_currentChannel.getText().toString());
                    num = num == 999 ? 0 : num + 1;
                    tv_currentChannel.setText(String.format("%d", num));
            }

        });

        //CH- button
        b_channel_dec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    int num = Integer.parseInt(tv_currentChannel.getText().toString());
                    num = num == 0 ? 999 : num - 1;
                    tv_currentChannel.setText(String.format("%d", num));
            }

        });

        //Favorite Channels
        b_abc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_currentChannel.setText("821");
            }
        });

        b_nbc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_currentChannel.setText("498");
            }
        });

        b_cbs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv_currentChannel.setText("021");
            }
        });


        //Speaker Volumn Seekbar
        seekbar_volumn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.d(TAG, "onProgressChanged");
                tv_speakervolumn.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch");
            }
        });
    }

        //Power Switch
        public void onSwitchClicked(View view) {
            TextView tv_tvpower = findViewById(R.id.tv_power);
            TextView tv_currentChannel = findViewById(R.id.current_channel);
            TextView tv_speakervolumn = findViewById(R.id.speaker_volumn);
            Switch sw = (Switch) view;
            Log.d(TAG, "onSwitchClicked() " + sw.getTag() + " " + (sw.isChecked() ? "on" : "off"));
            tv_tvpower.setText((sw.isChecked() ? "ON" : "OFF"));
                if(sw.isChecked())
                {
                    EnableDisableControl(true);
                    tv_currentChannel.setText("187");
                    tv_speakervolumn.setText("50");

                }
                else
                {
                    EnableDisableControl(false);
                    tv_currentChannel.setText("");
                    tv_speakervolumn.setText("");
                }
        }


    //Method to handle enabling/disabling all controls on the remote.
        public void EnableDisableControl(boolean flag){
            SeekBar seekbar_volumn = findViewById(R.id.seekbar2);

            Button b_zero = findViewById(R.id.zero);
            Button b_one = findViewById(R.id.one);
            Button b_two = findViewById(R.id.two);
            Button b_three = findViewById(R.id.three);
            Button b_four = findViewById(R.id.four);
            Button b_five = findViewById(R.id.five);
            Button b_six = findViewById(R.id.six);
            Button b_seven = findViewById(R.id.seven);
            Button b_eight = findViewById(R.id.eight);
            Button b_nine = findViewById(R.id.nine);
            Button b_channel_inc = findViewById(R.id.channel_inc);
            Button b_channel_dec = findViewById(R.id.channel_dec);
            Button b_abc = findViewById(R.id.abc);
            Button b_nbc = findViewById(R.id.nbc);
            Button b_cbs = findViewById(R.id.cbs);


            b_zero.setEnabled(flag);
            b_one.setEnabled(flag);
            b_two.setEnabled(flag);
            b_three.setEnabled(flag);
            b_four.setEnabled(flag);
            b_five.setEnabled(flag);
            b_six.setEnabled(flag);
            b_seven.setEnabled(flag);
            b_eight.setEnabled(flag);
            b_nine.setEnabled(flag);
            b_channel_inc.setEnabled(flag);
            b_channel_dec.setEnabled(flag);
            b_abc.setEnabled(flag);
            b_nbc.setEnabled(flag);
            b_cbs.setEnabled(flag);
            seekbar_volumn.setEnabled(flag);

        }

    }












