
# uWatch

Movie Application Made using Kotlin with Jetpack Compose and TMDB API


![Logo](https://raw.githubusercontent.com/RacimFethallah/uWatch/main/app/src/main/res/mipmap-xxxhdpi/ic_launcher.webp)


## Screenshots

![App Screenshot](https://raw.githubusercontent.com/RacimFethallah/uWatch/main/Screenshots/Screenshot_20240525-181218_uWatch.png)

![App Screenshot](https://raw.githubusercontent.com/RacimFethallah/uWatch/main/Screenshots/Screenshot_20240525-181222_uWatch.png)

## Features

- Light/dark mode toggle
- Live previews
- Latest Trending movies
- Movie details


## Technologies

- Kotlin
- Jetpack Compose
- Retrofit
- Dagger - Hilt
- Coil (For images preview)
- Paging
## Environment Variables

To run this project, you will need to create an apikey.properties file to your root project, and add the following environment variables to your apikey.properties file

`API_KEY = "Your api_key here"`

then add this code to your app level build.gradle file, in the default config section:


```
val keystoreFile = rootProject.file("apikey.properties")
val properties = Properties()
if (keystoreFile.exists()) {
    properties.load(keystoreFile.inputStream())
    }
val apiKey = properties.getProperty("API_KEY") ?: ""
    buildConfigField(
            type = "String",
            name = "API_KEY",
            value = apiKey
    )
```

and this line in the buildFeatures section:
`buildConfig =  true`

don't forget to add the apiket.properties to your .gitignore file

