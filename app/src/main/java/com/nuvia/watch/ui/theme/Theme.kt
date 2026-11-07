package com.nuvia.watch.ui.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material3.MaterialTheme

/** App-wide theme. Brand colors and typography will be customized here. */
@Composable
fun NuviaTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}
