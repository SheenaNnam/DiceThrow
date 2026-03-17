package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollDiceButton)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment.newInstance(20))
                .commit()
        }


        rollButton.setOnClickListener {
            supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView)?.run{
                    (this as DieFragment).throwDie() //casting as DieFragment bc current context is just a general fragment
                }
            //dieFragment.throwDie()
        }
    }
}