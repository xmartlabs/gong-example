package com.xmartlabs.redditposts.device.di

import androidx.datastore.dataStore
import androidx.room.Room
import com.xmartlabs.redditposts.Config
import com.xmartlabs.redditposts.data.model.service.settings.AppSettings
import com.xmartlabs.redditposts.data.repository.auth.UserLocalSource
import com.xmartlabs.redditposts.data.repository.auth.UserRemoteSource
import com.xmartlabs.redditposts.data.repository.location.LocationLocalSource
import com.xmartlabs.redditposts.data.repository.location.LocationRemoteSource
import com.xmartlabs.redditposts.data.repository.session.SessionLocalSource
import com.xmartlabs.redditposts.data.repository.store.datastorage.JsonDataStoreEntitySerializer
import com.xmartlabs.redditposts.data.repository.store.db.AppDatabase
import com.xmartlabs.redditposts.domain.repository.LocationRepository
import com.xmartlabs.redditposts.domain.repository.SessionRepository
import com.xmartlabs.redditposts.domain.repository.UserRepository
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
        single { LocationRemoteSource(get()) }
        single { LocationLocalSource(get()) }
        single { UserLocalSource() }
        single { UserRemoteSource() }
        single { SessionLocalSource(get()) }
    }
    val repositories = module {
        single { LocationRepository(get(), get()) }
        single { UserRepository(get(), get(), get()) }
        single { SessionRepository(get()) }
    }
}
