package fr.formation.threads_web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText etUrl;
    WebView wvPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUrl = findViewById(R.id.etUrl);
        wvPage = findViewById(R.id.wvPage);
    }

    public void getUrl(View view) {
      HttpClient client = new HttpClient();
      client.setAdr(etUrl.getText().toString());
      client.start();
        try {
            client.join();
            String reponse = client.getResponse();
            wvPage.loadData(reponse,"text/html","UTF-8");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }



    }


