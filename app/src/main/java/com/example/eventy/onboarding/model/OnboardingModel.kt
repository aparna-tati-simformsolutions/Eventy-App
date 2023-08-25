package com.example.eventy.onboarding.model

import com.example.eventy.R

class OnboardingModel(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object {
        fun getData(): List<OnboardingModel> {
            return listOf(
                OnboardingModel(R.drawable.first, R.string.onboarding_title1, R.string.onboarding_desc1),
                OnboardingModel(R.drawable.second, R.string.onboarding_title2, R.string.onboarding_desc2),
                OnboardingModel(R.drawable.third, R.string.onboarding_title3, R.string.onboarding_desc3),
                OnboardingModel(R.drawable.fourth, R.string.onboarding_title1, R.string.title)
            )
        }
    }
}