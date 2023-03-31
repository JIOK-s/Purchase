package com.jiok.purchase.entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("General")
@ToString
@Getter
public class GeneralProduct extends UserProduct {
}
