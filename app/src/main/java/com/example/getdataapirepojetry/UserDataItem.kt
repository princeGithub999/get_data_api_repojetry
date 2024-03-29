package com.example.getdataapirepojetry

data class UserDataItem(
    val userId: Int,
    val id: Int,
    val body: String,
    val title: String

)
data class UserPostData(
    val userId: Int,
    val body: String,
    val title: String
)


//data class UserUpdateData(
//    val userId: Int,
//    val body: String,
//    val title: String
//)
//data class UserDeleteData(
//    val userId: Int,
////    val body: String,
////    val title: String
//)

