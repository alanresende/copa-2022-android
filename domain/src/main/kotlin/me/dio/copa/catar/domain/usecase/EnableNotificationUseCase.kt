package me.dio.copa.catar.domain.usecase

interface EnableNotificationUseCase {
    suspend fun enableNotificationsForMatch(matchId: String)
}
