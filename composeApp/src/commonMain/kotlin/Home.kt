import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .drawBehind {
                drawRect(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0f to Color(0x332037FF),
                            .56f to Color(0x1A6E6E6E),
                            1f to Color(0x4D2037FF),
                        )
                    )
                )
            }
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "😁 Good day, mate!", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        Text(
            text = "Track your daily activity and stay healthy",
            fontSize = 14.sp,
            modifier = Modifier.alpha(.75f)
        )
        TodayCard(modifier = Modifier.fillMaxWidth(.25f))
        Text(text = "Today activity", modifier = Modifier.alpha(.75f), fontSize = 14.sp)

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Log workout")
        }

    }
}

@Composable
fun TodayCard(modifier: Modifier = Modifier) {
    val (month, dateOfMonth, dayOfWeek) = todaysDate()

    Card(
        modifier = Modifier,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = month,
                modifier = modifier.fillMaxWidth().background(color = Color.Black).padding(2.dp),
                color = Color.White,
                textAlign = TextAlign.Center,

                )
            Text(
                dateOfMonth,
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                dayOfWeek,
                modifier = modifier.fillMaxWidth().alpha(.75f).padding(bottom = 8.dp),
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ActivityCard(activityModel: ActivityModel) {
    Card(modifier = Modifier) {
        Icon(
            imageVector = activityModel.icon ?: Icons.Default.FavoriteBorder,
            contentDescription = ""
        )
        Text(text = activityModel.reps.toString(), fontWeight = FontWeight.Bold)
        Text(text = activityModel.name)
    }
}

