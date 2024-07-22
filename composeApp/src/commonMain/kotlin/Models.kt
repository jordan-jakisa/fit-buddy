import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.datetime.Clock

data class ActivityModel(
    val id: Long = Clock.System.now().toEpochMilliseconds(),
    val icon: ImageVector? = null,
    val reps: Int = Int.MIN_VALUE,
    val name: String = "",
)