package com.newlastfm.app;

import com.newlastfm.app.db.Storage;
import com.newlastfm.app.rest.ServerAPIFacade;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

/**
 * Created by Artem Mykhelson <artem.mykhelson@t4soft.com> on 8/28/14.
 */
@EBean(scope = EBean.Scope.Singleton)
public class AppContext {
    @Bean
    public Storage storage;
    @Bean
    public ServerAPIFacade api;
}
