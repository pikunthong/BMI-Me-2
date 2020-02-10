package th.ac.su.bmime2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.round

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)





        var tvBMI = findViewById<TextView>(R.id.tvBMI)
        var tvDetail = findViewById<TextView>(R.id.tvDetail)
        var tvShoeHW = findViewById<TextView>(R.id.tvShowHW)
        var btnShear = findViewById<Button>(R.id.btnShear)
        var btnClose = findViewById<Button>(R.id.btnClose)

        var height = intent.getDoubleExtra("height",-1.0)
        var weight = intent.getDoubleExtra("weight",-1.0)

        var w = weight
        var h = height
        h = h/100

        var bmi:Double = w/(h*h)


        tvBMI.setText(bmi.round(2).toString())


        var result = "fat"

        if(bmi>30)
            result = "Obese"
        else if (bmi> 25)
            result = "Overweight"
        else if (bmi> 18)
            result = "Healthy"
        else
            result = "Underweight"





        tvDetail.setText(result)
        tvShoeHW.setText("( height: "+ h + "weight: " + w +")" )



        btnClose.setOnClickListener {


            finish()
        }



        btnShear.setOnClickListener {

            val value = "YOUR BMI \n"+bmi.round(2)+"\n"+result+"\n"+"( height: "+ h + "weight: " + w +")"

            var intent = Intent();
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,value)
            intent.type = "text/plan"

            startActivity(Intent.createChooser(intent,"share info"))
        }
    }




}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}
