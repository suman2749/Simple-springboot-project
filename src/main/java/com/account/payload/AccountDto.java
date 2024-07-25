package com.account.payload;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountDto {

    private Long id;
    private String name;
    private String city;
    private String type;
    private String branch;
    private String mobile;
    private String email;
    private String messege;

}
