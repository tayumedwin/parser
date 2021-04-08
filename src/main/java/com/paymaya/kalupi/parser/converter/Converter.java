package com.paymaya.kalupi.parser.converter;

public interface Converter<S, T> {
    T convert(S source);
}
