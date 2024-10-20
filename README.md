# Swift Strider

Swift Strider is a Fitness Tracking app utilizing modern Android technologies, including
Jetpack Compose, MVVM architecture, and Google Maps API. The app allows users to
track their running activities, displaying real-time routes on an interactive map
while storing essential statistics using Room database.

## Features
1. Live tracking of running activity using GPS.
2. Tracking of user's running path in Map using Google Map Compose library.
3. Using Foreground Service, even the user closed the app and remove
   from the background, this app stills continue to track user running stats.
4. Room database to store and manage running statistics.
5. Handling nested navigation, Deep linking, conditional navigation to on
   boarding screen using Jetpack Navigation Component.
6. New Jetpack Compose image picker - helps to pick image
   without any permission.
7. Paging3 integration.
8. Dynamic color support in dark and light theme.
9. Weekly Statistics with filters in graph.

## Package Structure

* [`background`](app/src/main/java/com/kel2/SwiftStrider/background): Handles background related
  process like service.
* [`data`](app/src/main/java/com/kel2/SwiftStrider/data): Responsible for producing data. Contains
  entity, database and tracking related classes.
    * [`tracking`](app/src/main/java/com/kel2/SwiftStrider/data/tracking): Classes that handles
      tracking like location tracking.
* [`di`](app/src/main/java/com/kel2/SwiftStrider/di) : Hilt Modules.
* [`domain`](app/src/main/java/com/kel2/SwiftStrider/domain): Contains common use case and
  interfaces.
* [`ui`](app/src/main/java/com/kel2/SwiftStrider/ui): UI Layer of the app.
    * `nav`: Contains app navigation and destinations.
    * `screen`: Contains UI.
    * `theme`: Material3 theme.
    * `common`: UI utility classes and common components.
* [`common`](app/src/main/java/com/kel2/SwiftStrider/common): Utility class used across the app.

## Build With

[Kotlin](https://kotlinlang.org/):
As the programming language.

[Jetpack Compose](https://developer.android.com/jetpack/compose) :
To build UI.

[Jetpack Navigation](https://developer.android.com/jetpack/compose/navigation) :
For navigation between screens and deep linking.

[Room](https://developer.android.com/jetpack/androidx/releases/room) :
To store and manage running statistics.

[Google Maps API](https://developers.google.com/maps/documentation/android-sdk) :
To track user's running activity such as speed, distance and path on the map.

[Hilt](https://developer.android.com/training/dependency-injection/hilt-android) :
For injecting dependencies.

[Preferences DataStore](https://developer.android.com/topic/libraries/architecture/datastore) :
To store user related data.

[Coil](https://coil-kt.github.io/coil/compose/) :
To load image asynchronously.

[Vico](https://patrykandpatrick.com/vico/) :
To show graphs in statistics screen.

## Architecture

This app follows MVVM architecture, Uni Directional Flow (UDF) pattern and Single architecture
pattern.
HLD of tracking architecture is shown in the below image:
![tracking_architecture](https://github.com/kel2/run-track/assets/130966261/932e9df7-cf34-4902-aa84-73a6431ca236)

## Installation

Simple clone this app and open in Android Studio.

### Google Map Integration

Do these steps if you want to show google maps. The tracking
functionalities will work as usual even if you don't do
these step.

1. Create and Get Google Maps API key by using this official
   [guide](https://developers.google.com/maps/documentation/android-sdk/get-api-key)
2. Open `local.properties` file.
3. Enter your API key like this:

```
MAPS_API_KEY=your_maps_api_key
```

## Project Status

These features are left to be implemented:

1. Profile menu implementation.
2. Unit Tests
3. Currently, we are storing (maps screenshot) bitmap directly into db in form of bytes
   which is not good. Save the image to the storage and store only its uri or id.
4. App Icon
5. Suitable markers for the start, end, and current position.
