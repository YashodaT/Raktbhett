package com.sparkCoder.raktbhet.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Valid
public class BankAdminDto {

        @NotNull(message = "User Id is required")
        private Integer userId;

        @NotBlank(message = "Name is required")
        @Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
        private String name;


        private Integer age;

        @NotBlank(message = "Gender is required")
        private String gender;

        @NotBlank(message = "Contact number is required")
        @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter valid 10 digit mobile number")
        private Integer contactNumber;

        @NotNull(message = "Bank Id is required")
        private Integer bankId;

        @NotBlank(message = "Identity Number is required")
        @Size(min = 5, max = 30, message = "Identity Number must be between 5 and 30 characters")
        private String identityNumber;

        @NotBlank(message = "Username is required")
        @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
        private String userName;

        @NotBlank(message = "Password is required")
        @Pattern(regexp = "^[a-zA-Z0-9_]{3,}$", message = "Password must contain uppercase, lowercase, number and special character")
        private String password;

        // Getters & Setters
    }

    /* NotNull
        private Integer userId;

        @NotNull
        @NotEmpty
        @Size(max=20,min=5,message = "size 5-20 takk nahi tr nahi ghenar")
        private String name;

        private String age;
        private String gender;
        @NotNull(message = "contact number tri taak ")
        private Long contactNumber;
        private Integer bankId;
        private String identityNumber;
        @NotNull(message = "hello myname is yashoda")
        private String userName;
        @Pattern(regexp = "^[a-zA-Z0-9_]{3,}$")
        private String password;*/




