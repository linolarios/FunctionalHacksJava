package com.fuctionahacks.builder;

import com.fuctionahacks.factory.supplier.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);
}
