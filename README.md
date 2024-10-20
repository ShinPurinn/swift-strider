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

* [`background`](app/src/main/java/com/kel2/swiftstrider/background): Handles background related
  process like service.
* [`data`](app/src/main/java/com/kel2/swiftstrider/data): Responsible for producing data. Contains
  entity, database and tracking related classes.
    * [`tracking`](app/src/main/java/com/kel2/swiftstrider/data/tracking): Classes that handles
      tracking like location tracking.
* [`di`](app/src/main/java/com/kel2/swiftstrider/di) : Hilt Modules.
* [`domain`](app/src/main/java/com/kel2/swiftstrider/domain): Contains common use case and
  interfaces.
* [`ui`](app/src/main/java/com/kel2/swiftstrider/ui): UI Layer of the app.
    * `nav`: Contains app navigation and destinations.
    * `screen`: Contains UI.
    * `theme`: Material3 theme.
    * `common`: UI utility classes and common components.
* [`common`](app/src/main/java/com/kel2/swiftstrider/common): Utility class used across the app.

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
