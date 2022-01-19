package net.hypnoz.resapp.activities

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import net.hypnoz.resapp.R
import net.hypnoz.resapp.base.BaseActivity
import net.hypnoz.resapp.utils.Commons

class TutorialActivity : BaseActivity() {
    var imagelist: ArrayList<Drawable>? = null
    override fun setLayout(): Int {
        return R.layout.activity_tutorial
    }

    override fun InitView() {
        Commons.getCurrentLanguage(this@TutorialActivity, false)
        imagelist = ArrayList()
        imagelist!!.add(ResourcesCompat.getDrawable(resources, R.drawable.ic_pageone, null)!!)
        imagelist!!.add(ResourcesCompat.getDrawable(resources, R.drawable.ic_pagetwo, null)!!)
        imagelist!!.add(ResourcesCompat.getDrawable(resources, R.drawable.ic_pagethree, null)!!)

    }


    override fun onResume() {
        super.onResume()
        Commons.getCurrentLanguage(this@TutorialActivity, false)
    }

}