package com.products.financialcontrol.usermanager.usermanager.controllers

import com.products.financialcontrol.usermanager.usermanager.controllers.dto.UserDto
import com.products.financialcontrol.usermanager.usermanager.controllers.form.UserForm
import com.products.financialcontrol.usermanager.usermanager.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping
    fun create(@RequestBody @Valid userForm: UserForm, uriBuilder: UriComponentsBuilder) : ResponseEntity<UserDto> {
        val user = userService.save(userForm.toEntity())
        val location = uriBuilder.path("/users/{email}").buildAndExpand(user.email).toUri()
        return ResponseEntity.created(location).body(user.toDto())
    }

    @GetMapping("/{login}")
    fun findUserByLogin(@PathVariable login: String): ResponseEntity<UserDto> {
        return ResponseEntity.ok(userService.findUserByEmail(login).toDto())
    }
}