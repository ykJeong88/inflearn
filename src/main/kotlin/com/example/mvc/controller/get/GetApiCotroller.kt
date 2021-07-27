package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController             //restapi controller
@RequestMapping("/api")
class GetApiCotroller {

    @GetMapping(path=["/hello","/abcd"])  // GET /api/hello /api/abcd
    fun hello() : String{
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path=["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name:String, @PathVariable age:Int): String {
        println("${name} , ${age}")
        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value="name") _name:String, @PathVariable(name="age") age:Int): String {
        val name = "kotlin"
        println("${_name} , ${age}")
        return _name + " " + age
    }

    // http://localhost:8080/api/page?key=value&key=value
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
            @RequestParam(value="name") _name : String,
            @RequestParam age : Int
    ): String {
        println("${_name}, ${age}")
        return _name + " " + age
    }


    // name, age, address, email
    @GetMapping("/get-mapping/query-param-object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String, Any> {
        val phoneNumber = map.get("phone-number")
        println(phoneNumber)
        return map
    }


}