package com.csis290.learnfragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView tvGreen;
    private TextView tvBlue;
    private TextView tvRed;

   // Runnable runnable = new Runnable();
    //Messed up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tvGreen = (TextView) findViewById(R.id.tv_green);
        tvBlue = (TextView) findViewById(R.id.tv_blue);
        tvRed = (TextView) findViewById(R.id.tv_red);

        tvGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Bundle bundle = new Bundle();
                bundle.putString("key", "Welcome to the Activity");

                GreenFragment greenFragment = new GreenFragment();
                greenFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, greenFragment)
                        .addToBackStack("")
                        .commit();
                        */
            }
        });

        tvBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new BlueTransactionTask(new Handler()).execute();


                /*
                Bundle bundle = new Bundle();
                bundle.putString("key2", "Welcome to the Activity, Blue");

                BlueFragment blueFragment = new BlueFragment();
                blueFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, blueFragment)
                        .addToBackStack("")
                        .commit();
                        */

            }
        });

        tvRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new RedFragment())
                        .addToBackStack("")
                        .commit();
            }
        });
    }

    // AsyncTask<Params, Progress, Result>
    // Params
    class BlueTransactionTask extends AsyncTask<Void, Void, Void>{

        private Handler handler;

        public BlueTransactionTask(Handler handler){
            this.handler = handler;
        }

        Runnable blueRunnable = new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("key2", "Welcome to the Activity, Blue");

                BlueFragment blueFragment = new BlueFragment();
                blueFragment.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, blueFragment)
                        .setTransition(fragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack("")
                        .commit();
            } //End run
        }; //End Runnable
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("tag", "onPreExecute()");
        } //End onPreExecute

        @Override
        protected Void doInBackground(Void... params) {

            handler.postDelayed(blueRunnable, 10000);
            Log.d("tag", "Finished postDelayed().");
            return null;
        } //End doInBackground

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("tag", "onPostExecute");
        } //End onPostExecute
    }

    class redTransactionTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }//End class

}
