package com.example.eventy.authentication

import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.common.TopAppBar
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily

@Composable
fun CreatePasswordScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Create Password",
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
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Choose a secure password that will be",
                    color = colorResource(id = R.color.light_blue),
                    fontSize = 16.sp,
                    fontFamily = RobotoFamily
                )
                Text(
                    text = "easy for you to remember.",
                    color = colorResource(id = R.color.light_blue),
                    fontSize = 16.sp,
                    fontFamily = RobotoFamily
                )
                Spacer(modifier = Modifier.height(28.dp))
                PasswordTextField()
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = {
                navController.navigate(Screens.ForgetPasswordScreen.route)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField() {
    var text by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                Icon(
                    painter = if (showPassword) painterResource(id = R.drawable.eye) else painterResource(id = R.drawable.password),
                    contentDescription = "",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        },
        shape = RoundedCornerShape(50),
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
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
