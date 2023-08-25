package com.example.eventy.spalsh

import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.navigation.Screens
import com.example.eventy.ui.theme.RobotoFamily
import com.example.eventy.ui.theme.RumRasianFamily
import com.example.eventy.ui.theme.SantisaOneFamily
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun HideStatusBar() {
    val context = LocalContext.current
    val activity = context as? ComponentActivity ?: return

    activity.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        WindowCompat.setDecorFitsSystemWindows(activity.window, false)
        activity.window.insetsController?.hide(WindowInsets.Type.statusBars())
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    HideStatusBar()
    LaunchedEffect(Unit) {
        delay(2.seconds)
            navController.navigate(Screens.OnboardingScreen.route)
    }
    Column(
        modifier = Modifier.background(color = colorResource(id = R.color.cyan)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        Box (
            modifier = Modifier
                .size(100.dp)
                .clip(shape = CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "E",
                color = colorResource(id = R.color.cyan),
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp,
                fontFamily = SantisaOneFamily
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Eventy",
            fontFamily = RumRasianFamily,
            color = Color.White,
            fontWeight = FontWeight.W900,
            fontSize = 63.sp,
            letterSpacing = 16.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Event Organizer App UI Design",
            fontFamily = RobotoFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.White
        )
    }
}