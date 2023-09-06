package com.example.eventy.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.common.TopAppBar
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneScreen(navController: NavController) {
    val text = remember { mutableStateOf("") }
    val countryCode = remember { mutableStateOf("+1") }
    val isDropdownExpanded = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Sign in",
            navController = navController,
            route = Screens.LogInScreen.route
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
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Simply enter your phone number to login\n" +
                        "or create an account.",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W400,
                    fontFamily = RobotoFamily
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier.background(
                            colorResource(id = R.color.textfield_background),
                            RoundedCornerShape(percent = 50)
                        ),
                        contentAlignment = Alignment.CenterStart,

                    ) {
                        Text(
                            text = countryCode.value,
                            modifier = Modifier
                                .clickable { isDropdownExpanded.value = true }
                                .padding(16.dp)
                        )
                        DropdownMenu(
                            expanded = isDropdownExpanded.value,
                            onDismissRequest = { isDropdownExpanded.value = false },
                        ) {
                            // Replace these with your country codes
                            listOf("+1", "+44", "+91").forEach { code ->
                                DropdownMenuItem(text = { Text(text = code) }, onClick = {
                                    countryCode.value = code
                                    isDropdownExpanded.value = false
                                })
                            }
                        }
                    }

                    // TextField component for entering phone number
                    TextField(
                        value = text.value,
                        onValueChange = {
                            text.value = it
                        },
                        maxLines = 1,
                        textStyle = TextStyle(
                            fontSize = 16.sp
                        ),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                colorResource(id = R.color.textfield_background),
                                RoundedCornerShape(percent = 50)
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = colorResource(id = R.color.light_blue),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.light_blue),
                            fontFamily = RobotoFamily,
                            fontWeight = FontWeight.W500,
                            fontSize = 15.sp)
                    ) {
                        append("By using our mobile app, you agree to our and")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.light_blue),
                            fontSize = 15.sp,
                            fontFamily = RobotoFamily)
                    ) {
                        append(" Privacy Policy  Terms of Use")
                    }
                }, textAlign = TextAlign.Center, modifier = Modifier.padding(4.dp))
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
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
                text = "Continue",
                fontSize = 18.sp,
                fontFamily = RobotoFamily
            )
        }
    }
}