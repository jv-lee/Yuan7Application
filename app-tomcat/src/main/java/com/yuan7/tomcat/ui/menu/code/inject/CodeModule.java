package com.yuan7.tomcat.ui.menu.code.inject;

import com.yuan7.tomcat.base.scope.ActivityScope;
import com.yuan7.tomcat.ui.menu.code.CodeContract;
import com.yuan7.tomcat.ui.menu.code.CodeModel;
import com.yuan7.tomcat.ui.menu.code.CodePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/9/22.
 */
@Module
public class CodeModule {
    private CodeContract.View view;

    public CodeModule(CodeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    CodeContract.Model provideModel(CodeModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    CodeContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    CodeContract.Presenter providePresenter(CodePresenter presenter) {
        return presenter;
    }
}
