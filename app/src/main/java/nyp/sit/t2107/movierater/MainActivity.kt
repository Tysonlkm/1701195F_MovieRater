package nyp.sit.t2107.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            if (validateMovieName.isNullOrEmpty()) {
                inputMovieName.error = "Field Empty"
            }

            val validateMovieDesc = inputMovieDesc.text
            if (validateMovieDesc.isNullOrEmpty()) {
                inputMovieDesc.error = "Field Empty"
            }

            val validateReleaseDate = inputReleaseDate.text
            if (validateReleaseDate.isNullOrEmpty()) {
                inputReleaseDate.error = "Field Empty"
            }

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
            else {
                movieLang = tamil_radiobtn.text.toString()
            }
            var movieRating=""
            if(chkboxMovieRating.isChecked){
                movieRating = "true"
            }
            else {
               movieRating = "false"
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

            val movieIntent = Intent(applicationContext, DisplayMovie::class.java)
            val movieTitle = inputMovieName.text.toString()
            val movieDesc= inputMovieDesc.text.toString()

            val movieRecommend = "Yes"

            movieIntent.putExtra("movieTitle", movieTitle)
            movieIntent.putExtra("movieDesc", movieDesc)
            movieIntent.putExtra("moveDate",inputReleaseDate.text.toString())
            movieIntent.putExtra("movieLang", movieLang)
            movieIntent.putExtra("movieRecommend",movieRecommend)
            startActivity(movieIntent)
        }
    }
}
