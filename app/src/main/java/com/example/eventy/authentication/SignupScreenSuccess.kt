package com.example.eventy.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily

@Composable
fun SignupScreenSuccess(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.signup_success),
                contentDescription = "",
                modifier = Modifier.size(200.dp, 150.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Account Created!",
                        fontFamily = RobotoFamily,
                        color = colorResource(id = R.color.cyan),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.W700
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Your account had beed created\n" +
                            "successfully.",
                        fontFamily = RobotoFamily,
                        color = colorResource(id = R.color.gray),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Please sign in to use your account\n" +
                            "and enjoy",
                        fontFamily = RobotoFamily,
                        color = colorResource(id = R.color.gray),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            navController.navigate(Screens.LogInScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = colorResource(id = R.color.cyan)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 25.dp, end = 25.dp)
                            .height(50.dp)
                    ) {
                        Text(
                            text = "Take me to sign in",
                            fontSize = 18.sp,
                            fontFamily = RobotoFamily
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}