package com;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:AppConfig.properties")
public interface IAppConfig extends Config {

    String pageGroupIsEmpty();
    String pageOfferIsEmpty();
    String pagePidIsEmpty();
    String pageWithGroup();
    String pageWithOffer();
}
