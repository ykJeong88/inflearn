package com.example.mvc.controller.response

import com.example.mvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {


    // 1. get 4xx
    // GET localhost:8080/api/response
    @GetMapping("")
    fun getMapping(
            @RequestParam age : Int?
    ): ResponseEntity<String> {

        /*

        // 1. age == null -> 400 error
        if(age == null){
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        // 2. age <>> 20 -> 400 error
        if(age < 20) {
            return ResponseEntity.status(400).body("age 값이 20보다 작습니다")
        }

         */

        return age?.let {
            if(age < 20) {
                return ResponseEntity.status(400).body("age 값이 20보다 작습니다")
            }

            ResponseEntity.ok("OK")
        } ?: kotlin.run {
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

    }

    // 2. post 200
    @PostMapping
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {

        return ResponseEntity.status(200).body(userRequest)
    }


    // 3. put 201
    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {

        //1. 기존 데이터가 없어서 새로 생성했다
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }


    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Int): ResponseEntity<Any> {
        return ResponseEntity.status(500).body(null)
    }

}