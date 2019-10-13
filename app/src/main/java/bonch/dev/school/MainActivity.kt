package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import bonch.dev.school.models.Counter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tapButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var counterTextView: TextView
    private lateinit var counter: Counter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()

        counter = if(savedInstanceState == null) {
            Counter()
        }else{
            val key = "TAP_AMOUNT"
            Counter(savedInstanceState.getInt(key))
        }

        counterTextView.text = "Button was tapped ${counter.currentCount} times"

        setListeners()
    }


    private fun initializeViews(){
        tapButton = findViewById(R.id.tap_button)
        counterTextView = counter_text_view
        nextActivityButton = next_activity_button
    }




    private fun setListeners(){
        tapButton.setOnClickListener{
            counter.increment()
            counterTextView.text = "Button was tapped ${counter.currentCount} times"
        }
        nextActivityButton.setOnClickListener{
            val intent = Intent(MainActivity@this, SecondActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNTS", counter.currentCount)
    }



}
