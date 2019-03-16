package com.kincodi.yarqay_mobile.domain.executor;

public interface MainThread {
    void post(final Runnable runnable);
}
