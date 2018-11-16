package nyp.sit.t2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_movie.*

class DisplayMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_movie)
        val bundle: Bundle? = intent.extras
        val movieTitle = bundle!!.getString("movieTitle")
        val movieDesc = bundle!!.getString("movieDesc")
        val movieDate = bundle!!.getString("movieReleaseDate")
        val movieLan = bundle!!.getString("movieLang")
        val movieRecommend = bundle!!.getString("movieRecommend")

        DisplayMovieName.text = movieTitle + "\n"
        DisplayMovieDesc.text = movieDesc + "\n"
        DisplayMovieLang.text = movieLan +"\n"
        DisplayMovieRelease.text = movieDate +"\n"
        DisplaySuitableAge.text = movieRecommend +"\n"



        btnRateMovie.setOnClickListener(){
            val movieRating = Intent(applicationContext,movie_review::class.java)
            movieRating.putExtra("movieNameReview", movieTitle)
            startActivity(movieRating)
        }
    }
}
