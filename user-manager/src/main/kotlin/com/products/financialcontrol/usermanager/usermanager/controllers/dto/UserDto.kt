package com.products.financialcontrol.usermanager.usermanager.controllers.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class UserDto(val userId: Long,
              val email: String,
              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
              val dateRegister: LocalDateTime)