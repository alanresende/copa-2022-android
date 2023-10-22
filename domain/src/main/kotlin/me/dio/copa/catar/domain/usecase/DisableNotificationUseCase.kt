package me.dio.copa.catar.domain.usecase

interface DisableNotificationUseCase {
    suspend fun disableNotificationsForMatch(matchId: String)
}
