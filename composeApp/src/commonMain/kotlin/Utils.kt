import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun todaysDate(): Triple<String, String, String> {
    val zone = TimeZone.currentSystemDefault()
    val date = Clock.System.now().toLocalDateTime(zone)
    val month = date.month.name.lowercase().replaceFirstChar { it.uppercase() }
    val dayOfMonth = date.dayOfMonth.toString()
    val dayOfWeek = date.dayOfWeek.name.lowercase().replaceFirstChar { it.uppercase() }

    return Triple(month, dayOfMonth, dayOfWeek)

}