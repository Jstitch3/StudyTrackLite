package com.example.studytrack

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.example.studytrack.ui.theme.StudyTrackTheme

class PreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = getSharedPreferences("settings", Context.MODE_PRIVATE)

        setContent {
            StudyTrackTheme {
                var notificationsEnabled by remember {
                    mutableStateOf(prefs.getBoolean("notifications", true))
                }

                Column(modifier = Modifier.padding(24.dp)) {
                    Text("Preferences", style = MaterialTheme.typography.headlineSmall)

                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = {
                            notificationsEnabled = it
                            prefs.edit { putBoolean("notifications", it) }
                        }
                    )
                    Text("Enable task notifications")
                }
            }
        }
    }
}
