package com.example.eventy.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
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
fun ChangePasswordScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Change Password",
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
                Spacer(modifier = Modifier.height(29.dp))
                PasswordEditText(placeHolderText = "Old Password")
                Spacer(modifier = Modifier.height(15.dp))
                PasswordEditText(placeHolderText = "Password")
                Spacer(modifier = Modifier.height(15.dp))
                PasswordEditText(placeHolderText = "Confirm Password")
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
//                        navController.navigate(Screens.PhoneScreen.route)
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
                        text = "Save Now !",
                        fontSize = 18.sp,
                        fontFamily = RobotoFamily
                    )
                }
                Spacer(modifier = Modifier.height(29.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordEditText(placeHolderText: String) {
    val text = remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 16.sp
        ),
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                Icon(
                    painter = if (showPassword) painterResource(id = R.drawable.eye) else painterResource(id = R.drawable.password),
                    contentDescription = "",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = { Text(text = placeHolderText) },
        shape = RoundedCornerShape(50),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password
        ),
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
        ),
    )
}
