package com.example.eventy.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.common.TopAppBar
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily

@Composable
fun OTPScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    val (digit1, setDigit1) = remember {
        mutableStateOf("")
    }
    val (digit2, setDigit2) = remember {
        mutableStateOf("")
    }
    val (digit3, setDigit3) = remember {
        mutableStateOf("")
    }
    val (digit4, setDigit4) = remember {
        mutableStateOf("")
    }

    LaunchedEffect(
        key1 = digit1,
    ) {
        if (digit1.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }
    LaunchedEffect(
        key1 = digit2,
    ) {
        if (digit2.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }
    LaunchedEffect(
        key1 = digit3,
    ) {
        if (digit3.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }

    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "OTP Verification",
            navController = navController,
            route = Screens.PhoneScreen.route
        )
        Card(
            shape = RoundedCornerShape(30.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            ),
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "An authentication code has been sent to",
                    fontFamily = RobotoFamily,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.light_blue)
                )
                Text(
                    text = "(+880) 111 222 333",
                    fontFamily = RobotoFamily,
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.light_blue)
                )
                Spacer(modifier = Modifier.height(18.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    OTPItem(text = digit1, setDigit1)
                    OTPItem(text = digit2, setDigit2)
                    OTPItem(text = digit3, setDigit3)
                    OTPItem(text = digit4, setDigit4)
                }
                Spacer(modifier = Modifier.height(25.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "I didn't receive code.",
                        color = colorResource(id = R.color.light_blue),
                        fontFamily = RobotoFamily,
                        fontSize = 16.sp
                    )
                    Text(
                        text = " Resend Code",
                        color = colorResource(id = R.color.cyan),
                        fontFamily = RobotoFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
        Button(
            onClick = {
                navController.navigate(Screens.OtpScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = colorResource(id = R.color.cyan)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .height(50.dp)
        ) {
            Text(
                text = "Verify Now",
                fontSize = 18.sp,
                fontFamily = RobotoFamily
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTPItem(text: String, setText: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = {
           setText(it)
        },
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = RobotoFamily,
            textAlign = TextAlign.Center
        ),
        shape = RoundedCornerShape(50),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Next,
        ),
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .background(
                colorResource(id = R.color.textfield_background),
                RoundedCornerShape(percent = 50)
            ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.cyan),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}