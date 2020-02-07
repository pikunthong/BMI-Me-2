package th.ac.su.bmime2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.round

class MainActivity : AppCompatActivity() {


    var CHANGE_REQOUEST_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn_cal = findViewById<Button>(R.id.btnCal)
        var tvShow = findViewById<TextView>(R.id.showDetail)
        var edtW = findViewById<EditText>(R.id.edtW)
        var edtH = findViewById<EditText>(R.id.edtH)

        btn_cal.setOnClickListener {







            var intent = Intent (this@MainActivity,SecondActivity::class.java)


            intent.putExtra("height",edtH.text.toString().toDouble())
            intent.putExtra("weight",edtW.text.toString().toDouble())
            startActivityForResult(intent,CHANGE_REQOUEST_CODE )
            hideKeyboard()

        }
    }

//    private fun hideKeyboard() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }



    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
