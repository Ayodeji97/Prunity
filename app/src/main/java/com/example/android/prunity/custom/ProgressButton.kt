package com.example.android.prunity.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import com.example.android.prunity.R

class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var progressBar : LottieAnimationView
    private lateinit var buttonTextView : TextView

    init {
        // inflate layout
        val root = LayoutInflater.from(context).inflate(R.layout.custom_button_layout, this, true)
        // reference view
        buttonTextView = root.findViewById(R.id.custom_button_layout_text_button)
        progressBar = root.findViewById(R.id.custom_button_layout_progress_indicator)

        loadAttr(attrs, defStyleAttr)
    }

    private fun loadAttr (attrs: AttributeSet?, defStyleAttr: Int) {

        val arr = context.obtainStyledAttributes(
            attrs,
            R.styleable.ProgressButton,
            defStyleAttr,
            0
        )

        // TODO: Please go through this to affirm it is working
        val buttonText = arr.getString(R.styleable.ProgressButton_text)
        val loading = arr.getBoolean(R.styleable.ProgressButton_loading, false)
        val enabled = arr.getBoolean(R.styleable.ProgressButton_enabled, true)
        val lottieResId = arr.getResourceId(R.styleable.ProgressButton_lottie_resId, R.raw.circular_loading)

        arr.recycle()

        isEnabled = enabled
        buttonTextView.isEnabled = enabled
        setText(buttonText)

        progressBar.setAnimation(lottieResId)

        setLoading(loading)

    }


    private fun setText(text : String?) {
        buttonTextView.text = text
    }

    private fun setLoading(loading: Boolean){
        isClickable = !loading //Disable clickable when loading
        if(loading){
            buttonTextView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        } else {
            buttonTextView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        buttonTextView.isEnabled = enabled
    }
}