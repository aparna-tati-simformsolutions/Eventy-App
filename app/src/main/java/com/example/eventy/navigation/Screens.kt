package com.example.eventy.navigation

sealed class Screens(val route: String) {
    object SplashScreen: Screens(route = "Splash_Screen")
    object OnboardingScreen: Screens(route = "Onboarding_Screen")
    object LogInScreen: Screens(route = "Login_Screen")
    object SignUpScreen: Screens(route = "Signup_Screen")
    object PhoneScreen: Screens(route = "Phone_Screen")
    object OtpScreen: Screens(route = "OTP_Screen")
    object CreatePasswordScreen: Screens(route = "Create_Password_Screen")
    object ForgetPasswordScreen: Screens(route = "Forget_Password_Screen")
    object ForgetPasswordOTPScreen: Screens(route = "Forget_Password_OTP_Screen")
    object ChangePasswordScreen: Screens(route = "Change_Password_Screen")
    object SignupSuccessScreen: Screens(route = "Signup_Success_Screen")
}