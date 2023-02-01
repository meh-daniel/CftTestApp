package test.task.cft.focus.start.com.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.TextView

fun TextView.convertToLinkGeo(context: Context, query: String): TextView {
    setOnClickListener {
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:?q=${query}")
            )
        )
    }
    return this
}