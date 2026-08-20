package com.toxictrace.sblpd

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this)
        tv.text = "Активируйте модуль в LSPosed Manager\nи перезапустите System UI.\n\nHook: onStatusBarLongPress → returnConstant(null)"
        tv.setPadding(48, 96, 48, 48)
        tv.textSize = 16f
        setContentView(tv)
    }
}
