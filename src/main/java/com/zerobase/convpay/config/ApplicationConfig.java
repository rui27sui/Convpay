package com.zerobase.convpay.config;

import com.zerobase.convpay.service.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {
    @Bean
    public ConveniencePayService conveniencePayService() {
        DiscountByConvenience discountInterface = new DiscountByConvenience();
        return new ConveniencePayService(
                new HashSet<>(Arrays.asList(MoneyAdapter(), cardAdapter())),
                discountByConvenience()
        );
    }

    @Bean
    public static CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public static MoneyAdapter MoneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public static DiscountByConvenience discountByConvenience() {
        return new DiscountByConvenience();
    }

}