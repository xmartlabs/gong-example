package com.xmartlabs.redditposts.device.di

import com.xmartlabs.redditposts.Config
import com.xmartlabs.redditposts.data.service.NetworkLayerCreator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module

/**
 * Created by mirland on 28/04/20.
 */
object NetworkDiModule {
    @Suppress("RemoveExplicitTypeArguments")
    val network = module {
        single<OkHttpClient.Builder> {
            val sessionInterceptors =
                listOf<Interceptor>() // TODO: Add session interceptor and refresh token interceptor
            val networkInterceptorsInjectors = getAll<NetworkLoggingInterceptorInjector>()
            NetworkLayerCreator.createOkHttpClientBuilder(sessionInterceptors, networkInterceptorsInjectors)
        }
        single<OkHttpClient> { get<OkHttpClient.Builder>().build() }
        single {
            NetworkLayerCreator.createRetrofitInstance(Config.API_BASE_URL, get())
        }
    }
}

// There are some libraries that adds the interceptor manually
// ie: https://docs.bugsee.com/sdk/android/network/
fun interface NetworkLoggingInterceptorInjector {
    fun injectNetworkInterceptor(builder: OkHttpClient.Builder)
}
