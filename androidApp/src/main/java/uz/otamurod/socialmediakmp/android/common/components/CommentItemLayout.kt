package uz.otamurod.socialmediakmp.android.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import uz.otamurod.socialmediakmp.android.common.theming.LargeSpacing
import uz.otamurod.socialmediakmp.android.common.theming.MediumSpacing

@Composable
fun CommentItemLayout(
    modifier: Modifier,
    image: @Composable () -> Unit,
    username: @Composable () -> Unit,
    date: @Composable () -> Unit,
    moreIcon: @Composable () -> Unit,
    commentText: @Composable () -> Unit
) {
    Layout(
        contents = listOf(
            image,
            username,
            date,
            moreIcon,
            commentText
        ),
        modifier = modifier
            .padding(
                top = LargeSpacing,
                bottom = LargeSpacing,
                start = LargeSpacing,
                end = MediumSpacing
            )
    ) { (imageMeasurables, usernameMeasurables, dateMeasurables, moreIconMeasurables, commentTextMeasurables), constraints ->

        val imagePlaceable = imageMeasurables.first().measure(constraints)
        val usernamePlaceable = usernameMeasurables.first().measure(constraints)
        val datePlaceable = dateMeasurables.first().measure(constraints)
        val moreIconPlaceable = moreIconMeasurables.first().measure(constraints)

        val commentTextConstraints = constraints.copy(
            maxWidth = constraints.maxWidth - (24.dp.roundToPx() + imagePlaceable.width)
        )

        val commentTextPlaceable = commentTextMeasurables.first().measure(commentTextConstraints)

        val totalHeight = maxOf(
            imagePlaceable.height,
            (usernamePlaceable.height + commentTextPlaceable.height)
        )

        layout(width = constraints.maxWidth, height = totalHeight) {
            imagePlaceable.placeRelative(x = 0, y = 0)

            usernamePlaceable.placeRelative(
                x = imagePlaceable.width + (8.dp.roundToPx()),
                y = 0
            )

            datePlaceable.placeRelative(
                x = imagePlaceable.width + usernamePlaceable.width + (16.dp.roundToPx()),
                y = 3.dp.roundToPx()
            )

            moreIconPlaceable.placeRelative(
                x = (constraints.maxWidth) - (moreIconPlaceable.width),
                y = 0
            )

            commentTextPlaceable.place(
                x = imagePlaceable.width + (8.dp.roundToPx()),
                y = usernamePlaceable.height + (2.dp.roundToPx())
            )
        }
    }
}