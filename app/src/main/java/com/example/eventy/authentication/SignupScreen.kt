package com.example.eventy.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
fun SignUpScreen(navController: NavController) {
    val checked = remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(top = 30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Sign up",
            navController = navController,
            route = Screens.SplashScreen.route
        )
        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Column(modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(color = colorResource(id = R.color.textfield_background))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(50.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                EditText(
                    inputType = KeyboardType.Ascii,
                    placeHolderText = "Full name",
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(18.dp))
                EditText(
                    inputType = KeyboardType.Phone,
                    placeHolderText = "Phone Number",
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(18.dp))
                EditText(
                    inputType = KeyboardType.Email,
                    placeHolderText = "Email",
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(18.dp))
                EditText(
                    inputType = KeyboardType.Password,
                    placeHolderText = "Password",
                    imeAction = ImeAction.Next
                )
                Spacer(modifier = Modifier.height(18.dp))
                EditText(
                    inputType = KeyboardType.Password,
                    placeHolderText = "Confirm Password",
                    imeAction = ImeAction.Done
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
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
                        text = "By creating an account you agree to\n" +
                                "our Terms of Service and Privacy Policy",
                        color = colorResource(id = R.color.light_blue),
                        fontFamily = RobotoFamily,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = colorResource(id = R.color.cyan)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(25.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Sign up",
                        fontSize = 18.sp,
                        fontFamily = RobotoFamily
                    )
                }
                Spacer(modifier = Modifier.height(14.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Already have an account? ",
                        fontFamily = RobotoFamily,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.light_blue)
                    )
                    Text(
                        text = "Sign in!",
                        fontFamily = RobotoFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        color = colorResource(id = R.color.cyan),
                        modifier = Modifier.clickable {
                            navController.navigate(Screens.LogInScreen.route)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(inputType: KeyboardType, placeHolderText: String?, imeAction: ImeAction) {
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
        placeholder = { Text(text = placeHolderText ?: "") },
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
        )
    )
}