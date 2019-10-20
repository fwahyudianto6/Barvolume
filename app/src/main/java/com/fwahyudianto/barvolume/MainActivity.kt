package com.fwahyudianto.barvolume

/**
 *  This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 *  http://www.fwahyudianto.id
 *  ® Wahyudianto, Fajar
 *  Email 	: fwahyudi06@gmail.com
 */

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //  Declaration Variable
    private lateinit var etLength: EditText
    private lateinit var etWidth: EditText
    private lateinit var etHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    //  Method onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set Variable
        etLength = findViewById(R.id.et_length)
        etWidth = findViewById(R.id.et_width)
        etHeight = findViewById(R.id.et_height)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val strResultState = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = strResultState
        }
    }

    //  Method onSaveInstanceState
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    // Implement Interface
    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {
            val valWidth = etWidth.text.toString().trim()
            val valHeight = etHeight.text.toString().trim()
            val valLength = etLength.text.toString().trim()
            var vrEmpty = false

            if (valLength.isNullOrEmpty()) {
                vrEmpty = true
                etLength.error = "Length Is Required!"
            }
            if (valWidth.isNullOrEmpty()) {
                vrEmpty = true
                etWidth.error = "Width Is Required!"
            }
            if (valHeight.isNullOrEmpty()) {
                vrEmpty = true
                etHeight.error = "Height Is Required!"
            }

            if (!vrEmpty) {
                val valVolume = valWidth.toDouble() * valHeight.toDouble() * valLength.toDouble()
                tvResult.text = valVolume.toString()
            }
        }
    }
}
