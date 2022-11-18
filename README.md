# Network-Image  
Latest version: [![](https://jitpack.io/v/jaikeerthick/network-image.svg)](https://jitpack.io/#jaikeerthick/network-image)

## Gradle Setup

```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    implementation 'com.github.jaikeerthick:Network-Image:<latest-version>'
}
```

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

<br/>
<br/>
<br/>

![](https://forthebadge.com/images/badges/built-with-love.svg)
    
## Contribution:
Fork the repo and create PRs 🦄
