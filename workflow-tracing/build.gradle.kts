/*
 * Copyright 2019 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
  `java-library`
  kotlin("jvm")
  id("com.vanniktech.maven.publish")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

apply(from = rootProject.file(".buildscript/configure-maven-publish.gradle"))

dependencies {
  compileOnly(Dependencies.Annotations.intellij)

  api(project(":trace-encoder"))
  api(project(":workflow-runtime"))
  api(Dependencies.Kotlin.Stdlib.jdk6)
  api(Dependencies.Kotlin.Coroutines.core)

  implementation(Dependencies.Kotlin.reflect)
  implementation(Dependencies.Kotlin.moshi)
  implementation(Dependencies.okio)
  implementation(Dependencies.moshi)

  testImplementation(Dependencies.Kotlin.Test.jdk)
  testImplementation(Dependencies.Kotlin.Test.mockito)
}
