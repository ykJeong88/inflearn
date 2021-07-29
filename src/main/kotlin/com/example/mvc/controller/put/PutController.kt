package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PutController {

    @PutMapping("/put-mapping")
    fun putMapping (): String {
        return "put-mapping"
    }

    @RequestMapping(method=[RequestMethod.PUT], path=["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping put-mapping"
    }

    @PutMapping(path=["/put-mapping/object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {

        //0.userResponse
        return UserResponse().apply {
            //1.result
            Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"

            }

        }.apply {
            //2.description
            this.description = "~~~~~~~"
        }.apply {
            //3.user mutableList
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)

            userList.add(UserRequest().apply {

                this.name ="a"
                this.age = 10
                this.email = "a@gmail.com"
                this.address = "Aaddress"
                this.phoneNumber = "123"
            })

            userList.add(UserRequest().apply {

                this.name ="b"
                this.age = 20
                this.email = "b@gmail.com"
                this.address = "Baddress"
                this.phoneNumber = "456"
            })

            this.userRequest = userList

        }

    }


}