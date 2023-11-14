package com.example.cinemakokplace.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.cinemakokplace.ui.theme.CinemaKokPlaceTheme
import com.example.cinemakokplace.ui.theme.Disabled
import com.example.cinemakokplace.ui.theme.backgroundMain
import com.example.cinemakokplace.ui.theme.mainButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthInput(modifier: Modifier,
              placeholder: String,
              onValueChange: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }
    CinemaKokPlaceTheme {
        TextField(
            value = text,
            onValueChange = {
                text = it
                onValueChange(it)
            },
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFF3F3D40),
                textColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = mainButton
            ),
            textStyle = TextStyle(
                color = mainButton,
                fontSize = 12.sp,
                lineHeight = 12.sp,
                fontFamily = FontFamily.Monospace
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        color = Disabled,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        fontFamily = FontFamily.Monospace
                    )
                )
            },
        )
    }
}