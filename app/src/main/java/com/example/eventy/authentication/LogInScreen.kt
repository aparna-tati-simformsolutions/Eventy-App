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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable {
                        navController.navigate(Screens.SplashScreen.route)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Text(
                text = "Sign in",
                fontFamily = RobotoFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.width(60.dp))
        }
        Spacer(modifier = Modifier.height(50.dp))
        Surface(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .background(Color.White),
            shadowElevation = 16.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                EditText(icon = R.drawable.email, inputType = KeyboardType.Email)
                Spacer(modifier = Modifier.height(20.dp))
                EditText(icon = R.drawable.password, inputType = KeyboardType.Ascii)
                Spacer(modifier = Modifier.height(20.dp))
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
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {

            },
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
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.light_blue)
            )
            Text(
                text = "Sign Up",
                fontFamily = RobotoFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.cyan)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(icon: Int, inputType: KeyboardType) {
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
        shape = RoundedCornerShape(50),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = inputType
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(
                colorResource(id = R.color.textfield_background),
                RoundedCornerShape(percent = 50)
            ),
        colors = TextFieldDefaults.textFieldColors(colorResource(id = R.color.light_blue)),
    )
}