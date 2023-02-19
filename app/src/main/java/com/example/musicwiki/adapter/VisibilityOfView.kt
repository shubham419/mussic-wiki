package com.example.musicwiki.adapter

import android.opengl.Visibility
import android.view.View
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView


@BindingAdapter(value = ["state", "token"], requireAll = false)
fun visibilityOfView(container: FragmentContainerView, state: Boolean, token: Boolean) {
    when {
        state && token -> container.visibility = View.VISIBLE
        !state && token -> container.visibility = View.INVISIBLE
        state && !token ->  {
            val layout = container.layoutParams
            layout.height = 800
            container.layoutParams = layout
        }
        !state && !token -> {
            val layout = container.layoutParams
            layout.height = -1
            container.layoutParams = layout
        }
    }
}


@BindingAdapter(value = ["state"], requireAll = false)
fun visibilityOfBottomMenu(menu: BottomNavigationView, state: Boolean) {
    if (!state) menu.visibility = View.GONE else menu.visibility = View.VISIBLE
}

