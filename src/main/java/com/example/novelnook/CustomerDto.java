package com.example.novelnook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
