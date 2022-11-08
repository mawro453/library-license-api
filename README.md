# Library License API

[![CI](https://github.com/mwrod453/library-license-api/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/mwrod453/library-license-api/actions/workflows/maven.yml)

This project provides a client for accessing license information for maven artifacts and npm packages.

Download
---
Maven:

```xml
<dependency>
    <groupId>io.github.mwrod453</groupId>
    <artifactId>library-license-api</artifactId>
    <version>${version}</version>
</dependency>
```

Gradle:

```groovy
compile 'io.github.mwrod45:library-license-api:${version}'
```

Usage
---
```java
LibraryLicenseApi api = LibraryLicenseApi.create();

String npmLicense = api.getNpmLicense("npm", "8.5.5");
String mvnLicense = api.getMvnLicense("org.apache.maven", "maven-artifact", "3.8.5");
```

License
---
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
