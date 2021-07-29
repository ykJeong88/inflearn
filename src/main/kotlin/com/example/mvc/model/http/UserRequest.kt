package com.example.mvc.model.http

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (

        var name:String?=null,
        var age:Int?=null,
        var email:String?=null,
        var address: String?=null,
        var phoneNumber: String?=null

)

/*

{
    "result" : {
        "result_code" : "OK",
        "result_message" : "성공",
    },
    "description" : "~~~~~",
    "user" : [
        {"name":"steve", "age":"32", "email":"", "phoneNumber":""},
        {"name":"kyun", "age":"34", "email":"", "phoneNumber":""},
        {"name":"woo", "age":"28", "email":"", "phoneNumber":""},
    ]
}

 */