package com.example.mvc.model.http

import com.example.mvc.annotation.StringFormatDateTime
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.format.annotation.DateTimeFormat
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)

data class UserRequest (

        @field: NotEmpty
        @field: Size(min = 2, max = 5)
        var name:String?=null,

        @field:PositiveOrZero // 0 <= 숫자를 검증 0 도 포함 (양수)
        var age:Int?=null,

        @field: Email
        var email:String?=null,

        @field: NotBlank
        var address: String?=null,

        @field: Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
        var phoneNumber: String?=null,

        @field:StringFormatDateTime(pattern="yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
        var createdAt: String?=null //yyyy-MM-dd HH:mm:ss

) {

//        @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 이어야 합니다.")
//        private fun isValidCreatedAt():Boolean {
//                // 정상 true , 비정상 false
//
//                return try {
//                        LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//                        true
//                } catch (e: Exception) {
//                        false
//                }
//
//        }

}

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