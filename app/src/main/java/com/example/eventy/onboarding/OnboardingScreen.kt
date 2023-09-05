package com.example.eventy.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.eventy.R
import com.example.eventy.navigation.Screens
import com.example.eventy.onboarding.model.OnboardingModel
import com.example.eventy.ui.theme.RobotoFamily
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val onboardingData = OnboardingModel.getData()
    val pageState = rememberPagerState()
    val scope = rememberCoroutineScope()
    
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray.copy(alpha = .2f))) {

        HorizontalPager(
            count = onboardingData.size,
            state = pageState,
            modifier = Modifier
                .fillMaxHeight(.9f)
                .fillMaxWidth()
        ) { page ->
            if (page == 3) {
                OnboardingItem(item = onboardingData[page], flag = true, pageState = pageState, scope = scope, navController = navController)
            } else {
                OnboardingItem(item = onboardingData[page], flag = false, pageState = pageState, scope = scope, navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingItem(item: OnboardingModel, flag: Boolean, pageState: PagerState, scope: CoroutineScope, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "description",
            modifier = Modifier.size(width = 300.dp, height = 250.dp)
        )
        if (flag) {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = stringResource(id = item.title),
                fontFamily = RobotoFamily,
                fontWeight = FontWeight.W900,
                fontSize = 30.sp,
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center,
                lineHeight = 35.sp
            )
            Spacer(modifier = Modifier.height(14.dp))
            Button(
                onClick = {
                    navController.navigate(Screens.LogInScreen.route)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = colorResource(id = R.color.cyan)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Sign in",
                    fontSize = 18.sp,
                    fontFamily = RobotoFamily
                )
            }
            OutlinedButton(
                onClick = {
                    navController.navigate(Screens.SignUpScreen.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.cyan),
                    containerColor = Color.White
                ),
                border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.cyan))
            ) {
                Text(
                    text = "Register by No.",
                    fontSize = 18.sp,
                    fontFamily = RobotoFamily
                )
            }
        } else {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = stringResource(id = item.title),
                fontFamily = RobotoFamily,
                fontWeight = FontWeight.W900,
                fontSize = 30.sp,
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center,
                lineHeight = 35.sp
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = stringResource(id = item.desc),
                fontFamily = RobotoFamily,
                fontSize = 18.sp,
                modifier = Modifier.width(250.dp),
                textAlign = TextAlign.Center,
                lineHeight = 25.sp
            )
            Button(
                onClick = {
                    scope.launch {
                        pageState.scrollToPage(pageState.currentPage + 1)
                    }
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
                    text = "Get Started",
                    fontSize = 18.sp,
                    fontFamily = RobotoFamily
                )
            }
        }
    }
}