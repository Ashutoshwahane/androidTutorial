package com.example.backgroundtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class BG extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("Backgroud task", "onPreExecute: run ");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("Backgroud task", "onPreExecute: run ");
            Log.d("Backgroud task", s);

        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d("Backgroud task", "onPreExecute: run ");
            String result = "";
            URL url;
            String[] urls = new String[0];
            HttpURLConnection conn;
            try {
                url = new URL("https://ashutoshwahane.github.io/");
                conn = (HttpURLConnection) url.openConnection();
                InputStream in = conn.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
            }
            catch(Exception e){
                e.printStackTrace();
                return "Something went wrong";
            }
            return result;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BG bg = new BG();
        bg.execute("https://ashutoshwahane.github.io/");

    }

    public void task(View view) {

        Toast.makeText(this, "task shuru", Toast.LENGTH_SHORT).show();
    }
}
