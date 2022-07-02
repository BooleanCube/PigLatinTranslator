# Pig Latin Translator
> This Pig Latin Translator translates text from English to Pig Latin. This is a project I have been working on to make a completely working Pig Latin Translator API. This is a 1-way translator meaning it doesn't convert Pig Latin back to English and it only converts English to Pig Latin. To learn more about Pig Latin, you can look into this [article](https://www.tomedes.com/translator-hub/pig-latin). (Still a WIP).

## Installation
[![](https://jitpack.io/v/BooleanCube/PigLatinTranslator.svg)](https://jitpack.io/#BooleanCube/PigLatinTranslator)

Latest Release: [Github Releases](https://github.com/BooleanCube/PigLatinTranslator/releases)

Replace `VERSION` with the latest release in Jitpack. If you want to use SNAPSHOTS, please follow the instructions on the [Jitpack page](https://jitpack.io/#BooleanCube/PigLatinTranslator)

### Maven
#### Dependency
```xml
<dependencies>
    <dependency>
        <groupId>com.github.BooleanCube</groupId>
        <artifactId>PigLatinTranslator</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```
#### Repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

### Gradle
#### Dependency
```gradle
dependencies {
    implementation 'com.github.BooleanCube:PigLatinTranslator:VERSION'
}
```
#### Repository
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

## Documentation
`PigLatinTranslator` is the main static class with the #translateText() method to translate from English to Pig Latin.<br>

```java
/**
  * Translates english text into accurate pig latin text
  * @param sentence {@link String} body of text to be translated from english to pig latin
  * @return {@link String} body of text translated into pig latin from the given english statements
  */
PigLatinTranslator#translateText(String sentence);
```

----

### TODO:
- [ ] Make a translator for Pig Latin to English
- [X] Add the project to maven (if that is a possibility)
