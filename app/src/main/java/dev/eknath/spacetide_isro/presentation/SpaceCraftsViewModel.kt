package dev.eknath.spacetide_isro.presentation

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.eknath.spacetide_isro.data.sources.remote.model.SpacecraftEntity
import dev.eknath.spacetide_isro.domain.repository.SpacecraftRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpaceCraftsViewModel @Inject constructor(private val repository: SpacecraftRepository) :
    ViewModel() {
    private val _spaceCraft: MutableStateFlow<List<SpacecraftEntity>?> = MutableStateFlow(null)
    val spaceCraft: StateFlow<List<SpacecraftEntity>?> = _spaceCraft

    fun fetchSpaceCraft() {
        viewModelScope.launch {
            _spaceCraft.emit(repository.getSpaceCraftList().body())
        }
    }

    init {
        fetchSpaceCraft()
    }
}