package com.example.eventy.navigation

sealed class Screens(val route: String) {
    object SplashScreen: Screens(route = "Splash_Screen")
    object OnboardingScreen: Screens(route = "Onboarding_Screen")
    object LogInScreen: Screens(route = "Login_Screen")
    object SignUpScreen: Screens(route = "Signup_Screen")
    object PhoneScreen: Screens(route = "Phone_Screen")
    object OtpScreen: Screens(route = "OTP_Screen")
}