package com.example.eventy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eventy.authentication.LogInScreen
import com.example.eventy.authentication.OTPScreen
import com.example.eventy.authentication.PhoneScreen
import com.example.eventy.authentication.SignUpScreen
import com.example.eventy.onboarding.OnboardingScreen
import com.example.eventy.spalsh.SplashScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = Screens.OnboardingScreen.route) {
            OnboardingScreen(navController)
        }
        composable(route = Screens.LogInScreen.route) {
            LogInScreen(navController)
        }
        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(route = Screens.PhoneScreen.route) {
            PhoneScreen(navController)
        }
        composable(route = Screens.OtpScreen.route) {
            OTPScreen(navController)
        }
    }
}