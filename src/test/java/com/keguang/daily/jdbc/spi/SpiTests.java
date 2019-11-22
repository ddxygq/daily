package com.keguang.daily.jdbc.spi;

import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ Author: keguang
 * @ Date: 2019/11/14 15:59
 * @ version: v1.0.0
 * @ description:
 */
public class SpiTests {

    @Test
    public void testSpi(){
        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);

        Iterator<SpiService> iterator = serviceLoader.iterator();

        while (iterator.hasNext()){
            SpiService spiService = iterator.next();
            spiService.hello();
        }

    }
}
