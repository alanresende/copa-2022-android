package me.dio.copa.catar

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import me.dio.copa.catar.domain.usecase.GetMatchesUseCase
import me.dio.copa.catar.domain.usecase.EnableNotificationUseCase
import me.dio.copa.catar.domain.usecase.DisableNotificationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.dio.copa.catar.core.BaseViewModel
import me.dio.copa.catar.domain.model.Match
import me.dio.copa.catar.domain.model.MatchDomain
import me.dio.copa.catar.remote.NotFoundException
import me.dio.copa.catar.remote.UnexpectedException
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel

@HiltViewModel
class MainViewModel(
    private val getMatchesUseCase: GetMatchesUseCase,
    private val enableNotificationUseCase: EnableNotificationUseCase,
    private val disableNotificationUseCase: DisableNotificationUseCase
) : ViewModel() {

    private val _matchesState = mutableStateOf<List<Match>>(emptyList())
    val matchesState: State<List<Match>> get() = _matchesState
    suspend fun getMatches(): List<Match> {
        val matches = getMatchesUseCase.getMatches()
        _matchesState.value = matches
        return getMatchesUseCase.getMatches()

    }

    suspend fun enableNotificationForMatch(matchId: String) {
        enableNotificationUseCase.enableNotificationsForMatch(matchId)
    }

    suspend fun disableNotificationForMatch(matchId: String) {
        disableNotificationUseCase.disableNotificationsForMatch(matchId)
    }
}

@Composable
fun GetMatchList() {
    val viewModel: MainViewModel = viewModel()
    val matches = viewModel.matchesState.value

    LaunchedEffect(Unit) {
        viewModel.getMatches()
    }

    Column {
        for (match in matches) {

        }
    }
}

