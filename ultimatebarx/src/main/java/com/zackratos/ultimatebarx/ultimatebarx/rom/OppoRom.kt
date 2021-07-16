package com.zackratos.ultimatebarx.ultimatebarx.rom

import android.content.Context
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.zackratos.ultimatebarx.ultimatebarx.extension.navigationBarHeight
import com.zackratos.ultimatebarx.ultimatebarx.extension.screenHeight

internal class OppoRom : BaseRom() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun fullScreenGestureOn(context: Context): Boolean {
        return Settings.Secure.getInt(context.contentResolver, "hide_navigationbar_enable", -1) > 0
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun screenIndicatorOn(context: Context): Boolean {
        val navHeight = context.navigationBarHeight
        val screenHeight = context.screenHeight
        // 当屏幕高度大于状态栏高度的 30 倍时，就认为开启了手势提示线
        // 否则认为没有开启手势提示线
        return navHeight > 0 && screenHeight / navHeight > 30
    }
}