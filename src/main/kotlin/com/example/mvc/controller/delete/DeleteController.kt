package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteController {

    //1.path variable
    //2.request param
    @DeleteMapping(path=["/delete-mapping"])
    fun deleteMapping(
            @RequestParam(value="name") _name : String,
            @RequestParam age : Int
    ): String {
        println(_name)
        println(age)
        return _name + " " + age
    }

    @DeleteMapping(path=["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
            @PathVariable(name="name") _name:String,
            @PathVariable(value="age") _age:Int
    ): String {
        println(_name)
        println(_age)
        return _name + " " + _age
    }

}