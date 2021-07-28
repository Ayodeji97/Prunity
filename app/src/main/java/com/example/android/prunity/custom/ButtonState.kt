package com.example.android.prunity.custom

import com.example.android.prunity.R

// Button State
sealed class ButtonState (var buttonState : Int){
    object Clicked : ButtonState(R.string.prune_url_state_str)
    object Loading : ButtonState(R.string.pruning_state_str)
    object Completed : ButtonState(R.string.pruned_url_str)
}