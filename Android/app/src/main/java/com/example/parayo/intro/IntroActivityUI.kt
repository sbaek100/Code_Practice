package com.example.parayo.intro

import android.graphics.Typeface
import android.view.*
import com.example.parayo.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.*

/*실제 화면에 보여지는 것을 연습하기 위해 만들어 낸 것이다.*/
class IntroActivityUI : AnkoComponent<IntroActivity> {
    override fun createView(ui: AnkoContext<IntroActivity>): View {

        return ui.relativeLayout {
            gravity = Gravity.CENTER

            textView("PARAYO") {
                textSize = 24f
                textColorResource = R.color.design_default_color_primary
                typeface = Typeface.DEFAULT_BOLD
            }
        }


    }

}