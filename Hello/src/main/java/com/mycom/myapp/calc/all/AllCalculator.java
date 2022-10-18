package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AllCalculator {

    @Autowired
    @Qualifier("aaa") // interface를 구현한 객체가 2개 이상일 때 어떤 것을 가져올지 정한다.
    Calculator calculator; // interface - DI 주입은 interface 를 구현한 객체

    public int add(int n1, int n2) {
        return calculator.add(n1, n2);
    }
}