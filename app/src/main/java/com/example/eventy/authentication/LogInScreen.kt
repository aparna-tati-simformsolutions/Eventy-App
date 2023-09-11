package com.example.eventy.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import com.example.eventy.common.TopAppBar
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily

@Composable
fun LogInScreen(navController: NavController) {
    val checked = remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Sign in",
            navController = navController,
            route = Screens.SplashScreen.route
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
                    .padding(21.dp)
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                EditText(
                    icon = R.drawable.email,
                    inputType = KeyboardType.Email,
                    placeHolderText = "Email",
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(20.dp))
                EditText(
                    icon = R.drawable.password,
                    inputType = KeyboardType.Ascii,
                    placeHolderText = "Password",
                    imeAction = ImeAction.Done
                )
                Spacer(modifier = Modifier.height(21.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.weight(1f)
                    ) {
                        Checkbox(
                            checked = checked.value,
                            onCheckedChange = {
                                checked.value = it
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = colorResource(id = R.color.cyan)
                            )
                        )
                        Text(
                            text = "Remember me",
                            color = colorResource(id = R.color.light_blue),
                            fontFamily = RobotoFamily,
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Forget Password ?",
                            color = colorResource(id = R.color.cyan),
                            fontWeight = FontWeight.W500,
                            fontSize = 12.sp,
                            fontFamily = RobotoFamily,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                navController.navigate(Screens.ForgetPasswordScreen.route)
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                navController.navigate(Screens.PhoneScreen.route)
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
                text = "Sign in",
                fontSize = 18.sp,
                fontFamily = RobotoFamily
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Don’t have an account? ",
                fontFamily = RobotoFamily,
                fontSize = 16.sp,
                color = colorResource(id = R.color.light_blue)
            )
            Text(
                text = "Sign Up",
                fontFamily = RobotoFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.cyan),
                modifier = Modifier.clickable {
                    navController.navigate(Screens.SignUpScreen.route)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(icon: Int, inputType: KeyboardType, placeHolderText: String, imeAction: ImeAction) {
    val text = remember { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 16.sp
        ),
        leadingIcon = {
            Icon(painter = painterResource(id = icon), contentDescription = "")
        },
        placeholder = { Text(text = placeHolderText) },
        shape = RoundedCornerShape(50),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = inputType,
            imeAction = imeAction
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