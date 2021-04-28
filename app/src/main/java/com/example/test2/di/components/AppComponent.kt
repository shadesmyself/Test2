package com.example.test2.di.components

import android.content.Context
import com.example.test2.activityThree.ui.ActivityThree
import com.example.test2.di.module.ActivityThreeModule
import com.example.test2.di.module.ContextModule
import dagger.Component

@Component(modules = [ActivityThreeModule::class, ContextModule::class])
interface AppComponent {

    fun inject(context: Context)
    fun inject(activity: ActivityThree)
}