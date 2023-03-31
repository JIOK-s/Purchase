package com.jiok.purchase.entity;


import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
@ToString
@Getter
public class CarProduct extends UserProduct{

    private Integer mileage;

    private Boolean accidentTf;

    private Boolean repairTf;

}
