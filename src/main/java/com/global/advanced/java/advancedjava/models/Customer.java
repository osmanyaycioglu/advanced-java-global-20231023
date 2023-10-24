package com.global.advanced.java.advancedjava.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Comparable<Customer> {
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 15)
    private String    firstName;
    @NotEmpty
    @NotBlank
    @Size(min = 3,max = 25)
    private String    lastName;
    @Past
    @NotNull
    private LocalDate birthdate;
    @Max(400)
    @Min(10)
    private Integer   weight;
    @Max(300)
    @Min(50)
    private Integer   height;

    @Override
    public int compareTo(final Customer o) {
        return lastName.compareTo(o.firstName);
    }
}
