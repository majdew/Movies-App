package edu.ppu.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Mohammed on 22/11/2016.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies){
        super(context,0,movies);
        this.movies = movies;

    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Movie movie = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movieitem,parent,false);
        }

        TextView textTitle = (TextView) convertView.findViewById(R.id.title);
        TextView textRating = (TextView) convertView.findViewById(R.id.rating);
        TextView textReleaseYear = (TextView) convertView.findViewById(R.id.releaseYear);
        TextView textGenre = (TextView) convertView.findViewById(R.id.genre);
        ImageView imageThumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);

        textTitle.setText(movie.getTitle());
        textRating.setText(movie.getRating());
        textReleaseYear.setText(movie.getReleasedate());
        String genre = "";
        for(String s: movie.getGenre()){
            genre += s + ", ";
        }
        textGenre.setText(genre);

        String imageURL = movie.getImage();

        Picasso.with(this.getContext())
                .load(imageURL)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(imageThumbnail);


        return convertView;

    }
}
