# Mockk

## Install mockk using maven

```xml
<dependency>
    <groupId>io.mockk</groupId>
    <artifactId>mockk</artifactId>
    <version>1.9.3</version>
    <scope>test</scope>
</dependency>
```

## How to mock
```kotlin
val service = spyk<TestableService>()
every { service.getDataFromDb(any()) } returns "Mocked Output"
```