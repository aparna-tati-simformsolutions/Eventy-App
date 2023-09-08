package com.example.eventy.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily

@Composable
fun PasswordResetEmailSentDialog(onDismiss: () -> Unit, navController: NavController) {
    Dialog(onDismissRequest = {
        onDismiss()
    }) {
        Card(shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier
                    .size(550.dp, 60.dp)
                    .background(
                        color =
                        colorResource(id = R.color.cyan)
                    )
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Password Reset Email Sent",
                        color = Color.White,
                        fontFamily = RobotoFamily,
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.height(27.dp))
                Text(
                    text = "An email has been sent to\n" +
                        "you Follow direction in the email to\n" +
                        "reset password",
                    color = colorResource(id = R.color.light_blue),
                    fontFamily = RobotoFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
                Button(
                    onClick = {
                        onDismiss()
                        navController.navigate(Screens.ForgetPasswordOTPScreen.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = colorResource(id = R.color.cyan)
                    ),
                    modifier = Modifier
                        .width(250.dp)
                        .padding(30.dp)
                ) {
                    Text(
                        text = "OK",
                        fontSize = 18.sp,
                        fontFamily = RobotoFamily
                    )
                }
            }
        }
    }
}
