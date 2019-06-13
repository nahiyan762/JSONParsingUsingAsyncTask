package com.example.hp.jsonparsingusingasynctask;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        MyTask task = new MyTask();
        task.execute(this);
    }

    static class MyTask extends AsyncTask<Object, Object, MainActivity> {

        private BufferedReader reader;

        @Override
        protected void onPreExecute() {
        }


        @Override
        protected MainActivity doInBackground(Object... objects) {
            try {
                URL url = new URL("https://api.myjson.com/bins/1fi1zm");

                URLConnection connection = url.openConnection();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(MainActivity activity) {
            WeakReference<MainActivity> contextRef = new WeakReference<>(activity);
            MainActivity context = contextRef.get();

            if (context != null) {
                Gson gson = new Gson();
                List<Contact> list;
                try {
                    list = Arrays.asList(gson.fromJson(reader.readLine(), Contact[].class));
                    context.adapter = new RecyclerViewAdapter(list);
                    context.recyclerView.setAdapter(context.adapter);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
