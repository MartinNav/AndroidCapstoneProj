package com.example.androiddevcapstone

interface Destinations {
    val route:String
}

object OnBoardingD:Destinations{
    override val route = "Onboarding"
}
object HomeD:Destinations{
    override val route = "Home"
}
object ProfileD:Destinations{
    override val route = "Profile"
}