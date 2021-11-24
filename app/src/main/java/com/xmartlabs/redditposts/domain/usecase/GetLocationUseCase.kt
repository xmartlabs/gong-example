package com.xmartlabs.redditposts.domain.usecase

import com.dropbox.android.external.store4.StoreResponse
import com.xmartlabs.redditposts.data.model.Location
import com.xmartlabs.redditposts.domain.repository.LocationRepository
import com.xmartlabs.redditposts.domain.usecase.common.FlowStoreCoroutineUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/**
 * Created by mirland on 28/04/20.
 */
class GetLocationUseCase(
    private val locationRepository: LocationRepository,
    dispatcher: CoroutineDispatcher,
) : FlowStoreCoroutineUseCase<Unit, Location>(dispatcher) {
    override fun execute(params: Unit): Flow<StoreResponse<Location>> = locationRepository.getLocation()
}
