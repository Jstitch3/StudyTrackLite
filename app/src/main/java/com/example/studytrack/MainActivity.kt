package com.example.studytrack

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.studytrack.ui.theme.StudyTrackTheme

// GitHub Repository: https://github.com/Jstitch3/StudyTrackLite

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudyTrackTheme {
                MainScreen(this)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(activity: ComponentActivity) {
    var task by remember { mutableStateOf("") }
    val tasks = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("StudyTrack Lite", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = task,
            onValueChange = { task = it },
            label = { Text("Enter study task") }
        )

        val context = LocalContext.current
        Button(onClick = {
            if (task.isNotBlank()) {
                tasks.add(task)
                task = ""

                showTaskNotification(context, task)
            }
        }) {
            Text("Add Task")
        }

        Button(onClick = {
            val intent = Intent(activity, SecondaryActivity::class.java)
            intent.putStringArrayListExtra("tasks", ArrayList(tasks))
            activity.startActivity(intent)
        }) {
            Text("View Tasks")
        }

        Button(onClick = {
            activity.startActivity(Intent(activity, PreferencesActivity::class.java))
        }) {
            Text("Preferences")
        }

        Button(onClick = {
            activity.startActivity(Intent(activity, HelpActivity::class.java))
        }) {
            Text("Help")
        }
    }
}
