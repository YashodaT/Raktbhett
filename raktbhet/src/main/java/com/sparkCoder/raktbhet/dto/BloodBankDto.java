package com.sparkCoder.raktbhet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BloodBankDto {


    @NotNull(message = "Blood Bank Id is required")
    private Integer bloodBankId;

    @NotBlank(message = "Blood Bank Name is required")
    @Size(min = 3, max = 50, message = "Blood Bank Name must be between 3 and 50 characters")
    private String bloodBankName;

    @NotBlank(message = "License Number is required")
    @Size(min = 5, max = 30, message = "License Number must be between 5 and 30 characters")
    private String licenseNumber;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String address;

    @NotNull(message = "Contact Number is required")
    private Long contactNumber;







/* private Integer bloodBankId;
        private String bloodBankName;
        private String licenseNumber;
        private String address;
        private Long contactNumber;*/


    }


