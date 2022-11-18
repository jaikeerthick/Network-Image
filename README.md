# Network-Image 🖼️ 
Latest version: [![](https://jitpack.io/v/jaikeerthick/network-image.svg)](https://jitpack.io/#jaikeerthick/network-image)

A Jetpack Compose library to fetch images from remote-sources and display it. It supports event handling like ```onLoading```, ```onError``` and ```onSuccess``` and also the main feature is one can easily provide ui for these events as a param directly.

## Gradle Setup

```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    implementation 'com.github.jaikeerthick:Network-Image:v<latest-version>' // sample: v1.0.1
}
```
## Why Network-Image ?

Loading, Error and Success states will be cleanly handled with different ui composables for each by default. The coolest feature is now one can provide
the ui for these states as a param 😍

So simple. right? Let's see how simple it is

## Usage
    
Use it as a replacement for Image composable which needs to fetch image from remote-source via url

```kotlin
NetworkImage(
    modifier = Modifier
        .fillMaxWidth()
        .height(400.dp),
    url = "https://cdn.dribbble.com/users/721278/screenshots/15785802/astronauts_dribbble.png",
    contentScale = ContentScale.Crop
)
```

## Custom States ✨

### Loading State

When the image is loading, we might need a placeholder to be displayed. So we use ```placeHolderContent``` which is nullable. If passed, 
then the ```NetworkImage``` will display that, otherwise the default loader will be used

```kotlin
NetworkImage(
    modifier = Modifier
        .size(100.dp),
    url = "https://cdn.dribbble.com/users/721278/screenshots/15785802/astronauts_dribbble.png",
    placeHolderContent = {
        Image(
            painter = painterResource(id = R.drawable.placeholder),
            contentDescription = "placeholder"
        )
    }
)
```


### Error State

When the image got failed to load or some error happened, we should display an error icon or message to notify the user. So we use ```errorContent``` which is also nullable. If passed, then the ```NetworkImage``` will display that, otherwise the default error ui will be used

```kotlin
NetworkImage(
    modifier = Modifier
        .size(100.dp),
    url = "https://cdn.dribbble.com/users/721278/screenshots/15785802/astronauts_dribbble.png",
    errorContent = {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = "error"
        )
    }
)
```

## Listen to Events

One can also listen to events like: ```onLoading```, ```onError``` and ```onSuccess``` like below

```kotlin
NetworkImage(
    modifier = Modifier
        .size(100.dp),
    url = "https://cdn.dribbble.com/users/721278/screenshots/15785802/astronauts_dribbble.png",
    onLoading = {  },
    onError = {  },
    onSuccess = {  },
)
```


<br/>
<br/>
<br/>

![](https://forthebadge.com/images/badges/built-with-love.svg)
    
## Contribution:
Fork the repo and create PRs 🦄
