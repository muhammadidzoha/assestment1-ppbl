package id.ac.id.telkomuniversity.tass.a1muhammadidzohannaqib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String server_url = "http://10.0.2.2/ppbl/4141.json";
    private Album album;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum();
            }
        });

        Gson gson = new Gson();
        String json = "{\"id\": 4141,\"artis\": \"Dewa 19\",\"judul\": \"Pandawa Lima\",\"tahun\": 1997,\"label\": \"Aquarius Musikindo\",\"harga\": 50000,\"cover\": \"http://10.0.2.2/ppbl/cover_4141.jpg\"}\n";
        album = gson.fromJson(json, Album.class);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(server_url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String myResponse = response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(album);
                        }
                    });
                }
            }
        });
    }
    private void openAlbum() {
        String artis;
        String judul;
        String urlCover;
        int tahun, harga;

        urlCover = album.getCover();
        artis = album.getArtis();
        judul = album.getJudul();
        tahun = album.getTahun();
        harga = album.getHarga();

        Fragment fragment = new AlbumDetailFragment();
        Bundle bundle = new Bundle();

        bundle.putString("url", urlCover);
        bundle.putString("artis", artis);
        bundle.putString("judul", judul);
        bundle.putString("tahun", Integer.toString(tahun));
        bundle.putString("harga", Integer.toString(harga));

        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.albumFl, fragment).commit();
        button.setVisibility(View.GONE);
    }
}