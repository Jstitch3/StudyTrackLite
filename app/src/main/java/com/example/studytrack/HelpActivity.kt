package com.example.studytrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studytrack.ui.theme.StudyTrackTheme

class HelpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudyTrackTheme {
                HelpScreen()
            }
        }
    }
}

@Composable
fun HelpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Help", style = MaterialTheme.typography.titleLarge)
        Text("Purpose: StudyTrack Lite helps you manage your study tasks efficiently.")
        Text("Preferences: Set default reminder times in Preferences Activity.")
        Text("Use the Main Activity to add tasks; notifications will alert you immediately.")
        Text("View all tasks in Secondary Activity.")
    }
}
