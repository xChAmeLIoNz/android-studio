package com.iseppe.app_04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.video);

        // Imposta l'URI del video da riprodurre in loop
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(videoUri);

        // Crea un oggetto MediaController per gestire la riproduzione del video
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Imposta il video in modalità loop
        videoView.setOnCompletionListener(mediaPlayer -> {
            videoView.seekTo(0);
            videoView.start();
        });

        // Avvia la riproduzione del video
        videoView.start();
    }

    //metodo per agganciare  il menu all'activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //metodo per la gestione del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.vai) {

            Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
