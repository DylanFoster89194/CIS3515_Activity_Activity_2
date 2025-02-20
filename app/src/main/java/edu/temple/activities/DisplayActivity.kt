package edu.temple.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    companion object {
        const val TEXT_SIZE_REQUEST_CODE = 1
        const val EXTRA_TEXT_SIZE = "extra_text_size"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {
            // TODO Step 1: Launch TextSizeActivity when button clicked
            val intent = Intent(this, TextSizeActivity::class.java)
            startActivityForResult(intent, TEXT_SIZE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_SIZE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.let {
                val selectedTextSize = it.getFloatExtra(EXTRA_TEXT_SIZE, 16f)
                // TODO Step 3: Use returned value for lyricsDisplayTextView text size
                lyricsDisplayTextView.textSize = selectedTextSize
            }
        }
    }
}
