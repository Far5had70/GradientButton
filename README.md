# Gradient Button

<img src="https://raw.githubusercontent.com/Far5had70/GradientButton/master/example.jpg" height="480" width="270">


<img src="https://raw.githubusercontent.com/Far5had70/GradientButton/master/item.png">

 GradientButton is a custom Button Gradient.


# Features

Background (start color , end color)

Text (size , color)

Radius (background)

TypeFace(directory: Assets/sampleFont.ttf)




# Installation

Step 1. Add the JitPack repository to your build file


Add it in your root build.gradle at the end of repositories:

```gradle
	dependencies {
	        implementation 'com.github.Far5had70:GradientButton:1.0.0'
	}
```


Step 2. Add the dependency
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```




## Demo

You can try it out here [Sample Application](https://github.com/Far5had70/GradientButton/blob/master/app/src/main/java/com/farshad/gradientbutton/MainActivity.java)




# Usage



**Example:**

```xml
        <com.waspar.gradientbutton.GradientButton
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="50dp"
        android:layout_marginRight="50dp"
        android:layout_marginLeft="50dp"
        app:Radius="30dp"
        app:setText="Test"
        app:textSize="14sp"
        app:startColor="@color/colorBlue_A400"
        app:endColor="@color/colorBlue_900"
        app:textColor="#fff"
        />
```




# Developed By

Farshad Asgharzadeh

For contact, shoot me an email at ferik800@gmail.com
