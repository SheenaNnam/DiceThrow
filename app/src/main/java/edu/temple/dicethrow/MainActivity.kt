package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollDiceButton)
        val dieViewModel = ViewModelProvider(this)[DieViewModel::class.java]

        dieViewModel.setSides(20)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView, DieFragment())
                .commit()
        }


        rollButton.setOnClickListener {
            dieViewModel.rollDie()

            //or dieFragment.throwDie()


        }
    }
}