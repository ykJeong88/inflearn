package com.example.mvc.controller.put

import com.example.mvc.model.http.Result
import com.example.mvc.model.http.UserRequest
import com.example.mvc.model.http.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        if(bindingResult.hasErrors()) {
            // 500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field+" : " + message + "\n")
            }

            return ResponseEntity.badRequest().body(msg.toString())
        }

        //0.userResponse
//        return UserResponse().apply {
//            //1.result
//            Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "성공"
//
//            }
//
//        }.apply {
//            //2.description
//            this.description = "~~~~~~~"
//        }.apply {
//            //3.user mutableList
//            val userList = mutableListOf<UserRequest>()
//
//            userList.add(userRequest)
//
//            userList.add(UserRequest().apply {
//
//                this.name ="a"
//                this.age = 10
//                this.email = "a@gmail.com"
//                this.address = "Aaddress"
//                this.phoneNumber = "123"
//            })
//
//            userList.add(UserRequest().apply {
//
//                this.name ="b"
//                this.age = 20
//                this.email = "b@gmail.com"
//                this.address = "Baddress"
//                this.phoneNumber = "456"
//            })
//
//            this.userRequest = userList
//
//        }
        return ResponseEntity.ok("")

    }


}