package com.lambdaschool.httpoperations.retrofit

import com.lambdaschool.httpoperations.model.*
import com.squareup.moshi.FromJson



// TODO 12: Write type adapter for subclasses

internal class EmployeeTypeAdapter {
    @FromJson
    fun eventFromJson(employeeJson: EmployeeJson): Employee {
        return when (employeeJson.title){
            "Engineer" -> Engineer(employeeJson.name, employeeJson.id, employeeJson.age, employeeJson.title)
            "CTO", "CEO" -> Officer(employeeJson.name, employeeJson.id, employeeJson.age, employeeJson.title)
            "Tester" -> Tester(employeeJson.name, employeeJson.id, employeeJson.age, employeeJson.title)
            "UX Designer" -> Designer(employeeJson.name, employeeJson.id, employeeJson.age, employeeJson.title)
            else -> Employee(employeeJson.name, employeeJson.id, employeeJson.age, employeeJson.title)
        }
    }

//    @ToJson
//    fun eventToJson(event: Event): EventJson {
//        val json = EventJson()
//        return json
//    }
}