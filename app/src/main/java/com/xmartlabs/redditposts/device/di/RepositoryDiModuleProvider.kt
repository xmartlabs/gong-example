package com.xmartlabs.redditposts.device.di

import androidx.datastore.dataStore
import com.xmartlabs.redditposts.Config
import com.xmartlabs.redditposts.data.model.service.settings.AppSettings
import com.xmartlabs.redditposts.data.repository.store.datastorage.JsonDataStoreEntitySerializer
import org.koin.dsl.module

/**
 * Created by mirland on 25/04/20.
 */
object RepositoryDiModuleProvider {
    val stores = module {
        single {
            dataStore(fileName = Config.APP_SETTINGS_SHARED_PREFERENCES_NAME,
                serializer = JsonDataStoreEntitySerializer(AppSettings.serializer(), ::AppSettings)
            ).getValue(get(), this::javaClass)
        }
    }
    val sources = module {
    }
    val repositories = module {
    }
}
