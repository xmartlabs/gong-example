package com.xmartlabs.redditposts.device.di

import androidx.datastore.dataStore
import androidx.room.Room
import com.xmartlabs.redditposts.Config
import com.xmartlabs.redditposts.data.model.service.settings.AppSettings
import com.xmartlabs.redditposts.data.repository.store.datastorage.JsonDataStoreEntitySerializer
import com.xmartlabs.redditposts.data.repository.store.db.AppDatabase
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
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, Config.DB_NAME)
                .build()
        }
        single { get<AppDatabase>().locationDao() }
    }
    val sources = module {

    }
    val repositories = module {

    }
}
