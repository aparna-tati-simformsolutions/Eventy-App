package com.example.eventy.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.common.TopAppBar
import com.example.eventy.dialogs.PasswordResetEmailSentDialog
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily

@Composable
fun ForgetPasswordScreen(navController: NavController) {
    val isDialogOpen = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Forget Password",
            navController = navController,
            route = Screens.OtpScreen.route
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
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "We will send a mail to the email address",
                    color = colorResource(id = R.color.light_blue),
                    fontFamily = RobotoFamily,
                    fontSize = 16.sp
                )
                Text(
                    text = "you registered to regain your password",
                    color = colorResource(id = R.color.light_blue),
                    fontFamily = RobotoFamily,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(18.dp))
                EditText(icon = R.drawable.email, inputType = KeyboardType.Email, placeHolderText = "Email")
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Email sent to ex*****@gmail.com",
                    color = colorResource(id = R.color.cyan),
                    fontFamily = RobotoFamily,
                    fontSize = 16.sp
                )
                Button(
                    onClick = {
                        isDialogOpen.value = true
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
                        text = "Send",
                        fontSize = 18.sp,
                        fontFamily = RobotoFamily
                    )
                }
            }
        }
        if (isDialogOpen.value) {
            PasswordResetEmailSentDialog(
                onDismiss = {
                    isDialogOpen.value = false
                },
                navController = navController
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}