package com.example.cinemakokplace.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.ui.theme.backgroundMain
import com.example.cinemakokplace.ui.theme.backgroundSecondary
import com.example.cinemakokplace.ui.theme.mainButton

@Composable
fun NotificationDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Notification in", color = mainButton) },
            text = {
                LazyColumn {
                    items(options) { option ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clickable { onOptionSelected(option) }
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = option == selectedOption,
                                onClick = { onOptionSelected(option) },
                                colors = RadioButtonDefaults.colors(selectedColor = mainButton, unselectedColor = mainButton)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = option, color = Color.White)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "CANCEL", color = mainButton)
                }
            },
            containerColor = backgroundSecondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestNotificationDialog() {
    val showDialog = remember { mutableStateOf(true) }
    val options = listOf("20 min", "30 min", "1 hour", "1 hour 30 min", "2 hours", "3 hours", "1 day")
    val selectedOption = remember { mutableStateOf(options[0]) }
    NotificationDialog(
        showDialog = showDialog.value,
        onDismiss = { showDialog.value = false },
        options = options,
        selectedOption = selectedOption.value,
        onOptionSelected = { selectedOption.value = it }
    )
}