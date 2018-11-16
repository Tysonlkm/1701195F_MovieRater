package nyp.sit.t2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.concurrent.schedule
import java.util.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chkboxMovieRating.setOnClickListener{
            if(chkboxMovieRating.isChecked){
                chkboxMovieVl.visibility = View.VISIBLE
                chkboxMovielangUsed.visibility = View.VISIBLE
            }
            else {
                chkboxMovieVl.visibility = View.GONE
                chkboxMovielangUsed.visibility = View.GONE
            }
        }

        btnText.setOnClickListener{
            val validateMovieName = inputMovieName.text
            val validateMovieDesc = inputMovieDesc.text
            val validateReleaseDate = inputReleaseDate.text
            if (validateMovieName.isNullOrEmpty()) {

                inputMovieName.error = "Field Empty"

            }
            if(validateMovieDesc.isNullOrEmpty()) {
                inputMovieDesc.error = "Field Empty"
            }
            if (validateReleaseDate.isNullOrEmpty()) {
                inputReleaseDate.error = "Field Empty"
            }
            displayMovie()

        }
    }
    private fun displayMovie(){
        var movieLang = ""
        if (english_radiobtn.isChecked){
            movieLang = english_radiobtn.text.toString()
        }
        else if(chinese_radiobtn.isChecked){
            movieLang = chinese_radiobtn.text.toString()
        }

        else if(malay_radiobtn.isChecked){
            movieLang = malay_radiobtn.text.toString()
        }
        else if (tamil_radiobtn.isChecked) {
            movieLang = tamil_radiobtn.text.toString()
        }
        else{
            movieLang = ""
        }
        var movieRating=""
        if(chkboxMovieRating.isChecked){
            movieRating = "true"
        }
        else {
            movieRating = ""
        }

        var vl =" "
        if(chkboxMovieVl.isChecked){
            vl = chkboxMovieVl.text.toString()
        }
        else{
            vl = ""
        }

        var langUsed = ""
        if(chkboxMovielangUsed.isChecked){
            langUsed = "Language"
        }
        else {
            langUsed = ""
        }
        val title = "Title =" + inputMovieName.text
        val Desc = "Overview =" + inputMovieDesc.text
        val Date = "Release Date =" + inputReleaseDate.text
        val Lang = "Language = " + movieLang
        val Rating = "Suitable for all ages = " + movieRating
        val toastMovie = Toast.makeText(this, title + "\n" + Desc + "\n" + Date + "\n" + Lang + "\n" + Rating + "\n" + "Reason: " + "\n" + vl + "\n" + langUsed, Toast.LENGTH_LONG)
        toastMovie.show()

        val nextActivity = Timer()
        nextActivity.schedule(5000){
            val movieRecommend = "Yes"
            val movieTitle = inputMovieName.text.toString()
            val movieDesc= inputMovieDesc.text.toString()
            val movieReleaseDate = inputReleaseDate.text.toString()
            val movieIntent = Intent(applicationContext, DisplayMovie::class.java)
            movieIntent.putExtra("movieTitle", movieTitle)
            movieIntent.putExtra("movieDesc", movieDesc)
            movieIntent.putExtra("movieReleaseDate",movieReleaseDate)
            movieIntent.putExtra("movieLang", movieLang)
            movieIntent.putExtra("movieRecommend",movieRecommend)
            startActivity(movieIntent)
        }

    }

}
