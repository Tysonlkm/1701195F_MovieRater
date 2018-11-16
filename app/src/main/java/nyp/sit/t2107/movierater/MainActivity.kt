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
                chkboxMovieVl.isEnabled = true
                chkboxMovielangUsed.visibility = View.VISIBLE
                chkboxMovielangUsed.isEnabled = true
            }
            else {
                chkboxMovieVl.visibility = View.GONE
                chkboxMovieVl.isEnabled=false
                chkboxMovieVl.isChecked = false
                chkboxMovielangUsed.visibility = View.GONE
                chkboxMovielangUsed.isEnabled = false
                chkboxMovielangUsed.isChecked = false
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
            movieLang = english_radiobtn.text.toString()
        }
        var movieRating=""
        if(chkboxMovieRating.isChecked){
            movieRating = "false"
        }
        else{
            movieRating="true"
        }

        var vl =" "
        if(chkboxMovieVl.isChecked){
            vl = chkboxMovieVl.text.toString()
        }
        else{
            vl = "NA"
        }

        var langUsed = ""
        if(chkboxMovielangUsed.isChecked){
            langUsed = "Foul Language"
        }
        else {
            langUsed = "NA"
        }

        val title = "Title =" + inputMovieName.text
        val Desc = "Overview =" + inputMovieDesc.text
        val Date = "Release Date =" + inputReleaseDate.text
        val Lang = "Language = " + movieLang
        val Rating = "Suitable for all ages = " + movieRating
        val reasons = "Reason: " + "\n" + vl + "\n" + langUsed
        val toastMovie = Toast.makeText(this, title + "\n" + Desc + "\n" + Date + "\n" + Lang + "\n" + Rating + "\n" + reasons , Toast.LENGTH_LONG)
        if(inputMovieName.text.isNotEmpty()&& inputMovieDesc.text.isNotEmpty()&&inputReleaseDate.text.isNotEmpty()&& movieRating=="true"
            || movieRating=="false"){
            toastMovie.show()
            val nextActivityShow = Timer()
            nextActivityShow.schedule(3500){
                var movieRecommend =""
                if (movieRating=="true"){
                    movieRecommend = "Yes"
                }
                else{
                    movieRecommend="No"
                }
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

}














