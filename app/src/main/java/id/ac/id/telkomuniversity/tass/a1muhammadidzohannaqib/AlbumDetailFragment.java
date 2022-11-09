package id.ac.id.telkomuniversity.tass.a1muhammadidzohannaqib;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;

public class AlbumDetailFragment extends Fragment {

    ImageView cover;
    TextView artis, judul, tahun, harga, url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album_detail, container, false);

        cover = view.findViewById(R.id.coverIv);
        artis = view.findViewById(R.id.artisTv);
        judul = view.findViewById(R.id.albumTv);
        tahun = view.findViewById(R.id.tahunTv);
        harga = view.findViewById(R.id.hargaTv);

        Bundle bundle = this.getArguments();
        Glide.with(this)
                .load(bundle.getString("url"))
                .into(cover);
        artis.setText(bundle.getString("artis"));
        judul.setText(bundle.getString("judul"));
        tahun.setText(bundle.getString("tahun"));
        harga.setText(bundle.getString("harga"));
        return view;
    }
}