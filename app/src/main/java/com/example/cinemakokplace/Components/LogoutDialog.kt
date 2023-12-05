package com.example.cinemakokplace.Components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinemakokplace.ui.theme.backgroundSecondary
import com.example.cinemakokplace.ui.theme.cancel
import com.example.cinemakokplace.ui.theme.mainButton

@Composable
fun LogoutDialog(
    onDismiss: () -> Unit,
    onLogout: () -> Unit
) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Log out?", color = Color.White) },
            text = { Text(text = "Are you sure you want to log out?", color = Color.White) },
            confirmButton = {
                Button(onClick = { onDismiss() }, colors = ButtonDefaults.buttonColors(cancel), shape = RoundedCornerShape(10.dp)) {
                    Text(text = "CANCEL", color = Color.White)
                }
            },
            dismissButton = {
                Button(onClick = { onLogout() }, colors = ButtonDefaults.buttonColors(mainButton), shape = RoundedCornerShape(10.dp)) {
                    Text(text = "LOG OUT", color = Color.White)
                }
            },
            containerColor = backgroundSecondary
        )
}

@Preview(showBackground = true)
@Composable
fun TestDialog() {
    LogoutDialog(onDismiss = { /*TODO*/ }, onLogout = { /*TODO*/ })
}