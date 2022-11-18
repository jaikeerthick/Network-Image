package com.jaikeerthick.networkimage.component

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImagePainter
import coil.compose.AsyncImagePainter.State
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ErrorResult
import coil.request.ImageRequest

/**
 * [NetworkImage] is a composable which uses [Coil] library under the hood to display
 * images from remote source with custom/default Loading, Error and Empty states
 * It executes an [ImageRequest] asynchronously and renders the result.
 *
 * @param modifier Modifier used to adjust the layout algorithm or draw decoration content.
 * @param url the remote url of the image needs to be fetched
 * @param contentDescription Text used by accessibility services to describe what this image
 *  represents. This should always be provided unless this image is used for decorative purposes,
 *  and does not represent a meaningful action that a user can take.
 *  @param alignment Optional alignment parameter used to place the [AsyncImagePainter] in the given
 *  bounds defined by the width and height.
 * @param contentScale Optional scale parameter used to determine the aspect ratio scaling to be
 *  used if the bounds are a different size from the intrinsic size of the [AsyncImagePainter].
 * @param alpha Optional opacity to be applied to the [AsyncImagePainter] when it is rendered
 *  onscreen.
 * @param colorFilter Optional [ColorFilter] to apply for the [AsyncImagePainter] when it is
 *  rendered onscreen.
 * @param filterQuality Sampling algorithm applied to a bitmap when it is scaled and drawn into the
 *  destination.
 * @param placeHolderContent A callback to draw the content when the image is on loading state.
 * @param errorContent A callback to draw the content when the image failed to load.
 * @param onLoading A callback to get notified when the [ImageRequest] started to load the image.
 * @param onError A callback to get notified when the [ImageRequest] returned error.
 * @param onSuccess A callback to get notified when the [ImageRequest] returned success.
 */
@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Crop,
    alpha: Float = 1f,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = FilterQuality.Medium,
    placeHolderContent: @Composable (BoxScope.() -> Unit)? = null,
    errorContent: @Composable (BoxScope.() -> Unit)? = null,
    onLoading: (() -> Unit)? = null,
    onError: ((ErrorResult) -> Unit)? = null,
    onSuccess: (() -> Unit)? = null,
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentDescription = contentDescription,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        filterQuality = filterQuality,
    ) {

        when (val state = painter.state) {

            is State.Loading -> {
                if (placeHolderContent != null) {
                    placeHolderContent()
                } else {
                    NetworkImageLoader()
                }
                onLoading?.let { onLoading() }
            }
            is State.Error -> {
                if (errorContent != null) {
                    errorContent()
                } else {
                    NetworkImageError()
                }
                onError?.let { onError(state.result) }
            }
            is State.Success -> {
                SubcomposeAsyncImageContent()
                onSuccess?.let { onSuccess() }
            }
            State.Empty -> {
                NetworkImageEmpty()
            }
        }

    }

}