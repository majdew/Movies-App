package edu.ppu.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Movie> movieArrayList;
    ListView listView;
    public static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        url = "http://api.androidhive.info/json/movies.json";

        movieArrayList = new ArrayList<Movie>();

        final MovieAdapter movieAdapter = new MovieAdapter(this,movieArrayList);
        listView.setAdapter(movieAdapter);

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Movie movie = new Movie();
                            String title = jsonObject.getString("title");
                            String image = jsonObject.getString("image");
                            String rating = jsonObject.getString("rating");
                            String releaseyear = jsonObject.getString("releaseYear");
                            movie.setTitle(title);
                            movie.setImage(image);
                            movie.setRating(rating);
                            movie.setReleasedate(releaseyear);

                            JSONArray jsonArray = jsonObject.getJSONArray("genre");
                            ArrayList<String> genre = new ArrayList<String>();
                            for(int j=0;j<jsonArray.length();j++){
                                genre.add(jsonArray.getString(j));
                            }
                            movie.setGenre(genre);
                            movieArrayList.add(movie);
                        }
                        movieAdapter.notifyDataSetChanged();

                    }
                    catch (JSONException ex){
                        ex.printStackTrace();
                    }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),"Connection Error",Toast.LENGTH_LONG).show();
                    }
                });

        queue.add(jsonArrayRequest);

    }
}
