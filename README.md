# _Cuisine Catalog_

#### _An Archive of Recipes and Reviews of Food built in Android Studio. How good is food!?!, 03/16/2018_

#### By _**Ross Fletcher**_


## Specs

| Behaviour | Input  | Output  |
|---|---|---|
| A user can view a homepage with about/bio and drawer menu with user profile features, saved recipes, and a leave feedback path | User views main activity  | User sees main activity page with about/bio section and drawer menu features, user profile features, saved recipes, and a leave feedback path  |
| A user can view a list of recipes from the edamam api, site created recipes, and their saved recipes.  | User selects specific cuisine from cuisine list activity  | User sees list of recipes within that cuisine  |
| A user can see input/reviews of a recipe  | User clicks on a recipe  | User sees recipe, along with comments and reviews on the recipe  |
| A user can login or create an account with account info through Firebase.  | User opens app  | User arrives at login feature to register a user name and pw or login with previously created user name and pw |
| A admin can login and add, edit or delete a recipe  |  Admin visits admin area and logs in | Admin sees list of all recipes and posts and has ability to edit or delete recipes/posts  |
| A user can reorder their favs/saved list |   |   |
| A user can remove a recipe from their favs/saved list with swipe gesture |   |   |
| A user  |   |   |

## Setup/Installation Requirements

* _Clone or fork project_
#### Firebase Setup
* _If you dont have a firebase account create one [@Firebase](https://firebase.google.com/), create a new project, assigning it the SHA-1 key found in the signing report pictured [here](https://github.com/rossfletcher19/CuisineCatalog/blob/master/app/src/main/res/drawable/sha.gif)_
* _Place the google-services.json in the app module root directory._
* _Re-sync project with gradle and move onto API setup._
#### API Setup
* _Create a free developer account for the Recipe Search API at [@Edamam](https://developer.edamam.com/edamam-recipe-api)_
* _Create a gradle.properies file in the CuisinCatalog project directory and place your ID and KEY in the format below._
* _Use Android Studio to let project gradle build and then create a new virtual device with AVD manager_
* _Run app on virtual device, let the emulator start up to display the app._

```
EdamamId = "id"
EdamamKey = "key"
```

## UX/UI
  * Develop custom style

## Polish
  * Refactor
  * Delete unused
  * Make README awesome

## Known Bugs

_none currently_

## Support and contact details

_Contact Ross Fletcher @ rtbfletch at outlook dot com, with any questions or input and thank you!_

## Technologies Used

* _Android Studio_
* _Java_
* _Android Virtual Device Manager_
* _Git and GitHub_

### License

Copyright (c) 2018 **_Ross Fletcher_**

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.