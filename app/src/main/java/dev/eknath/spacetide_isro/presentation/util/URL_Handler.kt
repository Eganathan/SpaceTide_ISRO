package dev.eknath.spacetide_isro.presentation.util

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import java.lang.ref.WeakReference

fun URLHandler(url: String, context: Context) {
    val build = WeakReference(CustomTabsIntent.Builder())
    val customTabsIntent = build.get()?.build()
    customTabsIntent?.launchUrl(context, Uri.parse(url))
    build.clear()
}