package nyp.sit.t2107.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_review.*

class movie_review : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_review)
        val bundle: Bundle? = intent.extras
        val movieTitle = bundle!!.getString("movieNameReview")
        reviewMovieName.text = "Enter Your review for movie: " + movieTitle


    }
}
