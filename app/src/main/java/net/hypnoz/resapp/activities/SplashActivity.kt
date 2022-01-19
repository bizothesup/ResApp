package net.hypnoz.resapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import net.hypnoz.resapp.R
import net.hypnoz.resapp.base.BaseActivity
import net.hypnoz.resapp.utils.Commons
import net.hypnoz.resapp.utils.Commons.printKeyHash
import net.hypnoz.resapp.utils.SharePreference
import net.hypnoz.resapp.utils.SharePreference.Companion.getBooleanPref

class SplashActivity : BaseActivity() {

    override fun setLayout(): Int {
        return R.layout.activity_splash
    }

    override fun InitView() {
        if (Commons.isCheckNetwork(this@SplashActivity)) {
            callGetLoginType()
        } else {
            Commons.alertErrorOrValidationDialog(
                this@SplashActivity,
                resources.getString(R.string.no_internet)
            )
        }

        Commons.getLog("getShaKey", printKeyHash(this@SplashActivity)!!)
        Commons.getCurrentLanguage(this@SplashActivity, false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (!getBooleanPref(this@SplashActivity, SharePreference.isTutorial)) {
               openActivity(TutorialActivity::class.java)
                finish()
            } else {
                openActivity(DashboardActivity::class.java)
                finish()
            }
        }, 3000)

    }

    private fun callGetLoginType() {

    }
    override fun onResume() {
        super.onResume()
        Commons.getCurrentLanguage(this@SplashActivity, false)
    }
}