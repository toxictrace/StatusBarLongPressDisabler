package com.toxictrace.sblpd

import android.view.MotionEvent
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers.findAndHookMethod
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam

class MainHook : IXposedHookLoadPackage {

    private val targetPackage = "com.android.systemui"
    private val targetClass = "com.android.systemui.shade.NotificationPanelViewController"

    override fun handleLoadPackage(lpparam: LoadPackageParam) {
        if (lpparam.packageName != targetPackage) return

        try {
            findAndHookMethod(
                targetClass,
                lpparam.classLoader,
                "onStatusBarLongPress",
                MotionEvent::class.java,
                XC_MethodReplacement.returnConstant(null)
            )
            XposedBridge.log("[SBLPD] onStatusBarLongPress hooked successfully in $targetClass")
        } catch (t: Throwable) {
            XposedBridge.log("[SBLPD] Failed to hook onStatusBarLongPress: ${t.message}")
            XposedBridge.log(t)
        }
    }
}
